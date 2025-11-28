package com.example.delivery.service;

import com.example.delivery.model.Pedido;
import com.example.delivery.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Optional<Pedido> findById(Long id){
        return pedidoRepository.findById(id);
    }

    public Page<Pedido> findAll(Pageable pageable) {

        return pedidoRepository.findAll(pageable);
    }
    public void remover(Long id) {
        pedidoRepository.deleteById(id);
    }

    public void save(Pedido pedido) {
        pedidoRepository.save(pedido);
    }
}
