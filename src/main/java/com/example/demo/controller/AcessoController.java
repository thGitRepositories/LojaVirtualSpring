package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Acesso;
import com.example.demo.service.AcessoService;

@Controller
public class AcessoController {
	
	@Autowired
	private AcessoService service;
	
	@PostMapping("/salavarAcesso")
	public Acesso salvar(Acesso acesso) {
		
		return service.save(acesso);
	}
}
