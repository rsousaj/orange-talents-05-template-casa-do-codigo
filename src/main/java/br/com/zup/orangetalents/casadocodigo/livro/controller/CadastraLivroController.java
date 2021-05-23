package br.com.zup.orangetalents.casadocodigo.livro.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.autor.model.Autor;
import br.com.zup.orangetalents.casadocodigo.autor.repository.AutorRepository;
import br.com.zup.orangetalents.casadocodigo.categoria.model.Categoria;
import br.com.zup.orangetalents.casadocodigo.categoria.repository.CategoriaRepository;
import br.com.zup.orangetalents.casadocodigo.livro.model.Livro;
import br.com.zup.orangetalents.casadocodigo.livro.model.LivroRequest;
import br.com.zup.orangetalents.casadocodigo.livro.repository.LivroRepository;

@RestController
@RequestMapping
public class CadastraLivroController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping("/livros")
	public ResponseEntity<?> cadastra(@RequestBody @Valid LivroRequest livro) {
		entityManager.persist(livro.toModel(entityManager));
		return ResponseEntity.ok().build();
	}
}
