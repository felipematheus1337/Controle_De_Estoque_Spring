import React, { useState } from "react"
import * as C from "./index";
import { useParams } from "react-router-dom";
import { RegisterOrEditForm } from "../../components/RegisterOrEditForm/RegisterOrEditForm";
import { ProdutoEditavel } from "../../@types/ProdutoEditavel";
import apiService from "../../api/apiService";
import { useAuthData } from "../../hooks/useAuthData";


export const EditarProduto = () => {

    const {id} = useParams<{id: string}>();

    const [codigoBarras, setCodigoBarras] = useState<string>('');
    const [nome,setNome] = useState<string>('');
    const [quantidadeMinima, setQuantidadeMinima] = useState<number>(0);
    const [failedHttp,setFailedHttp] = useState<boolean>();
    const typeOp = "Editar";
    const {token} = useAuthData();

    
    const handleSubmit = async (e:React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();
     
      
      let produtoToEdit = {
        nome,
        codigoBarras,
        quantidadeMinima,
      } as ProdutoEditavel;

      let path = `produto/gerente/editar/${id}`;
      
      let response = await apiService("PUT",produtoToEdit,path,token!)

      if(response.status === 200) {
        setFailedHttp(false);
        setTimeout(() => {
          setFailedHttp(true);
         },4000)
      } else {
        setFailedHttp(true);
      }
      
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
              {failedHttp === false ? <h4>Sucesso ao atualizar Produto!</h4> : null}
            </C.ProdutoEditavel>
         
        </C.Container>
    )
}