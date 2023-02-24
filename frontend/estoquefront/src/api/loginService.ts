/* eslint-disable react-hooks/rules-of-hooks */

import { UserLogin } from "../@types/UserLogin";
import axios from "axios";

export const loginService = async (data:UserLogin, onSucess: () => void) => {
   const BASE_URL = `http://localhost:8081/server/ping`;
   let result = await axios.get(BASE_URL)
   console.log(result.data);

    onSucess();
}