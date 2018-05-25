package br.com.jwm.lalapizzadelivery.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MOTOBOY")
public class Motoboy extends Pessoa {

	@Column(name = "TELEFONE")
	private Long telefone;

	public Motoboy() {

	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
}
