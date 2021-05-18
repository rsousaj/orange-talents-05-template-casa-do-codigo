package br.com.zup.orangetalents.casadocodigo.autor.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.autor.model.AutorRequest;
import br.com.zup.orangetalents.casadocodigo.autor.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	private final AutorRepository autorRepository;
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@PostMapping
	public ResponseEntity<AutorRequest> cadastrar(@RequestBody @Valid AutorRequest autorRequest) {
		autorRepository.save(autorRequest.toModel());
		return ResponseEntity.ok().build();
	}
	
}
