package com.controleestoque.domain.repository;

import com.controleestoque.domain.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
