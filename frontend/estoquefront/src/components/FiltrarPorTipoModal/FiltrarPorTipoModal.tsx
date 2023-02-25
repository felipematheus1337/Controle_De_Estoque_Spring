import React, { Dispatch, SetStateAction, useState } from "react";
import { TipoMovimento } from "../../@types/MovimentacaoCriar";
import { MovimentacaoType } from "../../@types/MovimentacaoType";
import apiServiceWithParams from "../../api/apiServiceWithParams";
import * as C from "./index";

interface Props {
  onClose: () => void;
  setData: React.Dispatch<SetStateAction<MovimentacaoType[]>>;
}

export const FiltrarPorTipoModal: React.FC<Props> = ({ onClose, setData }) => {

   const [selectedValue, setSelectedValue] = useState('');

    const stopPropagation = (event: React.MouseEvent<HTMLDivElement, MouseEvent>) => {
        event.stopPropagation();
    };

    


    const handleProdutoPorTipo = async () => {
      let path = `business/tipomovimento`;

      const params = {
        tipoMovimentacao:TipoMovimento[Number(selectedValue)]
      };
      console.log(params);

      let response = await apiServiceWithParams("GET",params,path);
      setData(response.data);
    }

    const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
      setSelectedValue(event.target.value);
   };


  
  return (
    <C.ModalOverlay onClick={onClose}>
      <C.ModalContent onClick={stopPropagation}>
        <h3>Filtrar por Período</h3>
        <select id="tipoMovimento" value={selectedValue} onChange={handleChange}>
          <option value={TipoMovimento.ENTRADA}>Entrada</option>
          <option value={TipoMovimento.SAÍDA}>Saída</option>
         <option value={TipoMovimento.SALDO_INICIAL}>Saldo inicial</option>
         <option value={TipoMovimento.AJUSTE_ENTRADA}>Ajuste de entrada</option>
         <option value={TipoMovimento.AJUSTE_SAÍDA}>Ajuste de saída</option>
        </select>
        <button onClick={handleProdutoPorTipo}>Buscar!</button>
      </C.ModalContent>
    </C.ModalOverlay>
  );
};



