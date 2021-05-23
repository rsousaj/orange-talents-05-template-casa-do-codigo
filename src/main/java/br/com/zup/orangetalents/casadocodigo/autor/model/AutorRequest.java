package br.com.zup.orangetalents.casadocodigo.autor.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.orangetalents.casadocodigo.comum.validations.UniqueValue;

public class AutorRequest {
	
	@NotBlank
	private String nome;
	
	@Email @NotBlank
//	@UniqueValue(domainClass = Autor.class, fieldName = "email")
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
