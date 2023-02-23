package com.controleestoque.domain.entity;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoBarras;
    private String nome;
    private Integer quantidadeMinima;

    private BigDecimal preco;
    private BigDecimal saldoInicial;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @OneToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Movimentacao> movimentacoes = new ArrayList<>();


    public void setSaldoInicial(BigDecimal saldoInicial) {
        System.out.println(this.getSaldoInicial());
        if (this.getSaldoInicial() != null) {
            throw new BusinessException("Não é possível alterar o saldo inicial!");
        } else if (saldoInicial.compareTo(new BigDecimal(getQuantidadeMinima())) < 0) {
            throw new BusinessException("Saldo inicial não pode ser inferior à quantidade mínima.");
        } else if (saldoInicial.compareTo(BigDecimal.ZERO) > 0) {
            Movimentacao movimentacao = new Movimentacao(TipoMovimentacao.SALDO_INICIAL, saldoInicial, this);
            this.saldoInicial = saldoInicial;
            movimentacoes.add(movimentacao);
        }
    }

    public BigDecimal getSaldo() {
        BigDecimal totalEntradas = BigDecimal.ZERO;
        BigDecimal totalSaidas = BigDecimal.ZERO;
        for (Movimentacao  movimentacao : movimentacoes) {
            if (movimentacao.getTipo() == TipoMovimentacao.ENTRADA) {
                totalEntradas = totalEntradas.add(movimentacao.getQuantidade());
            } else if (movimentacao.getTipo() == TipoMovimentacao.SAÍDA) {
                totalSaidas = totalSaidas.add(movimentacao.getQuantidade());
            }
        }
        return saldoInicial.add(totalEntradas).subtract(totalSaidas);
    }


}
