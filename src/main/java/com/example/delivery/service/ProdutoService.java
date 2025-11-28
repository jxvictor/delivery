package com.example.delivery.service;

import com.example.delivery.model.Produto;
import com.example.delivery.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Produto> findById(Long id){
        return produtoRepository.findById(id);
    }

    public Page<Produto> findAll(Pageable pageable) {

        return produtoRepository.findAll(pageable);
    }
    public void remover(Long id) {
        produtoRepository.deleteById(id);
    }

    public void save(Produto produto) {
        produtoRepository.save(produto);
    }

}
