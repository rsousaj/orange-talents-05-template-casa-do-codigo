package br.com.zup.orangetalents.casadocodigo.comum.validations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.orangetalents.casadocodigo.cliente.model.ClienteRequest;

@Component
public class EstadoSelecionadoValidator implements Validator {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ClienteRequest request = (ClienteRequest) target;
		
		if (errors.hasErrors()) {
			return;
		}
		
		if (request.getEstadoId() == null) {
			Query query = entityManager.createQuery("select 1 from Estado e WHERE e.pais.id = :paisId");
			query.setParameter("paisId", request.getPaisId());
			
			List result = query.getResultList();
			
			if (!result.isEmpty()) {
				errors.rejectValue("estadoId", "", "Informe o Estado.");
			}
		} else {
			Query query = entityManager.createQuery("select 1 from Estado e WHERE e.pais.id = :paisId AND e.id = :estadoId");
			query.setParameter("paisId", request.getPaisId());
			query.setParameter("estadoId", request.getEstadoId());
			
			List result = query.getResultList();
			
			if (result.isEmpty()) {
				errors.rejectValue("estadoId", "", "Estado informado é inválido");
			}
		}
	}

	
}
