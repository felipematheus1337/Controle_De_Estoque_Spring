type Props =  {
    botaoType: string;
    setCodigoBarras: (value:string) => void;
    setNome: (value:string) => void;
    setQuantidadeMinima: (value:number) => void;
    setSaldoInicial?: (value:number) => void;
    typeOp: string;
};

export const RegisterOrEditForm = ({
    botaoType,
    setCodigoBarras,
    setNome,
    setQuantidadeMinima,
    setSaldoInicial,
    typeOp
}:Props) => {

    const handleCodigoBarrasChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        setCodigoBarras(e.target.value);
      };
    
      const handleNomeChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        setNome(e.target.value);
      };
    
      const handleQuantidadeMinimaChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        setQuantidadeMinima(parseInt(e.target.value, 10));
      };

      const handleSaldoInicialChange = (e:React.ChangeEvent<HTMLInputElement>) => {
        if(setSaldoInicial) {
          setSaldoInicial(parseInt(e.target.value, 10));
        }
      
      }
    

    return(
        <>
        <label>Codigo de Barras</label>
         <input onChange={(e) => handleCodigoBarrasChange(e)} type="text"/>
         <label>Nome</label>
         <input type="text" onChange={(e) => handleNomeChange(e)}/>
         <label>Quantidade mínima</label>
         <input type="number" onChange={(e) => handleQuantidadeMinimaChange(e)}/>
         {typeOp === "Cadastrar" ?  (<><label>Saldo Inicial</label><input type="number" onChange={(e) => handleSaldoInicialChange(e)} /></>) :  null}

         <button>{botaoType}</button>
         </>
    )

}