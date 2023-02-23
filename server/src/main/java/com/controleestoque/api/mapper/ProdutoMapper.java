package com.controleestoque.api.mapper;



import com.controleestoque.api.dto.CadastrarGerente;
import com.controleestoque.api.dto.ProdutoDTO;
import com.controleestoque.domain.entity.Produto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoMapper {

    private final ModelMapper mapper;

    public Produto toEntity(ProdutoDTO dto) {
        return mapper.map(dto, Produto.class);
    }

    public ProdutoDTO toDTO(Produto produto) {
        return mapper.map(produto, ProdutoDTO.class);
    }

    public List<ProdutoDTO> toDTOList(List<Produto> produtoList) {
        return produtoList
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Produto cadastrarGerenteToEntity(CadastrarGerente cadastrarGerente) {
        return mapper.map(cadastrarGerente, Produto.class);
    }

    public ProdutoDTO cadastrarGerenteToDTO(CadastrarGerente cadastrarGerente) {
        return mapper.map(cadastrarGerente, ProdutoDTO.class);
    }
}
