package br.com.zup.orangetalents.casadocodigo.localidade.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.localidade.model.EstadoRequest;

@RestController
public class EstadoController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@PostMapping("/estado")
	public ResponseEntity<?> cadastra(@RequestBody @Valid EstadoRequest estado) {
		entityManager.persist(estado.toModel(entityManager));
		
		return ResponseEntity.ok().build();
	}
}
