package br.com.zup.orangetalents.casadocodigo.comum.validations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import br.com.zup.orangetalents.casadocodigo.localidade.model.EstadoRequest;

public class EstadoNaoExisteValidator implements ConstraintValidator<EstadoNaoExiste, EstadoRequest> {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean isValid(EstadoRequest value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("select 1 from Estado e where e.nome = :nomeEstado AND e.pais.id = :paisId");
		query.setParameter("nomeEstado", value.getNome());
		query.setParameter("paisId", value.getPaisId());
		
		List result = query.getResultList();
		
		Assert.state(result.size() <= 1, "Existe mais de um estado " + value.getNome() + " no país de ID: " + value.getPaisId());
		
		return result.isEmpty();
	}
}
