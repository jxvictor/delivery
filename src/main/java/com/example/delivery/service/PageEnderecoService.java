package com.example.delivery.service;

import com.example.delivery.model.Endereco;
import com.example.delivery.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PageEnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Page<Endereco> findAll(Pageable pageable){
        return enderecoRepository.findAll(pageable);
    }
}