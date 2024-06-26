import { createContext, useContext, useState } from "react";
import { signin } from "../api/SlotSyncApiService.js";
import { apiClient } from "../api/ApiClient.js";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
    const [isLoggedIn, setLoggedIn] = useState(false);
    const [username, setUsername] = useState(null);
    const [email, setEmail] = useState(null);
    const [id, setId] = useState(null);
    const [name, setName] = useState(null);
    const [token, setToken] = useState(null);
    const [role, setRole] = useState(null);

    async function login(currUsername, currPassword) {
        try {
            const signinRequest = {
                username: currUsername,
                password: currPassword
            };

            const response = await signin(signinRequest);

            if (response.status === 200) {
                setLoggedIn(true);
                setUsername(currUsername);
                setToken(response.data.accessToken);
                setEmail(response.data.email);
                setId(response.data.id);
                setName(response.data.name);debugger;
                setRole(response.data.roles[0]);
                apiClient.interceptors.request.use(
                    (config) => {
                        config.headers.Authorization = `Bearer ${response.data.accessToken}`;
                        return config;
                    }
                )
                return true;
            } else {
                logout();
                return false;
        }
        } catch(error) {
            logout();
            return false;
        }
    }

    function logout() {
        setLoggedIn(false);
        setToken(null);
        setUsername(null);
        setEmail(null);
        setId(null);
        setName(null);
    }

    return (
        <AuthContext.Provider value={ {isLoggedIn, login, logout, username, token, email, id, name, role} }>
            { children }
        </AuthContext.Provider>
    );
}