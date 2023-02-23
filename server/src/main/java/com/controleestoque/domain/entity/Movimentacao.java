    package com.controleestoque.domain.entity;


    import com.controleestoque.api.dto.MovimentacaoDTO;
    import com.controleestoque.api.dto.ProdutoDTO;
    import com.controleestoque.domain.entity.enums.TipoMovimentacao;
    import com.controleestoque.exception.BusinessException;
    import jakarta.persistence.*;
    import lombok.*;

    import java.io.Serial;
    import java.io.Serializable;
    import java.math.BigDecimal;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.List;

    @Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Movimentacao implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private BigDecimal quantidade;


        private BigDecimal saldo;


        private LocalDateTime data;

        @Enumerated(EnumType.STRING)
        private TipoMovimentacao tipo;

        private String motivo;

        private String documento;

        @ManyToOne
        @JoinColumn(name = "produto_id")
        private Produto produto;

        public Movimentacao(TipoMovimentacao tipo, BigDecimal quantidade) {
            this.tipo = tipo;
            this.quantidade = quantidade;
        }

        public Movimentacao(TipoMovimentacao tipo, Produto produto) {
            this.tipo = tipo;
            this.produto = produto;
        }

        public void setTipo(TipoMovimentacao tipo) {
            LocalDateTime dataMovimentacao = LocalDateTime.now();

            if(produto.getDataCriacao() == null) {
                produto.setDataCriacao(LocalDateTime.now());
            }

            LocalDateTime dataCriacaoProduto = produto.getDataCriacao();

            if(dataMovimentacao.isBefore(dataCriacaoProduto)) {
                throw new BusinessException("Não é possível realizar movimentações para um produto anterior a sua criação");
            }
            checkIfSaldoInicialValid(tipo);
            checkIfSaidaValid(tipo);
            this.tipo = tipo;
        }

        private void checkIfSaldoInicialValid(TipoMovimentacao tipo) {
            if (tipo == TipoMovimentacao.SALDO_INICIAL) {
                var movimentacoes  = produto.getMovimentacoes();
                for(Movimentacao m : movimentacoes) {
                    if(m.getTipo() != null) {
                        throw new BusinessException("Não é possível lançar o SALDO_INICIAL, após outros lançamentos!");
                    }
                }
            }
        }


        private void checkIfSaidaValid(TipoMovimentacao tipo) {
            var movimentacoes = produto.getMovimentacoes();
            if(tipo == TipoMovimentacao.SAÍDA) {
                BigDecimal saldoAtual = getSaldo();
                BigDecimal novoSaldo = saldoAtual.subtract(quantidade);
                if(novoSaldo.compareTo(BigDecimal.ZERO) >= 0) {
                    Movimentacao movimentacao = new Movimentacao(tipo,quantidade);
                    movimentacoes.add(movimentacao);
                } else {
                    throw new BusinessException("Não é possível realizar a movimentação, pois o saldo do produto será negativo");
                }
            } else {
                Movimentacao movimentacao = new Movimentacao(tipo, quantidade);
                movimentacoes.add(movimentacao);
            }
        }





    }
