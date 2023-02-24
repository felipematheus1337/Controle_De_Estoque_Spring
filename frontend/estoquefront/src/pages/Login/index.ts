import styled from "styled-components";

export const Container = styled.div`
display: flex;
flex-direction: column;
width: 400px;
height: 450px;
margin: 40px auto;
justify-content: center;
align-items: center;
background: rgba(29,26,49,0.5);
border-radius: 10px;
color: white;
padding: 30px;

input {
    padding: 5px;
    font-size: 1.2rem;
    margin: 5px;
    width: auto;
    height: auto;
}

label {
    padding: 5px;
    font-size: 1.2rem;
    margin: 5px;
    width: auto;
    height: auto;
    font-weight: 400px;
}

button {
    padding: 10px;
    margin: 10px;
    width: auto;
    height: auto;
    font-size: 1.1rem;
    border-radius: 5px;
}

`;