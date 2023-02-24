import moment from "moment";
import React, { useState } from "react"
import { MovimentacaoCriar, TipoMovimento } from "../../@types/MovimentacaoCriar";
import apiService from "../../api/apiService";
import * as C from "./index";

export const CadastrarMovimentacao = () => {

    const [selectedValue, setSelectedValue] = useState('');
    const [produtoId, setProdutoId] = useState<number>();
    const [quantidade, setQuantidade] = useState<number>();
    const [data,setData] = useState<string>();
    const [motivo, setMotivo] = useState<string>();
    const [documento,setDocumento] = useState<string | null>(null);
    const [failedHttp,setFailedHttp] = useState<boolean>();

    const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
       setSelectedValue(event.target.value);
    };

    const handleDocumentToRender = ():boolean => {
       if(TipoMovimento[Number(selectedValue)] == "ENTRADA" || TipoMovimento[Number(selectedValue)] === "SAÍDA") {
          return true
        } else {
          return false;
        }
    }

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();

      let movimentacaoToSave = {
        produto: {
            id: produtoId
        },
        quantidade,
        data:handleData(data!),
        motivo,
        documento,
        tipo: TipoMovimento[Number(selectedValue)]
      };

      let path = "movimentacao"
      
      let response = await apiService("POST",movimentacaoToSave,path)

      if(response.status === 201) {
        setFailedHttp(false);
        setTimeout(() => {
          setFailedHttp(true);
         },4000)
      } else {
        setFailedHttp(true);
      }
      
     
    }

    const handleData = (dataToFormat:string):string => {
        return moment(dataToFormat).format("YYYY-MM-DDTHH:mm:ss.SSS");
    }

    

  return (
    <C.Container onSubmit={handleSubmit}>
        <label>Produto ID</label>
        <input type="number" onChange={(e) => setProdutoId(Number(e.target.value))}/>
        <label htmlFor="tipoMovimento">Tipo da Movimentação</label>

        <select id="tipoMovimento" value={selectedValue} onChange={handleChange}>
          <option value={TipoMovimento.ENTRADA}>Entrada</option>
          <option value={TipoMovimento.SAÍDA}>Saída</option>
         <option value={TipoMovimento.SALDO_INICIAL}>Saldo inicial</option>
         <option value={TipoMovimento.AJUSTE_ENTRADA}>Ajuste de entrada</option>
         <option value={TipoMovimento.AJUSTE_SAÍDA}>Ajuste de saída</option>
        </select>

        <label>Quantidade</label>
        <input type="number" onChange={(e) => setQuantidade(Number(e.target.value))}/>
        <label>Data</label>
        <input type="date" onChange={(e) => setData(e.target.value)}/>
        <label>Motivo</label>
        <input type="text" onChange={(e) => setMotivo(e.target.value)}/>

        {handleDocumentToRender() === true ? (
          <>
            <label>Documento</label>
            <input type="text" onChange={(e) => setDocumento(e.target.value)}/>
          </>
        )
        :
        (null)
        }

        <button>Criar</button>
        {failedHttp === false ? <h4>Sucesso ao criar Movimentação!</h4> : null}

    </C.Container>
  )

}