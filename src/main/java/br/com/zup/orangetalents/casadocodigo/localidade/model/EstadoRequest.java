package br.com.zup.orangetalents.casadocodigo.localidade.model;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zup.orangetalents.casadocodigo.comum.validations.EntidadeExistente;
import br.com.zup.orangetalents.casadocodigo.comum.validations.EstadoNaoExiste;

@EstadoNaoExiste
public class EstadoRequest {

	@NotBlank
	private String nome;
	
	@NotNull
	@EntidadeExistente(referenceEntity = Pais.class, fieldName = "id")
	private Integer paisId;

	public String getNome() {
		return nome;
	}

	public Integer getPaisId() {
		return paisId;
	}

	public Estado toModel(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, paisId);
		
		Assert.state(pais != null, "O país informado não existe.");
		
		return new Estado(nome, pais);
	}
}
