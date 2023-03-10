package com.controleestoque.domain.service.impl;

import com.controleestoque.api.dto.UsuarioDTO;
import com.controleestoque.api.mapper.UsuarioMapper;
import com.controleestoque.domain.entity.Usuario;
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
    public UsuarioDTO create(Usuario usuario) {
        return mapper.toDTO(repository.save(usuario));

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
    public UsuarioDTO edit(Long id,Usuario usuario) {
        var userExists = repository.findById(id);

        if(userExists.isEmpty()) {
            throw new BusinessException("User don't exist with that ID!");
        }
        usuario.setId(id);
        return mapper.toDTO(repository.save(usuario));
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
