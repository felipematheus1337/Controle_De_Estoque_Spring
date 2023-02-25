/* eslint-disable react-hooks/rules-of-hooks */

import { UserLogin } from "../@types/UserLogin";
import axios from "axios";
import { useAuth } from "../hooks/useAuth";

export const loginService = async (data: UserLogin, login: (token: string, role:string) => void): Promise<boolean> => {

    const BASE_URL = `http://localhost:8081/server/login/register`;
    
      let response = await axios.post(BASE_URL, data);

      if(response.status === 200 || response.status === 201) {

        const token = response.data.token;
        const role  = response.data.role;
        
        login(token,role);

        return true;

      } else {

        return false;
      }


  };