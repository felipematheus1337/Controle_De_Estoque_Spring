package com.controleestoque.domain.service;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.domain.entity.Movimentacao;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;

import java.time.LocalDateTime;
import java.util.List;

public interface BusinessServiceLogic {

    List<MovimentacaoDTO> filtrarPorLancamento(Long produtoId);

    List<MovimentacaoDTO> filtrarPorPeriodo(LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo);

    List<MovimentacaoDTO> filtrarPorTipoMovimento(TipoMovimentacao tipoMovimento);

    List<MovimentacaoDTO> filtrarPorProduto();

    List<MovimentacaoDTO> filtrarPorDataMaior();

    List<MovimentacaoDTO> filtrarPorDataMenor();
}
