type VerifyQuantSaldo = {
quantidadeMinima: number;
saldoInicial: number;
}


export const verifyQuantSaldo = ({quantidadeMinima,saldoInicial}:VerifyQuantSaldo):Boolean => {

  if(quantidadeMinima > saldoInicial) {
    return false;
  }
  
  return true;
}