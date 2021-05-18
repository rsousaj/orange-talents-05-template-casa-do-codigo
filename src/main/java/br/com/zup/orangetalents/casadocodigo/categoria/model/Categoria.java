package br.com.zup.orangetalents.casadocodigo.categoria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@Deprecated
	public Categoria() {
		
	}

	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}
}
