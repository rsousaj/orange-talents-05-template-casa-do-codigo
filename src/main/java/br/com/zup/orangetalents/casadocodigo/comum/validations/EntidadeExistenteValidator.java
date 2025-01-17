package br.com.zup.orangetalents.casadocodigo.comum.validations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntidadeExistenteValidator implements ConstraintValidator<EntidadeExistente, Object> {
	
	private String fieldName;
	private Class<?> klass;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void initialize(EntidadeExistente anotacao) {
		this.fieldName = anotacao.fieldName();
		this.klass = anotacao.referenceEntity();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("select 1 from " + klass.getName() + " where " + this.fieldName + " = :id" );
		query.setParameter("id", value);
		
		return !query.getResultList().isEmpty();
	}
}
