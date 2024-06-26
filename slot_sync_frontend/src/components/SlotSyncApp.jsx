import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import AuthProvider, { useAuth } from '../security/AuthContext.jsx';
import Landing from './Landing.jsx';
import Home from './Home.jsx';
import Error from './Error.jsx';
import Signup from './Signup.jsx';
import Login from './Login.jsx';
import Logout from './Logout.jsx';
import Header from './Header.jsx';
import Footer from './Footer.jsx';
import './SlotSyncApp.css';

function LoggedInRoute({ children }) {
    const authContext = useAuth();

    if (authContext.isLoggedIn) {
        return children;
    } else {
        return <Navigate to="/" />;
    }
}

function LoggedOutRoute({ children }) {
    const authContext = useAuth();

    if (authContext.isLoggedIn) {
        authContext.logout();
    }
    return children;
}

export default function SlotSyncApp() {
    return (
        <div className="slotsync">
        <AuthProvider>
            <BrowserRouter>
                <Header />
                <div className="content">
                    <Routes>
                        <Route path='/' element={ <LoggedOutRoute><Landing /></LoggedOutRoute> } />
                        <Route path='/login' element={ <LoggedOutRoute><Login /></LoggedOutRoute> } />
                        <Route path='/signup' element={ <LoggedOutRoute><Signup /></LoggedOutRoute> } />
                        <Route path='/home' element={ <LoggedInRoute><Home /></LoggedInRoute> } />
                        {/* <Route path='/tasks' element={ <LoggedInRoute><ShowTasksComponent /></LoggedInRoute> } /> */}
                        {/* <Route path='/task/:id' element={ <LoggedInRoute><TaskComponent /></LoggedInRoute> } /> */}
                        <Route path='/logout' element={ <LoggedInRoute><Logout /></LoggedInRoute> } />
                        <Route path='*' element={ <Error />} />
                    </Routes>
                </div>
                <Footer />
            </BrowserRouter>
        </AuthProvider>
    </div>
    );
}