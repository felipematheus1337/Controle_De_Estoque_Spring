package com.controleestoque.api.controller;

import com.controleestoque.api.dto.MovimentacaoDTO;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import com.controleestoque.domain.service.impl.BusinessServiceLogicImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/business")
@RequiredArgsConstructor
public class BusinessServiceLogicController {

    private final BusinessServiceLogicImpl service;

    @GetMapping("/lancamento/{produtoId}")
    public ResponseEntity<List<MovimentacaoDTO>> filtrarPorLancamento(@PathVariable Long produtoId) {
        return ResponseEntity.ok(service.filtrarPorLancamento(produtoId));
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<MovimentacaoDTO>> filtrarPorPeriodo(@RequestParam LocalDateTime inicioPeriodo,
                                                                   @RequestParam LocalDateTime fimPeriodo) {
        return ResponseEntity.ok(service.filtrarPorPeriodo(inicioPeriodo,fimPeriodo));
    }

    @GetMapping("/tipomovimento")
    public ResponseEntity<List<MovimentacaoDTO>> filtrarTipoMovimento(@RequestParam TipoMovimentacao tipoMovimentacao) {
        return ResponseEntity.ok(service.filtrarPorTipoMovimento(tipoMovimentacao));
    }


    @GetMapping("/produto")
    public ResponseEntity<List<MovimentacaoDTO>> filtrarPorProduto() {
        return ResponseEntity.ok(service.filtrarPorProduto());
    }

    @GetMapping("/datamaior")
    public ResponseEntity<List<MovimentacaoDTO>> filtrarPorDataMaior() {
        return ResponseEntity.ok(service.filtrarPorDataMaior());
    }

    @GetMapping("/datamenor")
    public ResponseEntity<List<MovimentacaoDTO>> filtrarPorDataMenor() {
        return ResponseEntity.ok(service.filtrarPorDataMenor());
    }


}
