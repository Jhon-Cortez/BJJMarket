import { Navigate, Route, Routes } from 'react-router-dom';
import './App.css';
import MainLayout from './layouts/MainLayout';
import Productos from './view/products/Products';
import Login from './view/auth/Login';
import Register from './view/auth/Register';
import ProtectedRoute from './components/ProtectedRoute/ProtectedRoute';

function Dashboard() {
  return (
    <MainLayout>
      <h1>Dashboard</h1>
      <Productos />
    </MainLayout>
  );
}

function App() {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route
        path="/"
        element={
          <ProtectedRoute>
            <Dashboard />
          </ProtectedRoute>
        }
      />
      <Route path="*" element={<Navigate to="/" replace />} />
    </Routes>
  );
}
export default App;
