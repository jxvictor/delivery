package com.example.delivery.controller;

import com.example.delivery.model.Endereco;
import com.example.delivery.service.EnderecoService;
import com.example.delivery.service.PageEnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/endereco", produces = "application/json")
public class EnderecoController {

    @Autowired
    private EnderecoService cepService;

    @Autowired
    private PageEnderecoService pageEnderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        Endereco endereco = cepService.buscarEnderecoPor(cep);
        try
        {
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Page<Endereco>> obterTodos(Pageable pageable){
        try
        {
            return new ResponseEntity<>(pageEnderecoService.findAll(pageable), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}