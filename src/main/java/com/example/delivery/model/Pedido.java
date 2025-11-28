package com.example.delivery.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private User cliente;


    @ManyToOne
    private Restaurante restaurante;


    @ManyToOne
    private Endereco enderecoEntrega;


    @Enumerated(EnumType.STRING)
    private StatusPedido status;


    private BigDecimal valorTotal;
    private LocalDateTime dataPedido;
}