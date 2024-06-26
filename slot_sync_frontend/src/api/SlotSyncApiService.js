import { apiClient } from "./ApiClient";

export const signin
                = (signinRequest) => apiClient.post(`/api/auth/signin`, signinRequest);

export const signup
                = (signupRequest) => apiClient.post(`/api/auth/signup`, signupRequest);
                
export const fetchUserByUsername
                = (username) => apiClient.get(`/api/users/username/${username}`); 

export const verifyUsername
                = (username) => apiClient.get(`/api/users/verify/username/${username}`); 