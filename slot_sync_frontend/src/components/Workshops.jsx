import React, { useState, useEffect, useRef, useCallback } from 'react';
import './Workshops.css';
import { bookSlot, fetchAllSlots } from '../api/SlotSyncApiService';
import WorkshopGrid from './WorkshopGrid';
import BookModal from './BookModal.jsx';
import { useAuth } from '../security/AuthContext.jsx';

export default function Workshops() {
  const authContext = useAuth();
  const [searchQuery, setSearchQuery] = useState('');
  const [workshops, setWorkshops] = useState([]);
  const [displayedWorkshops, setDisplayedWorkshops] = useState([]);
  const [page, setPage] = useState(1);
  const [hasMore, setHasMore] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [selectedWorkshop, setSelectedWorkshop] = useState(null);
  const observer = useRef();

  useEffect(() => {
    const fetchWorkshops = async () => {
      try {
        const response = await fetchAllSlots();
        const data = await response.data.data;
        setWorkshops(data);
        setDisplayedWorkshops(data.slice(0, 6));
        if (data.length <= 6) {
          setHasMore(false);
        }
      } catch (error) {
        console.error('Error fetching workshops:', error);
      }
    };

    fetchWorkshops();
  }, []);

  const lastWorkshopElementRef = useCallback((node) => {
    if (observer.current) observer.current.disconnect();
    observer.current = new IntersectionObserver((entries) => {
      if (entries[0].isIntersecting && hasMore) {
        setPage((prevPage) => prevPage + 1);
      }
    });
    if (node) observer.current.observe(node);
  }, [hasMore]);

  const handleSearch = (event) => {
    const query = event.target.value;
    setSearchQuery(query);

    if (query === '') {
      setDisplayedWorkshops(workshops.slice(0, 6));
      setHasMore(true);
    } else {
      const filteredWorkshops = workshops.filter((workshop) =>
        workshop.title.toLowerCase().includes(query.toLowerCase())
      );
      setDisplayedWorkshops(filteredWorkshops.slice(0, 6));
      setHasMore(filteredWorkshops.length > 6);
    }

    setPage(1);
  };

  useEffect(() => {
    if (page > 1) {
      const start = (page - 1) * 6;
      const end = page * 6;

      if (searchQuery === '') {
        setDisplayedWorkshops((prevWorkshops) => [
          ...prevWorkshops,
          ...workshops.slice(start, end),
        ]);
      } else {
        const filteredWorkshops = workshops.filter((workshop) =>
          workshop.title.toLowerCase().includes(searchQuery.toLowerCase())
        );
        setDisplayedWorkshops((prevWorkshops) => [
          ...prevWorkshops,
          ...filteredWorkshops.slice(start, end),
        ]);
      }
    }
  }, [page, workshops, searchQuery]);

  const formatDate = (dateTimeString) => {
    const dateTime = new Date(dateTimeString);
    const date = dateTime.toLocaleDateString('en-GB', {
      day: 'numeric',
      month: 'numeric',
      year: 'numeric',
    });
    return `${date}`;
  };

  const calculateAverageRating = (currRating, noOfRating) => {
    if (noOfRating === 0) return 'N/A';
    const average = currRating / noOfRating;
    return average.toFixed(1);
  };

  const handleWorkshopClick = (workshop) => {
    setSelectedWorkshop(workshop);
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
  };

  const handleConfirmModal = async () => {
    try {
      const bookingRequest = {
        userId: authContext.id,
        slotId: selectedWorkshop.id,
      };
      await bookSlot(bookingRequest);
      setShowModal(false);
      alert('Workshop confirmed!');
    } catch (error) {
      console.error('Error confirming workshop:', error);
      alert('Failed to confirm the workshop.');
    }
  };

  return (
    <div className="workshops-container">
      <div className="search-bar">
        <input
          type="text"
          placeholder="Search workshops..."
          value={searchQuery}
          onChange={handleSearch}
        />
      </div>
      <div className="workshops-grid">
        {displayedWorkshops.map((workshop, index) => (
          <div
            key={workshop.id}
            ref={index === displayedWorkshops.length - 1 ? lastWorkshopElementRef : null}
            className="workshop-card"
            onClick={() => handleWorkshopClick(workshop)} // Add onClick event
          >
            <WorkshopGrid
              key={workshop.id}
              title={workshop.title}
              description={workshop.description}
              date={formatDate(workshop.date)}
              duration={workshop.duration}
              rating={calculateAverageRating(workshop.currRating, workshop.noOfRating)}
              availableSlots={workshop.maxParticipants - workshop.currParticipants}
            />
          </div>
        ))}
        {searchQuery !== '' && displayedWorkshops.length === 0 && (
          <div className="no-results">
            <p>No workshops found matching "{searchQuery}"</p>
          </div>
        )}
      </div>
      <BookModal show={showModal} handleClose={handleCloseModal} handleConfirm={handleConfirmModal} />
    </div>
  );
}
