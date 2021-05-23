package br.com.zup.orangetalents.casadocodigo.comum.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EntidadeExistenteValidator.class)
public @interface EntidadeExistente {

	String message() default "{javax.validation.constraints.ExistsEntity.message}";
	

	/**
	 * @author rsousadj
	 *
	 * A entidade que é referenciada por este campo.
	 */
	Class<?> referenceEntity();
	

	/**
	 * @author rsousadj
	 *
	 * O campo em que é feito referência. Default: "id"
	 */
	String fieldName() default "id";
	
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}