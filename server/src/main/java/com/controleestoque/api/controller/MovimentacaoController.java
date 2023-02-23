package com.controleestoque.api.controller;


import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.domain.entity.Movimentacao;
import com.controleestoque.domain.service.impl.MovimentacaoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/movimentacao")
@RestController
@RequiredArgsConstructor
public class MovimentacaoController {

    private final MovimentacaoServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> createMoviment(@RequestBody Movimentacao movimentacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(movimentacao));
    }

    @GetMapping
    public ResponseEntity<List<MovimentacaoDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoDTO> findOneById(@PathVariable Long id) {
        return Stream.of(service.getById(id))
                .map(ResponseEntity::ok)
                .findAny()
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovimentacaoDTO> edit(@PathVariable Long id, @RequestBody Movimentacao movimentacao) {
        return Stream.of(service.edit(id,movimentacao))
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
