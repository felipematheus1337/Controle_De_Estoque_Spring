package com.controleestoque.api.controller;

import com.controleestoque.api.dto.ProdutoDTO;
import com.controleestoque.api.mapper.ProdutoMapper;
import com.controleestoque.domain.entity.Produto;
import com.controleestoque.domain.repository.ProdutoRepository;
import com.controleestoque.domain.service.impl.ProdutoServiceImpl;
import com.controleestoque.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/produto")
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProdutoController {

    private final ProdutoServiceImpl service;
    private final ProdutoMapper mapper;
    private final ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Produto produto) {
       return ResponseEntity.status(HttpStatus.CREATED).body(service.create(produto));

    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findOneById(@PathVariable Long id) {
        return Stream.of(service.getById(id))
                .map(ResponseEntity::ok)
                .findAny()
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> edit(@PathVariable Long id, @RequestBody Produto produto) {
        return Stream.of(service.edit(id,produto))
                .map(ResponseEntity::ok)
                .findAny()
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    // REGRA DE NEGÓCIO
    @PostMapping("/gerente/cadastrar")
    public ResponseEntity<ProdutoDTO> cadastrarProdutoGerente(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(produto));
    }

    @PutMapping("/gerente/editar/{id}")
    public ResponseEntity<ProdutoDTO> editarProdutoGerente(@PathVariable Long id,
                                                              @RequestBody Produto produto) {
        if (produto.getSaldoInicial() != null) {
            throw new BusinessException("Não é possível alterar um saldo Inicial!");
        }
        return Stream.of(service.edit(id,produto))
                .map(ResponseEntity::ok)
                .findAny()
                .orElse(ResponseEntity.notFound().build());
    }

}
