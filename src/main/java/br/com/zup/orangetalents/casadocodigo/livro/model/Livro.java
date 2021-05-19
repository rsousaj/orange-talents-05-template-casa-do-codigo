package br.com.zup.orangetalents.casadocodigo.livro.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

import com.sun.istack.NotNull;

import br.com.zup.orangetalents.casadocodigo.autor.model.Autor;
import br.com.zup.orangetalents.casadocodigo.categoria.model.Categoria;
import br.com.zup.orangetalents.casadocodigo.comum.validations.UniqueValue;

@Entity
public class Livro {

	@Id
	@ISBN @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private Long isbn;
	
	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@Lob
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private Integer preco;
	
	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;
	
	@Future
	private LocalDateTime dataPublicacao;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Autor autor;
}
