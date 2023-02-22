package com.controleestoque.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

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

    @OneToMany(mappedBy = "produto")
    private List<Movimentacao> movimentacoes;


    public void setSaldoInicial(BigDecimal saldoInicial) {
        if(getSaldoInicial() != null) {

        }
        this.saldoInicial = saldoInicial;
    }
}
