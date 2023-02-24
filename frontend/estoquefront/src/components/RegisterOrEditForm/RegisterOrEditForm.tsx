type Props =  {
    botaoType: string;
}

export const RegisterOrEditForm = ({botaoType}:Props) => {
    return(
        <>
        <label>Codigo de Barras</label>
         <input type="text"/>
         <label>Nome</label>
         <input type="text"/>
         <label>Quantidade mínima</label>
         <input type="number"/>
         <label>Saldo Inicial</label>
         <input type="number"/>
         <button>{botaoType}</button>
         </>
    )

}