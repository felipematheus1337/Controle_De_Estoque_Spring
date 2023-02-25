import styled from "styled-components";

export const Container =  styled.div`
display: flex;
flex-direction: column;
`;

export const OptionsSearch = styled.menu`
display: flex;
flex-direction: row;
border-radius: 8px;


`;

export const Option = styled.div`
margin: 5px auto;
display: flex;
flex-direction: column;
align-items: center;
text-align: center;
border-radius: 8px;


img {

    width: 40px;
    margin: 5px;
    cursor: pointer;
    border-radius: 8px;
}

label {
    margin: 5px;
    padding: 5px;
    font-size: 1.1rem;
    background-color: black;
    color: white;
}

`;

export const Movimentacao = styled.div`
display: flex;
flex-direction: column;
background: rgba(29,26,49,0.5);
margin: 10px auto;

width: 300px;
justify-content: center;
align-items: center;
border-radius: 20px;

h3 {
    text-align: center;
    font-size: 1.2rem;
    color: white;
}

a {
    text-decoration: none;
    color: white;
    padding: 2px;
}

h4 {
    text-align: center;
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

export const ResultMovimentacao = styled.div`
margin: 20px auto;
display: flex;
flex-direction: row;
width: 1000px;
justify-content: space-around;
flex-wrap: wrap;
`;