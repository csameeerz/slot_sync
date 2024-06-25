import React from 'react';
import PaletteSyncLogo from '../assets/logo/PaletteSyncLogo.png'
import { ReactComponent as ProfileIcon } from '../assets/icons/profileIcon.svg';
import './Header.css';

export default function Header() {
    return (
          <header className="header">
              <div className="header-left">
                  <img src={PaletteSyncLogo} alt="Logo" className="logo" />
                  <span className="logo-text">
                      <span className="logo-text-palette">Palette</span>
                      <span className="logo-text-sync">Sync</span>
                  </span>
              </div>
              <nav className="header-center">
                  <a href="#home" className="nav-link">Home</a>
                  <a href="#workshops" className="nav-link">Workshops</a>
                  <a href="#bookings" className="nav-link">Bookings</a>
                  <a href="#favourites" className="nav-link">Favourites</a>
              </nav>
              <div className="header-right">
                  <ProfileIcon className="profile-icon" />
                  <button className="logout-button">Logout</button>
              </div>
          </header>
      );
}