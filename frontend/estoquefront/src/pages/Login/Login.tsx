import React, { useState } from "react"
import * as C from "./index";
import { loginService } from "../../api/loginService";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../hooks/useAuth";



export const Login = () => {
     const [email,setEmail] = useState<string>('');
     const [password,setPassword] = useState<string>('');
     const navigate = useNavigate();
     const [error,setError] = useState<string>("");
     
     const {login} = useAuth();

     const handleLogin = async (e:React.MouseEvent<HTMLButtonElement, MouseEvent>) => {
        e.preventDefault();

        if(await loginService({email,password},login)) {
            navigate("/home")
        } else {
            setError("Falha ao logar");
        }
        } 
        

    return (
        <C.Container>
            <label>E-mail</label>
            <input type="email" onChange={(e) => setEmail(e.target.value)}/>
            <label>Senha</label>
            <input type="password" onChange={(e) => setPassword(e.target.value)}/>
            <button onClick={(e) => handleLogin(e)}>Entrar!</button>
            {error && <h3>{error}</h3>}
        </C.Container>
    )
}