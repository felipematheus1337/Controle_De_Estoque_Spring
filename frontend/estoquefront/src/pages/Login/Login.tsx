import React, { useState } from "react"
import * as C from "./index";
import { loginService } from "../../api/loginService";
import { useNavigate } from "react-router-dom";

export const Login = () => {
     const [email,setEmail] = useState<string>('');
     const [password,setPassword] = useState<string>('');
     const navigate = useNavigate();

     const handleLogin = (e:React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();
        loginService({email,password}, () => {
            navigate("/home");
        });
     }

    return (
        <C.Container>
            <label>E-mail</label>
            <input type="email" onChange={(e) => setEmail(e.target.value)}/>
            <label>Senha</label>
            <input type="password" onChange={(e) => setPassword(e.target.value)}/>
            <button onClick={(e) => handleLogin(e)}>Entrar!</button>
        </C.Container>
    )
}