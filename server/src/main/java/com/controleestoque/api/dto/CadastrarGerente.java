package com.controleestoque.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarGerente {

    private Long id;
    private String codigoBarras;
    private String nome;
    private Integer quantidadeMinima;
    private BigDecimal saldoInicial;

    private LocalDateTime dataCriacao;

}
