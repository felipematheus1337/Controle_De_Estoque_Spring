package com.controleestoque.domain.service;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.domain.entity.Movimentacao;

import java.util.List;

public interface MovimentacaoService {

    MovimentacaoDTO create(Movimentacao movimentacao);

    MovimentacaoDTO getById(Long id);

    List<MovimentacaoDTO> findAll();

    MovimentacaoDTO edit(Long id,Movimentacao movimentacao);

    void delete(Long id);
}
