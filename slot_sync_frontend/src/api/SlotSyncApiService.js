import { apiClient } from "./ApiClient";

export const basicAuthExecution
                = (token) => apiClient.get(`/basicAuth`, {
                    headers: {
                        Authorization: token
                    }
                }); 

export const createTaskApi
                = (username, task) => apiClient.post(`/users/${username}/tasks`, task);