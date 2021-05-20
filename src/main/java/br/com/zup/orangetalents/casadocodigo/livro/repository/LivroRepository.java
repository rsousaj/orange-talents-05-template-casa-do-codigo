package br.com.zup.orangetalents.casadocodigo.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.orangetalents.casadocodigo.livro.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
