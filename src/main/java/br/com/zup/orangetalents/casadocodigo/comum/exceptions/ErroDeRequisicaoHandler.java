package br.com.zup.orangetalents.casadocodigo.comum.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeRequisicaoHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public List<ErroDeRequisicaoDTO> argumentoInvalido(MethodArgumentNotValidException ex) {
		List<ErroDeRequisicaoDTO> erros =  new ArrayList<ErroDeRequisicaoDTO>();
		
		ex.getFieldErrors().forEach(fieldError -> {
			String campo = fieldError.getField();			
			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			
			erros.add(new ErroDeRequisicaoDTO(campo, mensagem));
		});
		
		return erros;
	}
}
