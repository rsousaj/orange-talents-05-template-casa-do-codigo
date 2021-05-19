package br.com.zup.orangetalents.casadocodigo.autor.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.orangetalents.casadocodigo.livro.model.Livro;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Email @NotBlank
	private String email;
	
	@NotBlank @Size(max = 400)
	private String descricao;
	
	@OneToMany(mappedBy = "autor")
	private Set<Livro> livros = new HashSet<Livro>();
	
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Autor() {
	}
	
	public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
}
