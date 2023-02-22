package com.controleestoque.api.mapper;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.domain.entity.Movimentacao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovimentacaoMapper {
    private final ModelMapper mapper;

    public Movimentacao toEntity(MovimentacaoDTO dto) {
        return mapper.map(dto, Movimentacao.class);
    }

    public MovimentacaoDTO toDTO(Movimentacao movimentacao) {
        return mapper.map(movimentacao, MovimentacaoDTO.class);
    }

    public List<MovimentacaoDTO> toListOfDTO(List<Movimentacao> movimentacaoList) {
        return movimentacaoList
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
