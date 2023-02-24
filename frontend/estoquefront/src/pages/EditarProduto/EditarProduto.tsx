import React from "react"
import * as C from "./index";
import { useParams } from "react-router-dom";
import { RegisterOrEditForm } from "../../components/RegisterOrEditForm/RegisterOrEditForm";



export const EditarProduto = () => {

    const {id} = useParams<{id: string}>();
    

    return (
        <C.Container>
            <h1>Tela para Editar Produto!</h1>
            <C.ProdutoEditavel>
            <label>Id</label>
            <input disabled value={id}></input>
                {/** 
                <label>Codigo de Barras</label>
                <input type="text"/>
                <label>Nome</label>
                <input type="text"/>
                <label>Quantidade mínima</label>
                <input type="number"/>
                <label>Saldo Inicial</label>
                <input type="number"/>
                <button>Cadastrar!</button> */}
               <RegisterOrEditForm botaoType="Editar"/>
            </C.ProdutoEditavel>
        </C.Container>
    )
}