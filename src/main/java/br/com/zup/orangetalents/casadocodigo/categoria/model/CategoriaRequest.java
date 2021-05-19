package br.com.zup.orangetalents.casadocodigo.categoria.model;

import javax.validation.constraints.NotBlank;

import br.com.zup.orangetalents.casadocodigo.comum.validations.UniqueValue;

public class CategoriaRequest {

	@NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public CategoriaRequest() {
	}
	
	public Categoria toModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return this.nome;
	}
}
