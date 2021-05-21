package br.com.zup.orangetalents.casadocodigo.localidade.model;

import javax.validation.constraints.NotBlank;

import br.com.zup.orangetalents.casadocodigo.comum.validations.UniqueValue;

public class PaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}
}
