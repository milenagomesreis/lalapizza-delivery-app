package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIA")
public class Categoria extends BaseEntity {

	@Id
	@SequenceGenerator(name = "categoriaSequence", sequenceName = "CATEGORIA_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoriaSequence")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", length = 20, nullable = false)
	private String nome;

	public Categoria() {

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
