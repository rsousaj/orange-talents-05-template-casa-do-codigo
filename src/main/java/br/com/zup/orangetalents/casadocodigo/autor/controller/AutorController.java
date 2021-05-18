package br.com.zup.orangetalents.casadocodigo.autor.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.autor.model.AutorForm;
import br.com.zup.orangetalents.casadocodigo.autor.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	private final AutorRepository autorRepository;
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@PostMapping
	public ResponseEntity<AutorForm> cadastrar(@RequestBody @Valid AutorForm autorForm) {
		autorRepository.save(autorForm.toModel());
		return ResponseEntity.ok().build();
	}
	
}
