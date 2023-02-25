import React, { useState } from "react";
import * as C from "./index";
import { RegisterOrEditForm } from "../../components/RegisterOrEditForm/RegisterOrEditForm";
import {verifyQuantSaldo} from "../../hooks/verifyQuantSaldo";
import apiService from "../../api/apiService";
import { ProdutoCriavel } from "../../@types/ProdutoCriavel";
import { AxiosResponse } from "axios";
import { useAuthData } from "../../hooks/useAuthData";

export const CadastrarProduto = () => {

  const [codigoBarras, setCodigoBarras] = useState<string>('');
  const [nome,setNome] = useState<string>('');
  const [quantidadeMinima, setQuantidadeMinima] = useState<number>(0);
  const [saldoInicial, setSaldoInicial] = useState(0);
  const [failedQuant,setFailedQuant] = useState<boolean>();
  const [failedHttp,setFailedHttp] = useState<boolean>();
  const typeOp = "Cadastrar"
  const {token} = useAuthData();

  const handleCadastrar = async (e:React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if(!checkQuantSaldo()) {
      return;
    }



    let produtoToSave = {
      nome,
      codigoBarras,
      quantidadeMinima,
      saldoInicial
    } as ProdutoCriavel;

    let path = "produto/gerente/cadastrar"

    let response = await apiService("POST",produtoToSave,path,token!)

    if(response.status === 201) {
      setFailedHttp(false);
      setTimeout(() => {
        setFailedHttp(true);
       },4000)
    } else {
      setFailedHttp(true);
    }
    

    
    
  }

  const checkQuantSaldo = ():boolean =>{
      if(verifyQuantSaldo({quantidadeMinima,saldoInicial})) {
        return true;
      }

      setFailedQuant(true);

      setTimeout(() => {
       setFailedQuant(false);
      },4000)

      return false;
  }

    return (
        <C.Container onSubmit={(e) => {
          handleCadastrar(e)
          }}>
          <RegisterOrEditForm 
          botaoType="Cadastrar"
          setCodigoBarras={setCodigoBarras}
          setNome={setNome}
          setQuantidadeMinima={setQuantidadeMinima}
          setSaldoInicial={setSaldoInicial}
          typeOp={typeOp}
          />
          {failedQuant && <h3>Não é possível cadastrar um produto cuja quantidade mínima é maior que o saldo inicial!</h3>}
          {failedHttp === false ? <h4>Sucesso ao criar Produto!</h4> : null}
        </C.Container>
    )
}