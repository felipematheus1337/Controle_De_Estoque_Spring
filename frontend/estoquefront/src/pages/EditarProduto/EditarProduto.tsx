import React, { useState } from "react"
import * as C from "./index";
import { useParams } from "react-router-dom";
import { RegisterOrEditForm } from "../../components/RegisterOrEditForm/RegisterOrEditForm";
import { ProdutoEditavel } from "../../@types/ProdutoEditavel";



export const EditarProduto = () => {

    const {id} = useParams<{id: string}>();

    const [codigoBarras, setCodigoBarras] = useState<string>('');
    const [nome,setNome] = useState<string>('');
    const [quantidadeMinima, setQuantidadeMinima] = useState<number>(0);
    const typeOp = "Editar";


    
    const handleSubmit = (e:React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();
      
      let produtoToSave = {
        nome,
        codigoBarras,
        quantidadeMinima,
      } as ProdutoEditavel;
      
      console.log(produtoToSave);
      
    }



    return (
        <C.Container>
            <h1>Tela para Editar Produto!</h1>
            <C.ProdutoEditavel onSubmit={handleSubmit}>
            <label>Id</label>
            <input disabled value={id}></input>
               <RegisterOrEditForm
                botaoType="Editar"
                setCodigoBarras={setCodigoBarras}
                setNome={setNome}
                setQuantidadeMinima={setQuantidadeMinima}
                typeOp={typeOp}         
               />
            </C.ProdutoEditavel>
        </C.Container>
    )
}