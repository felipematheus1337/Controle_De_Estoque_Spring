import { useContext } from 'react';
import AuthContext from "../context/AuthContext";

export function useAuth() {
  const { token, role, setAuthData } = useContext(AuthContext);

  function login(token: string, role: string) {
    setAuthData(token, role);
  }

  function logout() {
    setAuthData(null, null);
  }

  return {
    token,
    role,
    login,
    logout,
  };
}
