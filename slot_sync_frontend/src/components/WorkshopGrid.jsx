// WorkshopGrid.jsx

import React from 'react';
import './WorkshopGrid.css'; // Import CSS for styling

const WorkshopGrid = ({title, description, date, time, duration, rating, availableSlots }) => {
  return (
    <div className="workshop-item">
      <h2>{title}</h2>
      <p>{description}</p>
      <ul>
        <li>Date: {date}</li>
        <li>Time: {time}</li>
        <li>Duration: {duration}</li>
        <li>Rating: {rating}</li>
        <li>Available Slots: {availableSlots}</li>
      </ul>
    </div>
  );
};

export default WorkshopGrid;
