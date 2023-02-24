import styled from "styled-components";


export const Container = styled.div`
display: flex;
flex-direction: column;
margin: 40px auto;
justify-content: center;
align-items: center;
`;

export const ProdutoEditavel = styled.form`
display: flex;
flex-direction: column;
background: rgba(29,26,49,0.5);
border-radius: 20px;
margin: 25px auto;
text-align: center;
width: 500px;
padding: 25px;
align-items: center;

label {
    background-color: black;
    margin: 5px;
    padding: 5px;
    color: white;
    font-size: 1.1rem;
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

h4 {
    background-color: white;
    color: green;
    font-weight: bold;
    font-size: 1.1rem;
}
`;
