package br.com.zup.orangetalents.casadocodigo.comum.exceptions;

public class ErroDeRequisicaoDTO {

	private String campo;
	private String mensagem;
	
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
