package br.com.cotiinformatica.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.entities.Categoria;
import br.com.cotiinformatica.domain.interfaces.CategoriaService;
import br.com.cotiinformatica.dtos.CategoriaGetDto;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriasController {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public List<CategoriaGetDto> getAll() {
		try {
			List<Categoria> categorias = categoriaService.findAll();

			List<CategoriaGetDto> result = modelMapper.map(categorias, new TypeToken<List<CategoriaGetDto>>() {
			}.getType());
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
