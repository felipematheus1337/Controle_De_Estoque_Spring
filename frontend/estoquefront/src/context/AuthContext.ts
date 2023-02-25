import { createContext, ReactNode, useState } from "react";


interface AuthContextData {
    token: string | null;
    role: string | null;
    setAuthData: (token:string | null, role: string | null) => void;
    login: (token: string, role: string) => void;
    logout: () => void;
}


 const AuthContext = createContext<AuthContextData>({
    token: null,
    role: null,
    setAuthData: () => {},
    login: (token: string, role: string) => {},
    logout: () => {},
});



export default AuthContext;
  



