// AuthContextProvider.tsx
import { ReactNode, useState } from "react";
import AuthContext from "./AuthContext";

type AuthProviderProps = {
  children: ReactNode;
};

export const AuthProvider = ({ children }: AuthProviderProps) => {
  const [token, setToken] = useState<string | null>(null);
  const [role, setRole] = useState<string | null>(null);

  const login = (token: string, role: string) => {
    setToken(token);
    setRole(role);
  };

  const logout = () => {
    setToken(null);
    setRole(null);
  };

  const setAuthData = (token: string | null, role: string | null) => {
    setToken(token);
    setRole(role);
  };

  return (
    <AuthContext.Provider value={{ token, role, login, logout, setAuthData }}>
      {children}
    </AuthContext.Provider>
  );
};
