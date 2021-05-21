package br.com.zup.orangetalents.casadocodigo.comum.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErroDeRequisicaoDTO {

	@JsonInclude(Include.NON_NULL)
	private String campo;
	
	private String mensagem;
	
	public ErroDeRequisicaoDTO(String mensagem) {
		this(null, mensagem);
	}
	
	public ErroDeRequisicaoDTO(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
}
