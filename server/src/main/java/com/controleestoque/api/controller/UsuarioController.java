package com.controleestoque.api.controller;


import com.controleestoque.api.dto.UsuarioDTO;
import com.controleestoque.domain.entity.Usuario;
import com.controleestoque.domain.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/usuario")
@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl service;


    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findOneById(@PathVariable Long id) {
        return Stream.of(service.getById(id))
                .map(ResponseEntity::ok)
                .findAny()
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> edit(@PathVariable Long id, @RequestBody Usuario usuario) {
        return Stream.of(service.edit(id,usuario))
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
