package br.com.zup.orangetalents.casadocodigo.autor.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.orangetalents.casadocodigo.autor.model.AutorRequest;
import br.com.zup.orangetalents.casadocodigo.autor.repository.AutorRepository;

@Component
public class EmailDuplicadoValidador implements Validator {

	private final AutorRepository autorRepository;
	
	public EmailDuplicadoValidador(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		AutorRequest autor = (AutorRequest) target;
		
		
		if (autorRepository.findByEmail(autor.getEmail()).isPresent()) {
			errors.rejectValue("email", null, "Já existe autor cadastrado com esse mesmo e-mail");
		}
	}
	

}
