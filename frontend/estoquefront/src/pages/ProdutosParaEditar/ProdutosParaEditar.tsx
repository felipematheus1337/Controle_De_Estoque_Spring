/* eslint-disable array-callback-return */
import * as C from "./index";
import produtos from "../../assets/mock/produtos.json";
import { useEffect, useState } from "react";
import { ProdutosParaEditarType } from "../../@types/ProdutosParaEditarType";
import moment from "moment";
import { Link } from "react-router-dom";



export const ProdutosParaEditar = () => {
    const [data, setData] = useState<ProdutosParaEditarType[]>();

    useEffect(() => {
      setData(produtos);
    },[])

    const handleEdit = (e:React.MouseEvent<HTMLButtonElement, MouseEvent>,valor:ProdutosParaEditarType) => {
         e.preventDefault();
         
    }



    return (
        <C.Header>
             <h1> Produtos Para Editar!</h1>
        <C.Container>
           {data !== undefined ? (
            <>
            {data.map(valor => (
                <C.Produto key={valor.id}>
                  <h3>{valor.nome}</h3>
                  <h4>Código de  Barras: {valor.codigoBarras}</h4>
                  <h4>Quantidade mínima: {valor.quantidadeMinima}</h4>
                  <h4>Saldo Inicial: {valor.saldoInicial}</h4>
                  <h4>Preço: {valor.preco}</h4>
                  <h4>Data de criação: {moment(valor.dataCriacao).format("DD/MM/YYYY")}</h4>
                  <button onClick={(e) => {handleEdit(e,valor)}}><Link to={`/editar/${valor.id}`}>Editar!</Link></button>
                  </C.Produto>
            ))}
            </>
            )
           
           : <h2>Carregando Produtos.</h2>}
        </C.Container>
        </C.Header>
    )
}