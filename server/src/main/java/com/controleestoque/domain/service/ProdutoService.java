package com.controleestoque.domain.service;

import com.controleestoque.api.dto.ProdutoDTO;
import com.controleestoque.domain.entity.Produto;


import java.util.List;

public interface ProdutoService {

    ProdutoDTO create(Produto produto);


    ProdutoDTO getById(Long id);

    List<ProdutoDTO> findAll();

    ProdutoDTO edit(Long id,Produto produto);

    void delete(Long id);

}
