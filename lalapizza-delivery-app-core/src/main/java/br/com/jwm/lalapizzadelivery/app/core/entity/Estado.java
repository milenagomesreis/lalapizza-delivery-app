package br.com.jwm.lalapizzadelivery.app.core.entity;


import javax.persistence.*;

@Entity
@Table(name = "ESTADO")
public class Estado {

	@Id
	@SequenceGenerator(name = "estadoSequence", sequenceName = "ESTADO_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "estadoSequence")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", length = 50)
	private String nome;

	@Column(name = "UF", length = 2)
	private String uf;

	public Estado() {

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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}

