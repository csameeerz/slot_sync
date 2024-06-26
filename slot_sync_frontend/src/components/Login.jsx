import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import { useAuth } from '../security/AuthContext.jsx';
import './Login.css';

export default function Login() {
    const authContext = useAuth();
    const navigate = useNavigate();
    const [username, setUsername] = useState(authContext.username);
    const [password, setPassword] = useState('');
    const [showFailedMessage, setShowFailedMessage] = useState(false);

    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function goToSignupPage() {
        navigate(`/signup`);
    }

    async function goToHomePage() {
        if (await authContext.login(username, password)) {
            setShowFailedMessage(false);
            navigate(`/home`);
        } else {
            setShowFailedMessage(false);
            setTimeout(() => setShowFailedMessage(true), 0);
        }
    }

    return (
        <div className="login-container">
            <div className="login-box">
                <div className="login-form-container">
                    <span>Login</span>
                    <div>
                        <div className="form-group">
                            <input type="text" id="username" name="username" placeholder="Username" value={username} onChange={handleUsernameChange} />
                        </div>
                        <div className="form-group">
                            <input type="password" id="password" name="password" placeholder="Password" value={password} onChange={handlePasswordChange} />
                        </div>
                        <button type="button" className="login-button-2" onClick={goToHomePage}>Sign In</button>
                    </div>
                    <div className="signup-link">
                        <button type="button" className="signup-button" onClick={goToSignupPage}>New User ?</button>
                    </div>
                    {showFailedMessage && <div className="failedMessage">Invalid Credentials</div>}
                </div>
            </div>
        </div>
    );
}