import styled from "styled-components";

export const ModalOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 9999;
`;

export const ModalContent = styled.div`
  background-color: white;
  border-radius: 4px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
  max-width: 600px;
  width: 100%;
  max-height: calc(100vh - 100px);
  overflow-y: auto;

  text-align: center;
  flex-direction: column;
  display: flex;
  align-items: center;

  h2 {
    font-size: 1.2rem;
    margin-bottom: 20px;
  }

  cursor: default;

  &:hover {
    cursor: auto;
  }

  &:active {
    cursor: auto;
  }

  &:focus {
    outline: none;
  }

  label {
    margin: 5px;
    padding: 5px;
    font-size: 1.1rem;
    background-color: black;
    color: white;
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
`;
