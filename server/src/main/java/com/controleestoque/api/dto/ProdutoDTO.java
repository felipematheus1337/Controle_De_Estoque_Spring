package com.controleestoque.api.dto;

import com.controleestoque.domain.entity.Movimentacao;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.exception.BusinessException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProdutoDTO {


    private Long id;


    private String codigoBarras;


    private String nome;


    private Integer quantidadeMinima;


    private BigDecimal preco;


    private BigDecimal saldoInicial;



    private LocalDateTime dataCriacao = LocalDateTime.now();


    @JsonIgnore
    private List<MovimentacaoDTO> movimentacoes = new ArrayList<MovimentacaoDTO>();





}
