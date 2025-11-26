package com.example.delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Pagamento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    private Pedido pedido;


    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodo;


    private BigDecimal valor;
    private boolean pago;
    private LocalDateTime dataPagamento;
}