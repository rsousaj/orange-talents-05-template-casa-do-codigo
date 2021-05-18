package br.com.zup.orangetalents.casadocodigo.autor.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.orangetalents.casadocodigo.autor.validations.EmailUnico;

public class AutorRequest {
	
	@NotBlank
	private String nome;
	
	@Email @NotBlank @EmailUnico
	private String email;
	
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
