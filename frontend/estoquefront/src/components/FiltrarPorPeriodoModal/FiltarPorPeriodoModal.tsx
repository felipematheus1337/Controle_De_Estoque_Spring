import { AxiosResponse } from "axios";
import moment from "moment";
import React, { Dispatch, SetStateAction, useState } from "react";
import { MovimentacaoType } from "../../@types/MovimentacaoType";
import { ProdutosParaEditarType } from "../../@types/ProdutosParaEditarType";
import apiServiceWithParams from "../../api/apiServiceWithParams";
import * as C from "./index";

interface Props {
  onClose: () => void;
  setData: React.Dispatch<SetStateAction<MovimentacaoType[]>>;
}

export const FiltrarPorPeriodo: React.FC<Props> = ({ onClose, setData }) => {

   const [inicioPeriodo,setInicioPeriodo] = useState<string>();
   const [fimPeriodo,setFimPeriodo] = useState<string>();

    const stopPropagation = (event: React.MouseEvent<HTMLDivElement, MouseEvent>) => {
        event.stopPropagation();
    };


    const handleProdutoPorPeriodo = async () => {
      let path = `business/periodo`;

      const params = {
        inicioPeriodo,
        fimPeriodo
      };

      let response = await apiServiceWithParams("GET",params,path);
      setData(response.data);
    }


  
  return (
    <C.ModalOverlay onClick={onClose}>
      <C.ModalContent onClick={stopPropagation}>
        <h3>Filtrar por Período</h3>
        <label>Início</label>
        <input type="date" onChange={(e) => setInicioPeriodo(moment(e.target.value).format("YYYY-MM-DDTHH:mm:ss.SSS"))} />
        <label>Fim</label>
        <input type="date" onChange={(e) => setFimPeriodo(moment(e.target.value).format("YYYY-MM-DDTHH:mm:ss.SSS"))} />
        <button onClick={handleProdutoPorPeriodo}>Buscar!</button>
      </C.ModalContent>
    </C.ModalOverlay>
  );
};



