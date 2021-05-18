package br.com.zup.orangetalents.casadocodigo.autor.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.orangetalents.casadocodigo.autor.validations.EmailUnico;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Email @NotBlank @EmailUnico
	private String email;
	
	@NotBlank @Size(max = 400)
	private String descricao;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Autor() {
	}
	
	public Autor(@NotBlank String nome, @Email @NotBlank @EmailUnico String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
}
