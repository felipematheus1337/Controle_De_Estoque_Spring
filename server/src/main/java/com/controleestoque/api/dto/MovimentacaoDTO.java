package com.controleestoque.api.dto;

import com.controleestoque.domain.entity.Produto;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import jakarta.persistence.*;
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
public class MovimentacaoDTO {

    private Long id;


    private BigDecimal quantidade;


    private BigDecimal saldo;


    private LocalDateTime data;


    private TipoMovimentacao tipo;

    private String motivo;

    private String documento;


    private ProdutoDTO produto;
}
