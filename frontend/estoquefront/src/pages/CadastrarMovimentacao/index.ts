import styled from "styled-components";

export const Container = styled.form`
margin: 50px auto;
display: flex;
flex-direction: column;
width: 600px;
height: auto;
align-items: center;
justify-content: center;
padding: 25px;
background: rgba(29,26,49,0.5);
border-radius: 20px;
color: white;


label {
    margin: 5px;
    padding: 5px;
    font-size: 1.1rem;
    background-color: black;
}

input {
    margin: 5px;
    padding: 5px;
    font-size: 1.1rem;
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
    background-color: black;
}

h4 {
    color: green;
    font-weight: bold;
    background-color: white;
    font-size: 1.2rem;
}
select {
    margin: 10px;
    padding: 6px;
    border-radius: 5px;
}
`;