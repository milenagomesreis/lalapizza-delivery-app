package br.com.jwm.lalapizzadelivery.app.core.entity;

import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Cargo;

import javax.persistence.*;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario extends Usuario {

	@Column(name = "CARGO")
	@Enumerated(EnumType.STRING)
	private Cargo cargo;

	public Funcionario() {

	}

//	@Id
//	@SequenceGenerator(name = "funcionarioSequence", allocationSize = 1, initialValue = 1, sequenceName = "FUNCIONARIO_SEQUENCE")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionarioSequence")
//	@Column(name = "ID")
//	@Override
//	public Long getId() {
//		return super.getId();
//	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
