package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.interfaces.ProdutoService;

@RestController
@RequestMapping(value = "/api/produtos")

public class ProdutosController {
	
	@Autowired
	ProdutoService produtoService;

	@PostMapping
	public void post() {

// TODO implementar o cadastro do produto 
	}

	@PutMapping
	public void put() { //
// TODO implementar a edição do produto
	}

	@DeleteMapping
	public void delete() {

// // TODO implementar a exclusão do produto 
	}

	@GetMapping
	public void getAll() {
		// TODO implementar a consulta de produtos
	}
}
