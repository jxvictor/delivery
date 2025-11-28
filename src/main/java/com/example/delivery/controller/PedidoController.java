package com.example.delivery.controller;


import com.example.delivery.model.Pedido;
import com.example.delivery.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping(path = "/api/pedido", produces = "application/json")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping()
    public ResponseEntity<Page<Pedido>> listarTodos(Pageable pageable){
        try
        {
            return new ResponseEntity<>(pedidoService.findAll(pageable), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> obterPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid Pedido pedido){
        try {
            pedidoService.save(pedido);
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
            pedidoService.remover(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
