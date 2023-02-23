package com.controleestoque.domain.service.impl;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.api.mapper.MovimentacaoMapper;
import com.controleestoque.domain.entity.Movimentacao;
import com.controleestoque.domain.repository.MovimentacaoRepository;
import com.controleestoque.domain.service.MovimentacaoService;
import com.controleestoque.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentacaoServiceImpl  implements MovimentacaoService {

    private final MovimentacaoRepository repository;
    private final MovimentacaoMapper mapper;

    @Override
    public MovimentacaoDTO create(Movimentacao moviment) {
        return mapper.toDTO(repository.save(moviment));
    }

    @Override
    public MovimentacaoDTO getById(Long id) {
        var movimentExists = repository.findById(id);

        if(movimentExists.isEmpty()) {
            throw new BusinessException("moviment don't exist with that ID!");
        }
        return mapper.toDTO(movimentExists.get());
    }

    @Override
    public List<MovimentacaoDTO> findAll() {
        return mapper.toListOfDTO(repository.findAll());
    }

    @Override
    public MovimentacaoDTO edit(Long id,Movimentacao movimentacao) {
        var movimentExists = repository.findById(id);

        if(movimentExists.isEmpty()) {
            throw new BusinessException("moviment don't exist with that ID!");
        }
        movimentacao.setId(id);
        return mapper.toDTO(repository.save(movimentacao));
    }

    @Override
    public void delete(Long id) {
        var movimentExists = repository.findById(id);

        if(movimentExists.isEmpty()) {
            throw new BusinessException("moviment don't exist with that ID!");
        }
        repository.deleteById(id);
    }
}
