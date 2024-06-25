import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import AuthProvider, { useAuth } from '../security/AuthContext.jsx';
import Landing from './Landing.jsx';
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

export default function SlotSyncApp() {
    return (
        <div className="slotsync">
        <AuthProvider>
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path='/' element={ <Landing /> } />
                    <Route path='/login' element={ <Login />} />
                    {/* <Route path='/welcome/:username' element={ <LoggedInRoute><WelcomeComponent /></LoggedInRoute> } /> */}
                    {/* <Route path='/tasks' element={ <LoggedInRoute><ShowTasksComponent /></LoggedInRoute> } /> */}
                    {/* <Route path='/task/:id' element={ <LoggedInRoute><TaskComponent /></LoggedInRoute> } /> */}
                    <Route path='/logout' element={ <LoggedInRoute><Logout /></LoggedInRoute> } />
                    {/* <Route path='*' element={ <ErrorComponent />} /> */}
                </Routes>
                <Footer />
            </BrowserRouter>
        </AuthProvider>
    </div>
    );
}