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
import br.com.zup.orangetalents.casadocodigo.livro.model.LivroRequest;
import br.com.zup.orangetalents.casadocodigo.livro.repository.LivroRepository;

@RestController
@RequestMapping
public class AdicionaLivroController {

	private final LivroRepository livroRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public AdicionaLivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	@PostMapping("/livros")
	public ResponseEntity<?> cadastra(@RequestBody @Valid LivroRequest livro) {
		livroRepository.save(livro.toModel(entityManager));
		return ResponseEntity.ok().build();
	}
}
