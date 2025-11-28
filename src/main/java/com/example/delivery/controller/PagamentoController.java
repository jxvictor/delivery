package com.example.delivery.controller;

import com.example.delivery.model.Pagamento;
import com.example.delivery.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping(path = "/api/pagamento", produces = "application/json")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping()
    public ResponseEntity<Page<Pagamento>> listarTodos(Pageable pageable){
        try
        {
            return new ResponseEntity<>(pagamentoService.findAll(pageable), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pagamento>> obterPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(pagamentoService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid Pagamento pagamento){
        try {
            pagamentoService.save(pagamento);
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
            pagamentoService.remover(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
