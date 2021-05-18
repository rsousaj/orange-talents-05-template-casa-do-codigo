package br.com.zup.orangetalents.casadocodigo.autor.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeFormularioHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public List<ErroDeFormularioDTO> argumentoInvalido(MethodArgumentNotValidException ex) {
		List<ErroDeFormularioDTO> erros =  new ArrayList<ErroDeFormularioDTO>();
		
		ex.getFieldErrors().forEach(fieldError -> {
			String campo = fieldError.getField();
			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			
			erros.add(new ErroDeFormularioDTO(campo, mensagem));
		});
		
		return erros;
	}
}
