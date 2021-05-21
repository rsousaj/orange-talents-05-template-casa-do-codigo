package br.com.zup.orangetalents.casadocodigo.localidade.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy = "pais", fetch = FetchType.EAGER)
	private Set<Estado> estados = new HashSet<Estado>();
	
	@Deprecated
	public Pais() {
	}
	
	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}
}
