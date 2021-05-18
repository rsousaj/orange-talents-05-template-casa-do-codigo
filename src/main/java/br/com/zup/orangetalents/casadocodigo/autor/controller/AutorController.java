package br.com.zup.orangetalents.casadocodigo.autor.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.autor.model.AutorRequest;
import br.com.zup.orangetalents.casadocodigo.autor.repository.AutorRepository;
import br.com.zup.orangetalents.casadocodigo.autor.validations.EmailDuplicadoValidador;

@RestController
@RequestMapping("/autor")
public class AutorController {

	private final AutorRepository autorRepository;
	
	private final EmailDuplicadoValidador emailDuplicadoValidador;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(emailDuplicadoValidador);
	}
	
	public AutorController(AutorRepository autorRepository, EmailDuplicadoValidador emailDuplicadoValidador) {
		this.autorRepository = autorRepository;
		this.emailDuplicadoValidador = emailDuplicadoValidador;
	}
	
	@PostMapping
	public ResponseEntity<AutorRequest> cadastrar(@RequestBody @Valid AutorRequest autorRequest) {
		autorRepository.save(autorRequest.toModel());
		return ResponseEntity.ok().build();
	}
	
}
