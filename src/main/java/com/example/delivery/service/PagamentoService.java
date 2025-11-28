package com.example.delivery.service;

import com.example.delivery.model.Pagamento;
import com.example.delivery.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Optional<Pagamento> findById(Long id){
        return pagamentoRepository.findById(id);
    }

    public Page<Pagamento> findAll(Pageable pageable) {

        return pagamentoRepository.findAll(pageable);
    }
    public void remover(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public void save(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }

}
