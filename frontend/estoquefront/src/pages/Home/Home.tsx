import React, { useContext, useState } from "react"
import { Link } from "react-router-dom";
import AuthContext from "../../context/AuthContext";
import { useAuthData } from "../../hooks/useAuthData";
import * as C from './index';


export const Home = () => {
    const [dropProd,setDropProd] = useState<boolean>();
    const [dropMov,setDropMov] = useState<boolean>();
    const {token,role} = useAuthData();
    console.log(token,role);

    const handleDropDownProdutoArrow = () => {
       
      return dropProd === true ?  `👇` :  `👆`;
    }


    const handleDropDownMovimentacaoArrow = () => {
    
        return dropMov === true ?  `👇` :  `👆`;
      }



      const handleProdClick = () => {
        setDropProd(!dropProd);
        setDropMov(false); 
      }
  
      const handleMovClick = () => {
        setDropMov(!dropMov);
        setDropProd(false); 
      }



    return(
      <C.DivMenu>
      <h1>Menu</h1>
        <C.Container>
           {role === "GERENTE" ?  <C.WrappDivProduto>
            <h2 onClick={() => {{handleProdClick()}
            }}>Produtos {handleDropDownProdutoArrow()}</h2>
           {dropProd && 
           <div className="divs-list"><h3><Link to="/cadastrarProduto">Tela para cadastrar produto!</Link></h3>
           <h3><Link to="/produtosParaEditar">Tela para editar produto!</Link>
           </h3>
           </div>}
            </C.WrappDivProduto> : null}
           

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
        </C.DivMenu>
    )
}