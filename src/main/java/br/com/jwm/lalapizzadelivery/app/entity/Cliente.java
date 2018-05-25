package br.com.jwm.lalapizzadelivery.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Usuario {

	@Column(name = "CPF", length = 11)
	private String cpf;

	@Column(name = "ENDERECO_ID")
	@OneToOne(mappedBy = "endereco")
	private Endereco endereco;

	@Column(name = "TELEFONE")
	private Long telefone;


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

}
