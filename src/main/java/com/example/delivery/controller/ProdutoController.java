package com.example.delivery.controller;
import com.example.delivery.model.Produto;
import com.example.delivery.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping(path = "/api/produto", produces = "application/json")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<Page<Produto>> listarTodos(Pageable pageable){
        try
        {
            return new ResponseEntity<>(produtoService.findAll(pageable), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid Produto produto){
        try {
            produtoService.save(produto);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable long id){
        try
        {
            produtoService.remover(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editar(@PathVariable(value="id") Long id, @RequestBody @Valid Produto produto) {
        Optional<Produto> us = produtoService.findById(id);
        try
        {
            produto.setNome(us.get().getNome());
            produto.setDescricao(us.get().getDescricao());
            produto.setPreco(us.get().getPreco());
            produtoService.save(produto);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}