import React from "react";
import * as C from "./index";
import { RegisterOrEditForm } from "../../components/RegisterOrEditForm/RegisterOrEditForm";

export const CadastrarProduto = () => {
    return (
        <C.Container>
          <RegisterOrEditForm botaoType="Cadastrar"/>
        </C.Container>
    )
}