import styled from "styled-components";

export const Header = styled.div`
margin: 3px auto;
text-align: center;

`;

export const Container = styled.div`
display: flex;
flex-direction: row;
margin: 40px auto;
justify-content: center;
align-items: center;

h1 {
    text-align: center;
    display: block;    
}


`;

export const Produto = styled.div`
display: flex;
flex-direction: column;
background: rgba(120,120,120,0.6);
margin: 40px auto;
width: 300px;
justify-content: center;
align-items: center;
border-radius: 20px;

h3 {
    text-align: center;
    color: white;
    background-color: black;
    color: white;
    font-size: 1.2rem;
}

a {
    text-decoration: none;
    color: white;
    padding: 2px;
}

h4 {
    text-align: center;
    color: white;
    background-color: black;
    color: white;
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

button:hover {
    cursor: pointer;
}

`;