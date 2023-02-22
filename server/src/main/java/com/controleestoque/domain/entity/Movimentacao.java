package com.controleestoque.domain.entity;


import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.exception.BusinessException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Movimentacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal quantidade;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column(nullable = false)
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMovimentacao tipo;

    private String motivo;

    private String documento;


    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public Movimentacao(TipoMovimentacao tipo, BigDecimal quantidade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
    }


    public void setTipo(TipoMovimentacao tipo) {
        LocalDateTime dataMovimentacao = LocalDateTime.now();
        LocalDateTime dataCriacaoProduto = produto.getDataCriacao();

        if(dataMovimentacao.isBefore(dataCriacaoProduto)) {
            throw new BusinessException("Não é possível realizar movimentações para um produto anterior a sua criação");
        }
        checkIfSaldoInicialValid(tipo);
        checkIfAjusteValid(tipo);
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
        this.tipo = tipo;
    }

    private void checkIfAjusteValid(TipoMovimentacao tipo) {
        if(produto.getMovimentacoes().size() == 0) {
            throw new BusinessException("Não é possível realizar ajustes sem lançamentos prévios");
        }
        this.tipo = tipo;
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
