import React from 'react';
import PaletteSyncLogo from '../assets/logo/PaletteSyncLogo.png';
import { ReactComponent as ProfileIcon } from '../assets/icons/profileIcon.svg';
import './Header.css';
import { useAuth } from '../security/AuthContext.jsx';

export default function Header() {
    const authContext = useAuth();

    return (
        <header className={`header ${!authContext.isLoggedIn ? 'centered' : ''}`}>
            <div className="header-left">
                <img src={PaletteSyncLogo} alt="Logo" className="logo" />
                <span className="logo-text">
                    <span className="logo-text-palette">Palette</span>
                    <span className="logo-text-sync">Sync</span>
                </span>
            </div>
            <nav className="header-center">
                {authContext.isLoggedIn && authContext.role === 'ROLE_USER' && (
                    <>
                        <a href="#home" className="nav-link">Home</a>
                        <a href="#workshops" className="nav-link">Workshops</a>
                        <a href="#bookings" className="nav-link">Bookings</a>
                        <a href="#favourites" className="nav-link">Favourites</a>
                    </>
                )}
                {authContext.isLoggedIn && authContext.role === 'ROLE_ADMIN' && (
                    <>
                        <a href="#home" className="nav-link">Home</a>
                        <a href="#workshops" className="nav-link">Workshops</a>
                        <a href="#bookings" className="nav-link">Bookings</a>
                        <a href="#dashboard" className="nav-link">Dashboard</a>
                    </>
                )}
            </nav>
            {authContext.isLoggedIn && (
                <div className="header-right">
                    <ProfileIcon className="profile-icon" />
                    <button className="logout-button">Logout</button>
                </div>
            )}
        </header>
    );
}