package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Acesso;
import com.example.demo.repository.AcessoRepository;
import com.example.demo.service.AcessoService;

@RestController
@RequestMapping("/api")
public class AcessoController {

    @Autowired
    private AcessoService service;

    @Autowired
    private AcessoRepository repository;

    @PostMapping("/salvarAcesso")
    public ResponseEntity<Acesso> salvar(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = repository.save(acesso);
        return new ResponseEntity<>(acessoSalvo, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAcesso/{id}")
    public ResponseEntity<Void> deleteAcesso(@PathVariable("id") Long id) {
        if (id == null || !repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        return new ResponseEntity("Acesso Removido",HttpStatus.OK);
    }
}