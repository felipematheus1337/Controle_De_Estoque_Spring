import { TipoMovimento } from "./MovimentacaoCriar";
import { ProdutoType } from "./ProdutoType";

export type MovimentacaoType = {
    id: number;
    quantidade: number;
    saldo: number;
    data: string;
    tipo: TipoMovimento;
    motivo: string;
    documento?: string;
    produto: ProdutoType;

}