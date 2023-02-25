import moment from "moment";
import React, { useEffect, useState } from "react"
import apiService from "../../api/apiService";
import * as C from "./index";
import buttonSearch from '../../assets/buttonSearch.png';
import { FiltrarPorLancamentoModal } from "../../components/FiltrarPorLançamentoModal/FiltarPorLançamentoModal";
import { MovimentacaoType } from "../../@types/MovimentacaoType";
import { ProdutoToRender } from "../../components/ProdutoToRender/ProdutoToRender";
import { FiltrarPorPeriodo } from "../../components/FiltrarPorPeriodoModal/FiltarPorPeriodoModal";
import { FiltrarPorTipoModal } from "../../components/FiltrarPorTipoModal/FiltrarPorTipoModal";
import { useAuthData } from "../../hooks/useAuthData";


export const ListarMovimentacao = () => {

    const [data,setData] = useState<MovimentacaoType[]>([]);
    const [isModalOpen,setIsModalOpen] = useState<boolean>(false);
    const [isPeriodoModalOpen,setIsPeriodoModalOpen] = useState<boolean>(false);
    const [isTipoModalOpen,setIsTipoModalOpen] = useState<boolean>(false);
    const {token} = useAuthData();


    const handleOpenModal = () => {
        setIsModalOpen(true);
      };

      const handleOpenPeriodoModal = () => {
        setIsPeriodoModalOpen(true);
      };

      const handleOpenTipoModal = () => {
        setIsTipoModalOpen(true);
      };

    
      const handleCloseModal = () => {
        setIsModalOpen(false);
      };

      const handleClosePeriodoModal = () => {
        setIsPeriodoModalOpen(false);
      }

      const handleCloseTipoMovimento = () => {
        setIsTipoModalOpen(false);
      }



    useEffect(() => {
        const getAllMovimentacoes = async () => {
            const response = await apiService("GET",null,"movimentacao",token!);
            setData(response.data);
        }

        getAllMovimentacoes()
     
    },[])


    const handleOrdemAlfabetica = async () => {
         let path = "business/produto";
         const response = await apiService("GET",null,path,token!);
         setData(response.data);
    }

    useEffect(() => {
      
    },[data])

    const handleDataMaior = async () => {
        let path = "business/datamaior";
        const response = await apiService("GET",null,path,token!);
        setData(response.data);
   }

   const handleDataMenor = async () => {
    let path = "business/datamenor";
    const response = await apiService("GET",null,path,token!);
    setData(response.data);
}
    



   return (
    <C.Container>

       <C.OptionsSearch>

        <C.Option>
            <label>Filtrar por ordem alfabética</label>
            <img src={buttonSearch} alt="button to search!" onClick={handleOrdemAlfabetica}/>
        </C.Option>
        <C.Option>
            <label>Filtrar por maior data</label>
            <img src={buttonSearch} alt="button to search!" onClick={handleDataMaior}/>
        </C.Option>
        <C.Option>
            <label>Filtrar por menor data</label>
            <img src={buttonSearch} alt="button to search!" onClick={handleDataMenor}/>
        </C.Option>

        <C.Option>
            <label>Filtrar por produto id</label>
            <img src={buttonSearch} alt="button to search!" onClick={handleOpenModal}/>
        </C.Option>

        <C.Option>
            <label>Filtrar por período</label>
            <img src={buttonSearch} alt="button to search!" onClick={handleOpenPeriodoModal}/>
        </C.Option>

        <C.Option>
            <label>Filtrar por tipo de movimento</label>
            <img src={buttonSearch} alt="button to search!" onClick={handleOpenTipoModal}/>
        </C.Option>


       </C.OptionsSearch>


       <C.ResultMovimentacao>
        {data !== undefined ? (
            <>
            {data.map(valor => (
                <C.Movimentacao key={valor.id}>
                  <h3>Data do movimento : {valor.data}</h3>
                  <ProdutoToRender produto={valor.produto}/>
                  <h3>Tipo: {valor.tipo}</h3>
                  {valor.documento == null ? <h3></h3> : <h3>Documento: {valor.documento}</h3>}
                  <h3>Motivo: {valor.motivo}</h3>
                  <h3>Saldo: {valor.saldo}</h3>
                  {valor.saldo < valor.quantidade ? <h3>Situação: Inferior ao Mínimo do contrário</h3> : <h3>Situação: Ok</h3>}
                  </C.Movimentacao>
            ))}
            </>
            )
           
           : <h2>Carregando Produtos.</h2>} 
      
       </C.ResultMovimentacao>
       {isModalOpen && <FiltrarPorLancamentoModal onClose={handleCloseModal} setData={setData} />}
       {isPeriodoModalOpen && <FiltrarPorPeriodo onClose={handleClosePeriodoModal} setData={setData} />}
       {isTipoModalOpen && <FiltrarPorTipoModal onClose={handleCloseTipoMovimento} setData={setData} />}
    </C.Container>
   )
}