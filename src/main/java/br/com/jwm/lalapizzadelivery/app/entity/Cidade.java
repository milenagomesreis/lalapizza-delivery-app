package br.com.jwm.lalapizzadelivery.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "CIDADE")
public class Cidade {

	@Id
	@SequenceGenerator(name="cidadeSequence", sequenceName="CIDADE_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="cidadeSequence")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@JoinColumn(name = "ESTADO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_CIDADE_ESTADO"))
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Estado estado;



}
