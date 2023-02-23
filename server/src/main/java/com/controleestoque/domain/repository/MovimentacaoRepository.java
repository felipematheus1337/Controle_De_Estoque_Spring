package com.controleestoque.domain.repository;

import com.controleestoque.domain.entity.Movimentacao;
import com.controleestoque.domain.entity.enums.TipoMovimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {


    @Query("SELECT m FROM Movimentacao m WHERE m.produto.id = :produtoId")
    List<Movimentacao> filtrarPorLancamento(Long produtoId);

    @Query("SELECT m FROM Movimentacao m WHERE m.data BETWEEN :inicioPeriodo AND :fimPeriodo")
    List<Movimentacao> filtrarPorPeriodo(LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo);

    @Query("SELECT m FROM Movimentacao m WHERE m.tipo = :tipoMovimento")
    List<Movimentacao> filtrarPorTipoMovimento(TipoMovimentacao tipoMovimento);

    @Query("SELECT m FROM Movimentacao m JOIN m.produto p ORDER BY p.nome ASC")
    List<Movimentacao> filtrarPorProduto();

    @Query("SELECT m from Movimentacao ORDER BY m.data DESC")
    List<Movimentacao> filtrarPorDataMaior();

    @Query("SELECT m from Movimentacao ORDER BY m.data ASC")
    List<Movimentacao> filtrarPorDataMenor();


}
