package com.controleestoque.domain.service.impl;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.api.mapper.MovimentacaoMapper;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.domain.repository.MovimentacaoRepository;
import com.controleestoque.domain.repository.ProdutoRepository;
import com.controleestoque.domain.service.BusinessServiceLogic;
import com.controleestoque.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessServiceLogicImpl implements BusinessServiceLogic {

    private final MovimentacaoRepository movimentacaoRepository;
    private final ProdutoRepository produtoRepository;

    private final MovimentacaoMapper mapper;

    @Override
    public List<MovimentacaoDTO> filtrarPorLancamento(Long produtoId) {
        var produtoExists = produtoRepository.findById(produtoId);

        if(produtoExists.isEmpty()) {
            throw new BusinessException("Produto não existe com esse id!");
        }
        return mapper.toListOfDTO(movimentacaoRepository.filtrarPorLancamento(produtoId));
    }

    @Override
    public List<MovimentacaoDTO> filtrarPorPeriodo(LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo) {
        if(inicioPeriodo == null || fimPeriodo == null) {
            throw new BusinessException("Impossível gerar período com uma ou mais datas vazias!");
        }
        return mapper.toListOfDTO(movimentacaoRepository.filtrarPorPeriodo(inicioPeriodo,fimPeriodo));
    }

    @Override
    public List<MovimentacaoDTO> filtrarPorTipoMovimento(TipoMovimentacao tipoMovimento) {
        if(tipoMovimento == null) {
            throw new BusinessException("Impossível verificar com tipoMovimento vazio!");
        }
        return mapper.toListOfDTO(movimentacaoRepository.filtrarPorTipoMovimento(tipoMovimento));
    }

    @Override
    public List<MovimentacaoDTO> filtrarPorProduto() {
        return mapper.toListOfDTO(movimentacaoRepository.filtrarPorProduto());
    }

    @Override
    public List<MovimentacaoDTO> filtrarPorDataMaior() {
        return mapper.toListOfDTO(movimentacaoRepository.filtrarPorDataMaior());
    }

    @Override
    public List<MovimentacaoDTO> filtrarPorDataMenor() {
        return mapper.toListOfDTO(movimentacaoRepository.filtrarPorDataMenor());
    }
}
