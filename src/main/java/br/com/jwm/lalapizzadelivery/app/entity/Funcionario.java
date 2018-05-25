package br.com.jwm.lalapizzadelivery.app.entity;

import br.com.jwm.lalapizzadelivery.app.entity.hardcode.Cargo;

import javax.persistence.*;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends Usuario {

	@Column(name = "CARGO")
	@Enumerated(EnumType.STRING)
	private Cargo cargo;

	public Funcionario() {

	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
