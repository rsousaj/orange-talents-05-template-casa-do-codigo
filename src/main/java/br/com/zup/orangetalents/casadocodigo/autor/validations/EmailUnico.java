package br.com.zup.orangetalents.casadocodigo.autor.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailDuplicadoValidador.class)
public @interface EmailUnico {
	
	String message() default "O e-mail informado já existe.";
	
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};
}
