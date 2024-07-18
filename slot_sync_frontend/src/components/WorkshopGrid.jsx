import React, { useState, useEffect } from 'react';
import './WorkshopGrid.css'; // Import CSS for styling
import { getSlotImage } from '../api/SlotSyncApiService.js';

const WorkshopGrid = ({ title, description, date, time, duration, rating, availableSlots, imageUrl }) => {
  const [image, setImage] = useState(''); // Initialize with ''

  useEffect(() => {
    const fetchImage = async () => {
      try {
        const response = await getSlotImage(imageUrl);
        const blob = new Blob([response.data], { type: response.headers['content-type'] });
        const imageName = URL.createObjectURL(blob);
        setImage(imageName);
      } catch (error) {
        console.error('Error fetching the image:', error);
      }
    };

    fetchImage();
  }, [imageUrl]);

  return (
    <div className="workshop-item">
      <div className="workshop-image-container">
        <img src={image} alt={title} className="workshop-image" />
        <div className="overlay">
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
      </div>
    </div>
  );
};

export default WorkshopGrid;
