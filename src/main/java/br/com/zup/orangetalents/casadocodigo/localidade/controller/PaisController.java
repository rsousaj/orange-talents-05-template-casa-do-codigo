package br.com.zup.orangetalents.casadocodigo.localidade.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.localidade.model.PaisRequest;

@RestController
@RequestMapping
public class PaisController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@PostMapping("/pais")
	public ResponseEntity<?> cadastra(@RequestBody @Valid PaisRequest pais) {
		entityManager.persist(pais.toModel());
		
		return ResponseEntity.ok().build();
	}
}
