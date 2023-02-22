package com.controleestoque.api.mapper;

import com.controleestoque.api.dto.UsuarioDTO;
import com.controleestoque.domain.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    private final ModelMapper mapper;

    public Usuario toEntity(UsuarioDTO dto) {
        return mapper.map(dto, Usuario.class);
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        return mapper.map(usuario, UsuarioDTO.class);
    }

    public List<UsuarioDTO> toDTOList(List<Usuario> usuarioList) {
        return usuarioList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
