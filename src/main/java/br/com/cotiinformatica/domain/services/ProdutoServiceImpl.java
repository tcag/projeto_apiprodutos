package br.com.cotiinformatica.domain.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.entities.Categoria;
import br.com.cotiinformatica.domain.entities.Fornecedor;
import br.com.cotiinformatica.domain.entities.Produto;
import br.com.cotiinformatica.domain.interfaces.ProdutoService;
import br.com.cotiinformatica.dtos.ProdutoPostDto;
import br.com.cotiinformatica.dtos.ProdutoPutDto;
import br.com.cotiinformatica.repositories.CategoriaRepository;
import br.com.cotiinformatica.repositories.FornecedorRepository;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	FornecedorRepository fornecedorRepository;
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public void create(ProdutoPostDto dto) throws Exception {
		Produto produto = new Produto();
		produto.setId(UUID.randomUUID());
		produto.setNome(dto.getNome());
		produto.setPreco(new BigDecimal(dto.getPreco()));
		produto.setQuantidade(dto.getQuantidade());
		produto.setDescricao(dto.getDescricao());
		produto.setFornecedor(obterFornecedor(dto.getIdFornecedor()));
		produto.setCategoria(obterCategoria(dto.getIdCategoria()));
		produtoRepository.save(produto);
	}

	@Override
	public void update(ProdutoPutDto dto) throws Exception {
		Produto produto = findById(dto.getId());
		produto.setNome(dto.getNome());
		produto.setPreco(new BigDecimal(dto.getPreco()));
		produto.setQuantidade(dto.getQuantidade());
		produto.setDescricao(dto.getDescricao());
		produto.setFornecedor(obterFornecedor(dto.getIdFornecedor()));
		produto.setCategoria(obterCategoria(dto.getIdCategoria()));
		produtoRepository.save(produto);
	}

	@Override
	public void delete(UUID id) throws Exception {
		Produto produto = findById(id);
		produtoRepository.delete(produto);
	}

	@Override
	public List<Produto> findAll() throws Exception {
		return (List<Produto>) produtoRepository.findAll();
	}

	@Override
	public Produto findById(UUID id) throws Exception {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isEmpty())
			throw new IllegalArgumentException("Produto não encontrado. Verifique o ID informado.");
		return produto.get();
	}

	private Categoria obterCategoria(UUID id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isEmpty())
			throw new IllegalArgumentException("Erro. A categoria informada não existe.");
		return categoria.get();
	}

	private Fornecedor obterFornecedor(UUID id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		if (fornecedor.isEmpty())
			throw new IllegalArgumentException("Erro. O fornecedor informado não existe.");
		return fornecedor.get();
	}
}