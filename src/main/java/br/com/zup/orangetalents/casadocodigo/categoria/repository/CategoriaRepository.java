package br.com.zup.orangetalents.casadocodigo.categoria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.orangetalents.casadocodigo.categoria.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

	Optional<Categoria> findByNome(String nome);
}
