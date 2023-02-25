import styled from "styled-components";

export const Container = styled.div`
display: flex;
flex-direction: column;
width: 400px;
height: 450px;
margin: 40px auto;
justify-content: center;
align-items: center;
background: rgba(30,50,100,0.6);
border-radius: 20px;
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
    margin: 15px auto;
    padding: 6px;
    font-size: 1.1rem;
    background: rgba(29,26,49);
    border-radius: 5px;
    color: white;
}

h3 {
    color: red;
    
}

`;