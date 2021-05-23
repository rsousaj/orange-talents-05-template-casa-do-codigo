package br.com.zup.orangetalents.casadocodigo.cliente.model;

public class ClienteCadastradoDTO {

	private Long id;
	
	public Long getId() {
		return this.id;
	}
	
	public ClienteCadastradoDTO(Long id) {
		this.id = id;
	}
	
	public static ClienteCadastradoDTO toDTO(Cliente cliente) {
		return new ClienteCadastradoDTO(cliente.getId());
	}
}
