package br.com.zup.orangetalents.casadocodigo.categoria.model;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

	@NotBlank
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
