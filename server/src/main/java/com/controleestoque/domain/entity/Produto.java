package com.controleestoque.domain.entity;

import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.exception.BusinessException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoBarras;

    @NotEmpty
    private String nome;

    @NotEmpty
    @Column(nullable = false)
    private Integer quantidadeMinima;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private BigDecimal saldoInicial;

    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "produto")
    private List<Movimentacao> movimentacoes;


    public void setSaldoInicial(BigDecimal saldoInicial) {
        if (this.getSaldoInicial() != null) {
         throw new BusinessException("Não é possível alterar o saldo inicial!");
        } else if (saldoInicial.compareTo(new BigDecimal(getQuantidadeMinima())) < 0) {
            throw new BusinessException("Saldo inicial não pode ser inferior à quantidade mínima.");
        } else if (saldoInicial.compareTo(BigDecimal.ZERO) > 0) {
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setTipo(TipoMovimentacao.SALDO_INICIAL);
            movimentacoes.add(movimentacao);
            this.saldoInicial = saldoInicial;
        }
    }

    public BigDecimal getSaldo() {
        BigDecimal totalEntradas = BigDecimal.ZERO;
        BigDecimal totalSaidas = BigDecimal.ZERO;
        for (Movimentacao movimentacao : movimentacoes) {
            if (movimentacao.getTipo() == TipoMovimentacao.ENTRADA) {
                totalEntradas = totalEntradas.add(movimentacao.getQuantidade());
            } else if (movimentacao.getTipo() == TipoMovimentacao.SAÍDA) {
                totalSaidas = totalSaidas.add(movimentacao.getQuantidade());
            }
        }
        return saldoInicial.add(totalEntradas).subtract(totalSaidas);
    }


   /* public void addMovimentacao(Movimentacao movimentacao) {
        for(Movimentacao m: movimentacoes) {
            if(m.getTipo() == TipoMovimentacao.SALDO_INICIAL) {
                throw new BusinessException("Já existe uma movimentação do tipo SALDO_INICIAL");
            }
            movimentacoes.add(movimentacao);
        }
    }
    */


}
