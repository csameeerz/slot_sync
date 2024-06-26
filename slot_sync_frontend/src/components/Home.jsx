import React from 'react';
import { useAuth } from '../security/AuthContext.jsx';
import './Home.css';

export default function Home() {
    const authContext = useAuth();

    return (
        <div className="home-container">
            <div className="art-animation">
                {/* Insert your art-related animation or artwork here */}
                <h1>Welcome to Art Studio</h1>
                <p>Discover creativity in motion</p>
            </div>
            <div className="services-container">
                <div className="service-box workshops">
                    <h2>Workshops</h2>
                    <p>Join our creative workshops to learn and explore various art forms.</p>
                </div>
                <div className="service-box bookings">
                    <h2>Bookings</h2>
                    <p>Book a session with our expert artists for personalized art experiences.</p>
                </div>
            </div>
        </div>
    );
}