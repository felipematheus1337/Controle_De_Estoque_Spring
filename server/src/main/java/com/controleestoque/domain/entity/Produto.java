package com.controleestoque.domain.entity;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Column(name = "nome_produto")
    private String nome;
    @Column(name = "quantidade_minima")
    private Integer quantidadeMinima;

    private BigDecimal preco;
    private BigDecimal saldoInicial;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "produto")
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    public void setDataCriacao(LocalDateTime dataCriacao) {
        if(this.dataCriacao == null && dataCriacao == null) {
            this.dataCriacao = LocalDateTime.now();
        }
        this.dataCriacao = dataCriacao;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        if (this.getSaldoInicial() != null) {
            throw new BusinessException("Não é possível alterar o saldo inicial!");
        } else if (saldoInicial.compareTo(new BigDecimal(getQuantidadeMinima())) < 0) {
            throw new BusinessException("Saldo inicial não pode ser inferior à quantidade mínima.");
        }
         else if (saldoInicial.compareTo(BigDecimal.ZERO) > 0) {
             this.saldoInicial = saldoInicial;
            Movimentacao movimentacao = new Movimentacao(TipoMovimentacao.SALDO_INICIAL,this);
            movimentacoes.add(movimentacao);
        }
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoInicial() {

        if(this.saldoInicial == null) {
            return null;
        }
        BigDecimal totalEntradas = BigDecimal.ZERO;
        BigDecimal totalSaidas = BigDecimal.ZERO;
        for (Movimentacao  movimentacao : movimentacoes) {
            if (movimentacao.getTipo() == TipoMovimentacao.ENTRADA) {
                totalEntradas = totalEntradas.add(movimentacao.getQuantidade());
            } else if (movimentacao.getTipo() == TipoMovimentacao.SAÍDA) {
                totalSaidas = totalSaidas.add(movimentacao.getQuantidade());
            }
        }
        return this.saldoInicial.add(totalEntradas).subtract(totalSaidas);
    }


}
