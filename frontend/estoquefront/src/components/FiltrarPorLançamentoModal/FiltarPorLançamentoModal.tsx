import { AxiosResponse } from "axios";
import React, { Dispatch, SetStateAction, useState } from "react";
import { MovimentacaoType } from "../../@types/MovimentacaoType";
import { ProdutosParaEditarType } from "../../@types/ProdutosParaEditarType";
import apiService from "../../api/apiService";
import * as C from "./index";

interface Props {
  onClose: () => void;
  setData: React.Dispatch<SetStateAction<MovimentacaoType[]>>;
}

export const FiltrarPorLancamentoModal: React.FC<Props> = ({ onClose, setData }) => {

    const [id,setId] = useState<number>();

    const stopPropagation = (event: React.MouseEvent<HTMLDivElement, MouseEvent>) => {
        event.stopPropagation();
    };

    

  return (
    <C.ModalOverlay onClick={onClose}>
      <C.ModalContent onClick={stopPropagation}>
        <h3>Filtrar por produto Id</h3>
        <label>ID do Produto</label>
        <input type="number" onChange={(e) => setId(Number(e.target.value))} />
        <button>Buscar!</button>
      </C.ModalContent>
    </C.ModalOverlay>
  );
};



