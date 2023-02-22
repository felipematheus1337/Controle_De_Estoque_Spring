package com.controleestoque.domain.service;

import com.controleestoque.api.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {


    UsuarioDTO create(UsuarioDTO usuarioDTO);

    UsuarioDTO getById(Long id);

    List<UsuarioDTO> findAll();

    UsuarioDTO edit(Long id,UsuarioDTO dto);

    void delete(Long id);

}
