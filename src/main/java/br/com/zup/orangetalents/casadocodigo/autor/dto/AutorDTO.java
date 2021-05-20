package br.com.zup.orangetalents.casadocodigo.autor.dto;

import br.com.zup.orangetalents.casadocodigo.autor.model.Autor;

public class AutorDTO {
	
	private String nome;
	
	private String descricao;
	
	public AutorDTO(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static AutorDTO toDto(Autor autor) {
		return new AutorDTO(autor.getNome(), autor.getDescricao());
	}
}
