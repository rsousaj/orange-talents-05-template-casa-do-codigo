package br.com.zup.orangetalents.casadocodigo.cliente.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.casadocodigo.cliente.model.Cliente;
import br.com.zup.orangetalents.casadocodigo.cliente.model.ClienteCadastradoDTO;
import br.com.zup.orangetalents.casadocodigo.cliente.model.ClienteRequest;
import br.com.zup.orangetalents.casadocodigo.comum.validations.EstadoSelecionadoValidator;

@RestController
public class CadastraClienteController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EstadoSelecionadoValidator estadoSelecionavelValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(estadoSelecionavelValidator);
	}
	
	@Transactional
	@PostMapping("/cliente")
	public ResponseEntity<ClienteCadastradoDTO> cadastra(@RequestBody @Valid ClienteRequest clienteRequest) {
		Cliente novoCliente = clienteRequest.toModel(entityManager);
		entityManager.persist(novoCliente);
		
		System.out.println("ID DO CLIENTE: " + novoCliente.getId());
		
		return ResponseEntity.ok(ClienteCadastradoDTO.toDTO(novoCliente));
	}
}
