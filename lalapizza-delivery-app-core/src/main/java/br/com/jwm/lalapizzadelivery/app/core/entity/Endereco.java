package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "ENDERECO")
public class Endereco extends BaseEntity {

	@Id
	@SequenceGenerator(name = "enderecoSequence", allocationSize = 1, initialValue = 1, sequenceName = "ENDERECO_SEQUENCE")
	@GeneratedValue(generator = "enderecoSequence", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "LOGRADOURO", length = 100)
	private String logradouro;

	@Column(name = "NUMERO")
	private Integer numero;

	@Column(name = "COMPLEMENTO", length = 50)
	private String complemento;

	@Column(name = "REFERENCIA", length = 50)
	private String referencia;

	@Column(name = "CEP")
	private String cep;

	@Column(name = "BAIRRO", length = 50)
	private String bairro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIDADE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ENDERECO_CIDADE"))
	private Cidade cidade;

	@OneToOne
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ENDERECO_CLIENTE"))
	private Cliente cliente;

	public Endereco() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
