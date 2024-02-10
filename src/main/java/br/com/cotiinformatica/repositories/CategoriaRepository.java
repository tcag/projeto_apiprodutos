package br.com.cotiinformatica.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cotiinformatica.domain.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

}
