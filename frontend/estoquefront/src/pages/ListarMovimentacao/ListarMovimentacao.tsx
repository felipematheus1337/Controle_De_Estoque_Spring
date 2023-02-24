import moment from "moment";
import React, { useEffect, useState } from "react"
import apiService from "../../api/apiService";
import * as C from "./index";
import buttonSearch from '../../assets/buttonSearch.png';
import { ProdutosParaEditarType } from "../../@types/ProdutosParaEditarType";
import { FiltrarPorLancamentoModal } from "../../components/FiltrarPorLançamentoModal/FiltarPorLançamentoModal";
import { MovimentacaoType } from "../../@types/MovimentacaoType";
import { AxiosResponse } from "axios";


export const ListarMovimentacao = () => {
    const [data,setData] = useState<MovimentacaoType[]>([]);
    const [isModalOpen,setIsModalOpen] = useState<boolean>(false);
    const handleOpenModal = () => {
        setIsModalOpen(true);
      };
    
      const handleCloseModal = () => {
        setIsModalOpen(false);
      };



    useEffect(() => {
        const getAllMovimentacoes = async () => {
            const response = await apiService("GET",null,"movimentacao");
            setData(response.data);
        }

        getAllMovimentacoes()
     
    },[])
    
    console.log(data);


   return (
    <C.Container>

       <C.OptionsSearch>

        <C.Option>
            <label>Filtrar por ordem alfabética</label>
            <img src={buttonSearch} alt="button to search!"/>
        </C.Option>
        <C.Option>
            <label>Filtrar por maior data</label>
            <img src={buttonSearch} alt="button to search!"/>
        </C.Option>
        <C.Option>
            <label>Filtrar por menor data</label>
            <img src={buttonSearch} alt="button to search!"/>
        </C.Option>

        <C.Option>
            <label>Filtrar por produto id</label>
            <img src={buttonSearch} alt="button to search!" onClick={handleOpenModal}/>
        </C.Option>

        <C.Option>
            <label>Filtrar por período</label>
            <img src={buttonSearch} alt="button to search!"/>
        </C.Option>

        <C.Option>
            <label>Filtrar por tipo de movimento</label>
            <img src={buttonSearch} alt="button to search!"/>
        </C.Option>


       </C.OptionsSearch>


       <C.ResultMovimentacao>
        {data !== undefined ? (
            <>
            {data.map(valor => (
                <C.Movimentacao key={valor.id}>
                  <h3>{valor.nome}</h3>
                  <h4>Código de  Barras: {valor.codigoBarras}</h4>
                  <h4>Quantidade mínima: {valor.quantidadeMinima}</h4>
                  <h4>Saldo Inicial: {valor.saldoInicial}</h4>
                  <h4>Preço: {valor.preco}</h4>
                  <h4>Data de criação: {moment(valor.dataCriacao).format("DD/MM/YYYY")}</h4>
                  </C.Movimentacao>
            ))}
            </>
            )
           
           : <h2>Carregando Produtos.</h2>} 
      
       </C.ResultMovimentacao>
       {isModalOpen && <FiltrarPorLancamentoModal onClose={handleCloseModal} setData={setData} />}
    </C.Container>
   )
}