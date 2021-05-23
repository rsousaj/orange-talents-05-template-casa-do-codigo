package br.com.zup.orangetalents.casadocodigo.cliente.model;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orangetalents.casadocodigo.comum.validations.CPForCNPJ;
import br.com.zup.orangetalents.casadocodigo.comum.validations.ExistsEntity;
import br.com.zup.orangetalents.casadocodigo.localidade.model.Estado;
import br.com.zup.orangetalents.casadocodigo.localidade.model.Pais;

public class ClienteRequest {

	private @Email String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @CPForCNPJ String documento;
	private @NotBlank String endereco;
	private @NotBlank String complemento;
	private @NotBlank String cidade;
	
	@ExistsEntity(referenceEntity = Pais.class, fieldName = "id")
	private @NotNull Integer paisId;
	private Long estadoId;
	private @NotBlank String telefone;
	private @NotBlank String cep;
	
	public ClienteRequest(@Email String email, @NotBlank String nome, @NotBlank String sobrenome, String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Integer paisId,
			Long estadoId, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Integer getPaisId() {
		return paisId;
	}
	public Long getEstadoId() {
		return estadoId;
	}
	
	public Cliente toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, paisId);
		Estado estado = estadoId != null ? entityManager.find(Estado.class, estadoId) : null;
		
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
	}
}
