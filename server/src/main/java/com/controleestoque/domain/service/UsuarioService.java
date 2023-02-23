package com.controleestoque.domain.service;

import com.controleestoque.api.dto.UsuarioDTO;
import com.controleestoque.domain.entity.Usuario;

import java.util.List;

public interface UsuarioService {


    UsuarioDTO create(Usuario usuario);

    UsuarioDTO getById(Long id);

    List<UsuarioDTO> findAll();

    UsuarioDTO edit(Long id,Usuario usuario);

    void delete(Long id);

}
