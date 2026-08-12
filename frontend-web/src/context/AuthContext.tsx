import { createContext, useContext, useEffect, useState } from "react";
import type { ReactNode } from "react";
import api from "../services/api";
import type { AuthUser, LoginRequest, LoginResponse, RegisterRequest } from "../models/auth";

type AuthContextType = {
  user: AuthUser | null;
  loading: boolean;
  login: (data: LoginRequest) => Promise<void>;
  register: (data: RegisterRequest) => Promise<void>;
  logout: () => void;
};

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<AuthUser | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const storedUser = localStorage.getItem("user");
    const token = localStorage.getItem("token");
    if (storedUser && token) {
      setUser(JSON.parse(storedUser));
    }
    setLoading(false);
  }, []);

  const login = async (data: LoginRequest) => {
    const response = await api.post<LoginResponse>("/auth/login", data);
    const { token, username, roles } = response.data;
    localStorage.setItem("token", token);
    localStorage.setItem("user", JSON.stringify({ username, roles }));
    setUser({ username, roles });
  };

  const register = async (data: RegisterRequest) => {
    await api.post("/auth/register", data);
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, loading, login, register, logout }}>
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error("useAuth debe usarse dentro de un AuthProvider");
  }
  return context;
}
