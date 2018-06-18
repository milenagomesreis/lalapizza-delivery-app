package br.com.jwm.lalapizzadelivery.app.client.to;

import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;

public class EstadoTO extends BaseTO {

	private Long id;
	private String nome;
	private String uf;

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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
