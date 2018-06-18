package br.com.jwm.lalapizzadelivery.app.client.to;

import br.com.jwm.lalapizzadelivery.app.core.entity.Estado;
import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;

public class CidadeTO extends BaseTO {

	private Long id;

	private String nome;

	private EstadoTO estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoTO estado) {
		this.estado = estado;
	}
}
