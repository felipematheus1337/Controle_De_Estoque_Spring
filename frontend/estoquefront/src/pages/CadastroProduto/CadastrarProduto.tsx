import React from "react";
import * as C from "./index";


export const CadastrarProduto = () => {
    return (
        <C.Container>
         <label>Codigo de Barras</label>
         <input type="text"/>
         <label>Nome</label>
         <input type="text"/>
         <label>Quantidade mínima</label>
         <input type="number"/>
         <label>Saldo Inicial</label>
         <input type="number"/>
         <button>Cadastrar!</button>
        </C.Container>
    )
}