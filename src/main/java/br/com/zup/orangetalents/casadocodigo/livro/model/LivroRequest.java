package br.com.zup.orangetalents.casadocodigo.livro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.orangetalents.casadocodigo.autor.model.Autor;
import br.com.zup.orangetalents.casadocodigo.categoria.model.Categoria;
import br.com.zup.orangetalents.casadocodigo.comum.validations.EntidadeExistente;
import br.com.zup.orangetalents.casadocodigo.comum.validations.UniqueValue;

public class LivroRequest {

//	@ISBN
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@DecimalMin(value = "20", inclusive = true)
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	private Integer numeroPaginas;

	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	@EntidadeExistente(referenceEntity = Categoria.class, fieldName = "id")
	private Long categoriaId;

	@NotNull
	@EntidadeExistente(referenceEntity = Autor.class)
	private Long autorId;

	public LivroRequest(@ISBN String isbn, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas,
			@NotNull Long categoriaId, @NotNull Long autorId) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Livro toModel(EntityManager entityManager) {
		Autor autor = entityManager.find(Autor.class, autorId);
		Categoria categoria = entityManager.find(Categoria.class, categoriaId);
		
		Assert.state(autor != null, "O autor informado não existe.");
		Assert.state(categoria != null, "A categoria informada não existe.");
		
		return new Livro(this.isbn, this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas,
				this.dataPublicacao, categoria, autor);
	}
	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
