package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto extends BaseEntity {

	@Id
	@SequenceGenerator(name = "produtoSequence", sequenceName = "PRODUTO_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtoSequence")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", length = 50)
	private String nome;

	@Column(name = "DESCRICAO", length = 150)
	private String descricao;

	@Column(name = "VALOR_UNITARIO")
	private Double valorUnitario;

	@ManyToOne
	@JoinColumn(name = "CATEGORIA_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_PRODUTO_CATEGORIA"))
	private Categoria categoria;

	public Produto() {

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
