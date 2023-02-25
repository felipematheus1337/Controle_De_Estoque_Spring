import { useContext } from "react";
import  AuthContext  from "../context/AuthContext";

export const useAuthData = () => {
  const { token, role } = useContext(AuthContext);

  return {
    token,
    role,
  };
};
