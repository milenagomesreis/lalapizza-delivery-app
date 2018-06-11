package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Usuario {

	@Column(name = "CPF", length = 11)
	private String cpf;

	@OneToOne(mappedBy = "cliente")
	private Endereco endereco;

	public Cliente() {

	}

//	@Id
//	@SequenceGenerator(name = "clienteSequence", allocationSize = 1, initialValue = 1, sequenceName = "CLIENTE_SEQUENCE")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clienteSequence")
//	@Column(name = "ID")
//	@Override
//	public Long getId() {
//		return super.getId();
//	}

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

}
