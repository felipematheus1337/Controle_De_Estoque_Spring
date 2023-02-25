    package com.controleestoque.api.dto;

    import com.controleestoque.domain.entity.Movimentacao;
    import com.controleestoque.domain.entity.Produto;
    import com.controleestoque.domain.entity.enums.TipoMovimentacao;
    import com.controleestoque.exception.BusinessException;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import jakarta.persistence.*;
    import lombok.*;

    import java.math.BigDecimal;
    import java.time.LocalDateTime;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class MovimentacaoDTO {

        private Long id;


        private BigDecimal quantidade;


        private BigDecimal saldo;


        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        private LocalDateTime data = LocalDateTime.now();

        @Enumerated(EnumType.STRING)
        private TipoMovimentacao tipo;

        private String motivo;

        private String documento;

        private ProdutoDTO produto;

        public MovimentacaoDTO(TipoMovimentacao tipo, BigDecimal quantidade, ProdutoDTO produto) {
            this.tipo = tipo;
            this.quantidade = quantidade;
            this.produto = produto;
        }

        public MovimentacaoDTO(TipoMovimentacao tipo, BigDecimal quantidade) {
            this.tipo = tipo;
            this.quantidade = quantidade;
        }




    }
