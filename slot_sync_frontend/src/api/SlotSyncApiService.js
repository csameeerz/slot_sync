import { apiClient } from "./ApiClient";

export const signin
                = (signinRequest) => apiClient.post(`/api/auth/signin`, signinRequest);

export const signup
                = (signupRequest) => apiClient.post(`/api/auth/signup`, signupRequest);
                
export const fetchUserByUsername
                = (username) => apiClient.get(`/api/users/username/${username}`); 

export const verifyUsername
                = (username) => apiClient.get(`/api/users/verify/username/${username}`);
                
export const fetchAllSlots
                = () => apiClient.get(`/api/slots`); 

export const rateSlotById
                = (slotId, ratingRequest) => apiClient.put(`/api/slots/rating/${slotId}`, ratingRequest); 

export const bookSlot
                = (bookingRequest) => apiClient.post(`/api/bookings`, bookingRequest);

export const getBookedSlotsByUser
                = (userId) => apiClient.get(`/api/bookings/users/${userId}`);

export const addToFavourites
                = (userId, favouriteRequest) => apiClient.put(`/api/users/id/${userId}/favourites`, favouriteRequest);

export const showFavourites
                = (userId) => apiClient.get(`/api/users/id/${userId}/favourites`);

export const deleteFromFavourites
                = (userId, favouriteRequest) => apiClient.put(`/api/users/id/${userId}/favourites/remove`, favouriteRequest);

export const getSlotImage
                = (imageName) => apiClient.get(`/api/slots/view/images/${imageName}`, {
                    responseType: 'arraybuffer',
                });

export const getSlotImageById
                = (slotId) => apiClient.get(`/api/slots/view/images/id/${slotId}`, {
                    responseType: 'arraybuffer',
                });

export const changeBookingStatus
                = (bookingId, statusRequest) => apiClient.put(`/api/bookings/${bookingId}`, statusRequest);
