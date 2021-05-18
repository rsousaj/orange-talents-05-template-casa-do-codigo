package br.com.zup.orangetalents.casadocodigo.categoria.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.categoria.model.CategoriaRequest;
import br.com.zup.orangetalents.casadocodigo.categoria.repository.CategoriaRepository;
import br.com.zup.orangetalents.casadocodigo.categoria.validations.NomeDuplicadoCategoriaValidator;

@RestController
public class NovaCategoriaController {
	
	private final CategoriaRepository categoriaRepository;
	private final NomeDuplicadoCategoriaValidator nomeDuplicadoCategoriaValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(nomeDuplicadoCategoriaValidator);
	}
	
	public NovaCategoriaController(CategoriaRepository categoriaRepository,
			NomeDuplicadoCategoriaValidator nomeDuplicadoCategoriaValidator) {
		this.categoriaRepository = categoriaRepository;
		this.nomeDuplicadoCategoriaValidator = nomeDuplicadoCategoriaValidator;
	}

	@PostMapping("/categoria")
	public ResponseEntity<?> cadastra(@RequestBody @Valid CategoriaRequest categoria) {
		categoriaRepository.save(categoria.toModel());
		return ResponseEntity.ok().build();
	}
}
