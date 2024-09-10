package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Acesso;
import com.example.demo.repository.AcessoRepository;

@Service
public class AcessoService {
	@Autowired
	private AcessoRepository acessoRepository;
	
	
	public Acesso save(Acesso acesso) {
		return acessoRepository.save(acesso);
	}
	
}
