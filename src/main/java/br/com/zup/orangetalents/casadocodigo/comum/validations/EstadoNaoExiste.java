package br.com.zup.orangetalents.casadocodigo.comum.validations;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EstadoNaoExisteValidator.class)
public @interface EstadoNaoExiste {
	
	String message() default "Já existe Estado cadastrado com esse nome para esse País.";
	
	Class<?>[] groups() default { };
	
	Class<?>[] payload() default { };

}
