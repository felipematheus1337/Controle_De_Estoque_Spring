package com.controleestoque.domain.service.impl;

import com.controleestoque.api.dto.ProdutoDTO;
import com.controleestoque.api.mapper.MovimentacaoMapper;
import com.controleestoque.api.mapper.ProdutoMapper;
import com.controleestoque.domain.entity.Produto;
import com.controleestoque.domain.repository.MovimentacaoRepository;
import com.controleestoque.domain.repository.ProdutoRepository;
import com.controleestoque.domain.service.ProdutoService;
import com.controleestoque.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;
    private final MovimentacaoRepository movimentacaoRepository;
    private final ProdutoMapper mapper;
    private final MovimentacaoMapper movimentacaoMapper;

    @Override
    public ProdutoDTO create(Produto produto) {
      var produtoSaved = repository.save(produto);
      movimentacaoRepository.saveAll(produtoSaved.getMovimentacoes());
      return mapper.toDTO(produtoSaved);
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
    public ProdutoDTO edit(Long id,Produto produto) {
        var productExists = repository.findById(id);

        if(productExists.isEmpty()) {
            throw new BusinessException("product don't exist with that ID!");
        }
        produto.setId(id);
        return mapper.toDTO(repository.save(produto));
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
