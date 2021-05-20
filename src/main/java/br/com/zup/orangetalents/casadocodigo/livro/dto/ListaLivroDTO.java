package br.com.zup.orangetalents.casadocodigo.livro.dto;

import br.com.zup.orangetalents.casadocodigo.livro.model.Livro;

public class ListaLivroDTO {
	
	private String isbn;
	private String titulo;
	
	public ListaLivroDTO(String isbn, String titulo) {
		this.isbn = isbn;
		this.titulo = titulo;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public static ListaLivroDTO toDTO(Livro livro) {
		return new ListaLivroDTO(livro.getIsbn(), livro.getTitulo());
	}
}
