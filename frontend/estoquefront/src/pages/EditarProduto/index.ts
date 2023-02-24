import styled from "styled-components";


export const Container = styled.div`
display: flex;
flex-direction: column;
margin: 40px auto;
justify-content: center;
align-items: center;
`;

export const ProdutoEditavel = styled.div`
display: flex;
flex-direction: column;
background: rgba(29,26,49,0.5);
margin: 25px auto;
text-align: center;
width: 500px;
padding: 25px;
align-items: center;

label {
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
    padding: 8px;
    margin: 10px;
    font-size: 1.1rem;
}
`;
