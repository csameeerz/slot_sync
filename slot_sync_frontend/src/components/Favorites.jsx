import React, { useEffect, useState } from 'react';
import './Favorites.css';
import { deleteFromFavourites, showFavourites } from '../api/SlotSyncApiService';
import { useAuth } from '../security/AuthContext.jsx';

export default function Favorites() {
    const authContext = useAuth();
    const [slots, setSlots] = useState([]);

  useEffect(() => {
    fetchFavourites();
  }, []);

  const fetchFavourites = async () => {
    try {
      const response = await showFavourites(authContext.id);
      setSlots(response.data.data);
    } catch (error) {
      console.error('Error fetching favourites:', error);
    }
  };

  const handleUnfavourite = async (slotId) => {
    try {
        const favouriteRequest = {
            slotId: slotId,
        };
      const response = await deleteFromFavourites(authContext.id, favouriteRequest);
      if (response.status == 200) {debugger;
        setSlots(slots.filter(slot => slot.id !== slotId));
        fetchFavourites();
      } else {
        console.error('Error unfavouriting slot');
      }
    } catch (error) {
      console.error('Error unfavouriting slot:', error);
    }
  };

  return (
    <div className="favourites-container">
      {slots.map(slot => (
        <div key={slot.id} className="slot-item">
          <span>{slot.title}</span>
          <button onClick={() => handleUnfavourite(slot.id)}>Unfavourite</button>
        </div>
      ))}
    </div>
  );
}