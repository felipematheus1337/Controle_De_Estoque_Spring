export type MovimentacaoCriar = {
    produtoId: number;
    tipo: TipoMovimento;
    quantidade: number;
    data: string;
    motivo:string;
    documento?:string;
}


export enum TipoMovimento {
    ENTRADA,
    SAÍDA,
    SALDO_INICIAL,
    AJUSTE_ENTRADA,
    AJUSTE_SAÍDA
}