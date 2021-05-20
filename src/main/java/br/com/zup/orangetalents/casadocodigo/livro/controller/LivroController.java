package br.com.zup.orangetalents.casadocodigo.livro.controller;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.livro.dto.ListaLivroDTO;
import br.com.zup.orangetalents.casadocodigo.livro.repository.LivroRepository;

@RestController
public class LivroController {
	
	private LivroRepository livroRepository;
	
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@GetMapping("/livros")
	public Page<ListaLivroDTO> lista(Pageable page) {
		return livroRepository.findAll(page).map(ListaLivroDTO::toDTO);
	}
}
