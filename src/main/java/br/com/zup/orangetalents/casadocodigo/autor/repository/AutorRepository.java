package br.com.zup.orangetalents.casadocodigo.autor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.orangetalents.casadocodigo.autor.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);
}
