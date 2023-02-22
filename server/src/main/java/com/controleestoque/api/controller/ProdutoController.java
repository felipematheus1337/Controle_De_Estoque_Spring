package com.controleestoque.api.controller;

import com.controleestoque.api.dto.ProdutoDTO;
import com.controleestoque.domain.service.impl.ProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/produto")
@RestController
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProdutoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
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
    public ResponseEntity<ProdutoDTO> edit(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
        return Stream.of(service.edit(id,dto))
                .map(ResponseEntity::ok)
                .findAny()
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

}
