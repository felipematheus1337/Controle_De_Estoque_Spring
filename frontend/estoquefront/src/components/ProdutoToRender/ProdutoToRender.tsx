import moment from "moment";
import React, { useState } from "react"
import { ProdutoType } from "../../@types/ProdutoType";
import * as C from "./index";


type Props = {
produto: ProdutoType;
}


export const ProdutoToRender = ({produto}:Props) => {
    const [isOpenProduto,setIsOpenProduto] = useState<boolean>(false)



   
    
    return (
        <C.Container>
        <h3 onClick={() => setIsOpenProduto(!isOpenProduto)}>Produto:</h3>
        {
        isOpenProduto && 
        <>
        <h4>Nome: {produto.nome}</h4>
        <h4>Codigo de barras: {produto.codigoBarras}</h4>
        <h4>Data da criação: {moment(produto.dataCriacao).format("DD/MM/YYYY")}</h4>
        <h4>Saldo Inicial: {produto.saldoInicial}</h4>
        <h4>Quantidade Mínima: {produto.quantidadeMinima}</h4>
        <h4>Preço: {produto.preco}</h4>
        </>
        }
        </C.Container>
    )

}