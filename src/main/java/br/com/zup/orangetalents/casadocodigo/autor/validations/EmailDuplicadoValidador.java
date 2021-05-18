package br.com.zup.orangetalents.casadocodigo.autor.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zup.orangetalents.casadocodigo.autor.repository.AutorRepository;

public class EmailDuplicadoValidador implements ConstraintValidator<EmailUnico, String> {

	private final AutorRepository autorRepository;
	
	public EmailDuplicadoValidador(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (autorRepository.findByEmail(email).isPresent()) {
			return false;
		}
		return true;
	}

}
