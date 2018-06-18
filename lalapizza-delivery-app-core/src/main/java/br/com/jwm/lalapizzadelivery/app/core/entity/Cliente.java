package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Usuario {

	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Endereco endereco;

	public Cliente() {

	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
