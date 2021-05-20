package br.com.zup.orangetalents.casadocodigo.livro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ISBN
	private String isbn;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@Lob
	private String sumario;
	
	@NotNull
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;
	
	@Future
	private LocalDate dataPublicacao;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {
	}

	public Livro(@ISBN String isbn, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas, @Future LocalDate dataPublicacao,
			Categoria categoria, Autor autor) {
		this(isbn, titulo, resumo, null, preco, numeroPaginas, dataPublicacao, categoria, autor);
	}

	public Livro(@ISBN String isbn, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas, @Future LocalDate dataPublicacao,
			Categoria categoria, Autor autor) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

}
