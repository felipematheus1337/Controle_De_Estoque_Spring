import styled from "styled-components";

export const DivMenu = styled.div`
margin: 15px auto;
h1 {
    margin: 10px;
    color: black;
    text-align: center;
}


`;

export const Container = styled.div`
margin: 70px auto;
width: 500px;
background: rgba(29,26,49,0.5);
display: flex;
flex-direction: row;
height: 300px;
border-radius: 20px;
color: white;
justify-content: space-around;







`;

export const WrappDiv = styled.div`
display: flex;
flex-direction: column;
margin: auto;
.divs-list {
    display: flex;
    flex-direction: column;
}

a {
    text-decoration: none;
    display: block;
    color: white;
}

h2 {
    background-color: black;
    cursor:pointer;
    height: auto;
    text-align: center;
}

h3 {
    background-color: black;
    color: white;
}

h2:hover {
    background-color: white;
    color: black;
}

h3:hover {
    background-color: white;
    color: black;
}
a:hover {
    background-color: white;
    color: black;
}


`;