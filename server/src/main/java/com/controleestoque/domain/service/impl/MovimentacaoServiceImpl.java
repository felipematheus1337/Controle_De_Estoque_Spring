package com.controleestoque.domain.service.impl;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.api.mapper.MovimentacaoMapper;
import com.controleestoque.api.mapper.ProdutoMapper;
import com.controleestoque.domain.entity.Movimentacao;
import com.controleestoque.domain.entity.Produto;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.domain.repository.MovimentacaoRepository;
import com.controleestoque.domain.repository.ProdutoRepository;
import com.controleestoque.domain.service.MovimentacaoService;
import com.controleestoque.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentacaoServiceImpl  implements MovimentacaoService {

    private final MovimentacaoRepository repository;
    private final ProdutoRepository produtoRepository;
    private final MovimentacaoMapper mapper;

    @Override
    public MovimentacaoDTO create(Movimentacao moviment) {
        var productOptional = produtoRepository.findById(moviment.getProduto().getId());

        if(productOptional.isEmpty()) {
            throw new BusinessException("Não é possível adicionar movimentação para produto inexistente!");
        }
        var product = productOptional.get();

        if (moviment.getTipo() == TipoMovimentacao.SALDO_INICIAL && !product.getMovimentacoes().isEmpty()) {
            throw new BusinessException("Não é possível lançar o SALDO_INICIAL, após outros lançamentos!");
        }
        if (moviment.getTipo() == TipoMovimentacao.AJUSTE_ENTRADA || moviment.getTipo() == TipoMovimentacao.AJUSTE_SAÍDA) {
            checkIfIsValidAjuste(moviment.getProduto(), moviment.getTipo());
        }


        var movimentSaved = repository.save(moviment);

        return mapper.toDTO(movimentSaved);
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

    private void checkIfIsValidAjuste(Produto produto, TipoMovimentacao tipoMovimentacao) {
         if(produto.getMovimentacoes() == null) {
               throw new BusinessException("Não é possível realizar ajuste sem lançamento prévio!");
         }
    }




}
