package br.com.zup.orangetalents.casadocodigo.categoria.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.orangetalents.casadocodigo.categoria.model.CategoriaRequest;
import br.com.zup.orangetalents.casadocodigo.categoria.repository.CategoriaRepository;

@Component
public class NomeDuplicadoCategoriaValidator implements Validator {

	private final CategoriaRepository categoriaRepository;
	
	public NomeDuplicadoCategoriaValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		CategoriaRequest categoria = (CategoriaRequest) target;
		
		if (categoriaRepository.findByNome(categoria.getNome()).isPresent()) {
			errors.rejectValue("nome", null, "Já existe categoria cadastrada com esse nome.");
		}
	}
	

}
