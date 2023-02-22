package com.controleestoque.domain.service;

import com.controleestoque.api.dto.MovimentacaoDTO;

import java.util.List;

public interface MovimentacaoService {

    MovimentacaoDTO create(MovimentacaoDTO MovimentacaoDTO);

    MovimentacaoDTO getById(Long id);

    List<MovimentacaoDTO> findAll();

    MovimentacaoDTO edit(Long id,MovimentacaoDTO dto);

    void delete(Long id);
}
