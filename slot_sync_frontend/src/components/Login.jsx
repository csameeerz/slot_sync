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
        <div className="login-container-page">
            <div className="login-box">
                <div className="login-form">
                    <span>Login</span>
                    <div>
                        <div className="form-field">
                            <input type="text" id="username" name="username" placeholder="Username" value={username} onChange={handleUsernameChange} />
                        </div>
                        <div className="form-field">
                            <input type="password" id="password" name="password" placeholder="Password" value={password} onChange={handlePasswordChange} />
                        </div>
                        <button type="button" className="login-button-signin" onClick={goToHomePage}>Sign In</button>
                        <button type="button" className="signup-button-newuser" onClick={goToSignupPage}>Signup</button>
                    </div>
                    {showFailedMessage && <div className="failedMessage">Invalid Credentials</div>}
                </div>
            </div>
        </div>
    );
}