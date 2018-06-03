package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "PESSOA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

	@Id
	@SequenceGenerator(name = "pessoaSequence", sequenceName = "PESSOA_SEQUENCE")
	@GeneratedValue(generator = "pessoaSequence", strategy = GenerationType.TABLE)
	private Long id;

	@Column(name = "NOME", length = 100)
	private String nome;

	@Column(name = "TELEFONE")
	private Long telefone;

	public Pessoa() {

	}

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

}
