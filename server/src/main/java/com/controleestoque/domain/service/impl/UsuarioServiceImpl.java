package com.controleestoque.domain.service.impl;

import com.controleestoque.api.dto.UsuarioDTO;
import com.controleestoque.api.mapper.UsuarioMapper;
import com.controleestoque.domain.repository.UsuarioRepository;
import com.controleestoque.domain.service.UsuarioService;
import com.controleestoque.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl  implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;


    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        var user = mapper.toEntity(usuarioDTO);
        return mapper.toDTO(repository.save(user));

    }

    @Override
    public UsuarioDTO getById(Long id) {
        var userExists = repository.findById(id);

        if(userExists.isEmpty()) {
            throw new BusinessException("User don't exist with that ID!");
        }
        return mapper.toDTO(userExists.get());
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public UsuarioDTO edit(Long id,UsuarioDTO dto) {
        var userExists = repository.findById(id);

        if(userExists.isEmpty()) {
            throw new BusinessException("User don't exist with that ID!");
        }
        dto.setId(id);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        var userExists = repository.findById(id);

        if(userExists.isEmpty()) {
            throw new BusinessException("User don't exist with that ID!");
        }
        repository.deleteById(id);
    }
}
