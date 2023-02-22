package com.controleestoque.api.dto;

import com.controleestoque.domain.entity.Movimentacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {


    private Long id;


    private String codigoBarras;


    private String nome;


    private Integer quantidadeMinima;


    private BigDecimal preco;


    private BigDecimal saldoInicial;

    private LocalDateTime dataCriacao;


    private List<MovimentacaoDTO> movimentacoes;
}
