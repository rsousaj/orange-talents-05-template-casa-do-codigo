package br.com.zup.orangetalents.casadocodigo.livro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
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
	
	private String isbn;
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @Lob String sumario;
	private @NotNull @DecimalMin(value = "20") BigDecimal preco;
	private @NotNull @Min(value = 100) Integer numeroPaginas;
	private @Future LocalDate dataPublicacao;
	
	@ManyToOne(optional = false)
	private Categoria categoria;
	
	@ManyToOne(optional = false)
	private Autor autor;
	
	@Deprecated
	public Livro() {
	}

	public Livro(String isbn, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas, @Future LocalDate dataPublicacao,
			Categoria categoria, Autor autor) {
		this(isbn, titulo, resumo, null, preco, numeroPaginas, dataPublicacao, categoria, autor);
	}

	public Livro(String isbn, @NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

}
