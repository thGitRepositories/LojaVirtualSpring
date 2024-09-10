package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.AcessoController;
import com.example.demo.model.Acesso;
import com.example.demo.repository.AcessoRepository;
import com.example.demo.service.AcessoService;

@SpringBootTest(classes = LojaVirtualApplication.class)
class LojaVirtualApplicationTests {

	@Autowired
	private AcessoController controller;
	
	@Autowired
	private AcessoService acessoService;
	@Autowired
	private AcessoRepository acessoRepository;
	
	@Test
	public void testCadastra() {
		Acesso acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ADMIN");
		
		controller.salvar(acesso);
	}

}
