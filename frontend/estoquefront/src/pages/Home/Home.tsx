import React, { useState } from "react"
import { Link } from "react-router-dom";
import * as C from './index';


export const Home = () => {
    const [dropProd,setDropProd] = useState<boolean>();
    const [dropMov,setDropMov] = useState<boolean>();

    const handleDropDownProdutoArrow = () => {
       
      return dropProd === true ?  `👇` :  `👆`;
    }


    const handleDropDownMovimentacaoArrow = () => {
    
        return dropMov === true ?  `👇` :  `👆`;
      }



      const handleProdClick = () => {
        setDropProd(!dropProd);
        setDropMov(false); // aqui definimos o outro estado como falso
      }
  
      const handleMovClick = () => {
        setDropMov(!dropMov);
        setDropProd(false); // aqui definimos o outro estado como falso
      }



    return(
        <C.Container>
            <C.WrappDiv>
            <h2 onClick={() => {{handleProdClick()}
            }}>Produtos {handleDropDownProdutoArrow()}</h2>
           {dropProd && 
           <div className="divs-list"><h3><Link to="/cadastrarProduto">Tela para cadastrar produto!</Link></h3>
           <h3><Link to="/produtosParaEditar">Tela para editar produto!</Link>
           </h3>
           </div>}
            </C.WrappDiv>

            <C.WrappDiv>
            <h2 onClick={() =>{handleMovClick()
            }}>Movimentações {handleDropDownMovimentacaoArrow()}</h2>
           {dropMov && 
           <div className="divs-list"><h3><Link to="/lancarMovimentacao">Tela para lançamento de movimentação!</Link></h3>
           <h3><Link to="/listarMovimentacao">Tela para listagem de movimentações!</Link>
           </h3>
           </div>}
            </C.WrappDiv>
          
           
        </C.Container>
    )
}