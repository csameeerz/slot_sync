import React from 'react';
import CardRail from './CardRail.jsx';
import './Landing.css';

export default function Landing() {
    return (
        <div className="landing-container">
            <div className="heading">
                <div className="heading-line">Uniting Artists</div>
                <div className="heading-line">Inspiring Creativity</div>
            </div>
            <div className="tagline">
                <p className="tagline-line">Browse through PaletteSync's diverse range of workshops</p>
            </div>
            <button className="login-button">
                <span>Login</span>
            </button>
            <CardRail />
        </div>
    );
}