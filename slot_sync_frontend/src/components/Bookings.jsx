import React, { useEffect, useState } from 'react';
import './Bookings.css';
import { getBookedSlotsByUser } from '../api/SlotSyncApiService';
import { useAuth } from '../security/AuthContext.jsx';

export default function Bookings() {
    const [bookings, setBookings] = useState([]);
    const authContext = useAuth();

    function refreshBookings() {
        getBookedSlotsByUser(authContext.id)
            .then(response => setBookings(response.data.data))
            .catch(error => console.error('Error fetching bookings:', error));
    }

    useEffect(() => {
        refreshBookings();
        }, []
    );

    const formatDate = (dateString) => {
        const options = { year: 'numeric', month: 'long', day: 'numeric', hour: 'numeric', minute: 'numeric', second: 'numeric' };
        return new Date(dateString).toLocaleDateString(undefined, options);
    };

    return (
        <div className="bookings-container">
            {bookings.length > 0 ? (
                bookings.map((booking) => (
                    <div key={booking.id} className="booking-item">
                        <div className="booking-details">
                            <h3 className="workshop-name">Workshop Slot {booking.slotId}</h3>
                            <p className="date-booked">{formatDate(booking.date)}</p>
                        </div>
                        <div className="booking-status">
                            {booking.status === 'CONFIRMED' ? (
                                <button className="status-button confirmed">
                                    Confirmed <span className="cancel-icon">❌</span>
                                </button>
                            ) : (
                                <button className="status-button cancelled">Cancelled</button>
                            )}
                        </div>
                    </div>
                ))
            ) : (
                <p>No bookings found.</p>
            )}
        </div>
    );
}