package com.controleestoque.domain.service.impl;

import com.controleestoque.api.dto.ProdutoDTO;
import com.controleestoque.api.mapper.ProdutoMapper;
import com.controleestoque.domain.repository.ProdutoRepository;
import com.controleestoque.domain.service.ProdutoService;
import com.controleestoque.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    @Override
    public ProdutoDTO create(ProdutoDTO produtoDTO) {
        var product = mapper.toEntity(produtoDTO);
        return mapper.toDTO(repository.save(product));
    }

    @Override
    public ProdutoDTO getById(Long id) {
        var productExists = repository.findById(id);

        if(productExists.isEmpty()) {
            throw new BusinessException("Product don't exist with that ID!");
        }
        return mapper.toDTO(productExists.get());
    }

    @Override
    public List<ProdutoDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public ProdutoDTO edit(Long id,ProdutoDTO dto) {
        var productExists = repository.findById(id);

        if(productExists.isEmpty()) {
            throw new BusinessException("product don't exist with that ID!");
        }
        dto.setId(id);
        return mapper.toDTO(repository.save(productExists.get()));
    }

    @Override
    public void delete(Long id) {
        var productExists = repository.findById(id);

        if(productExists.isEmpty()) {
            throw new BusinessException("product don't exist with that ID!");
        }
        repository.deleteById(id);
    }
}
