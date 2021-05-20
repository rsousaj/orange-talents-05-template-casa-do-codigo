package br.com.zup.orangetalents.casadocodigo.livro.dto;

import java.math.BigDecimal;

import br.com.zup.orangetalents.casadocodigo.autor.dto.AutorDTO;
import br.com.zup.orangetalents.casadocodigo.livro.model.Livro;

public class DetalheLivroDTO {

	private String isbn;
	
	private String titulo;
	
	private String resumo;
	
	private String sumario;
	
	private BigDecimal preco;
	
	private AutorDTO autor;
	
	public DetalheLivroDTO(String isbn, String titulo, String resumo, String sumario, BigDecimal preco,
			AutorDTO autor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
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

	public AutorDTO getAutor() {
		return autor;
	}
	
	public static DetalheLivroDTO toDto(Livro livro) {
		return new DetalheLivroDTO(livro.getIsbn(),
				livro.getTitulo(),
				livro.getResumo(),
				livro.getSumario(),
				livro.getPreco(),
				AutorDTO.toDto(livro.getAutor()));
	}
}
