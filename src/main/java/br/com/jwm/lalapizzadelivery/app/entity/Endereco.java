package br.com.jwm.lalapizzadelivery.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(generator = "enderecoSequence", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "LOGRADOURO", length = 100)
	private String logradouro;

	@Column(name = "NUMERO")
	private Integer numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "REFERENCIA")
	private String referencia;

	@Column(name = "CEP")
	private Integer cep;

	@Column(name = "BAIRRO")
	private String bairro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIDADE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ENDERECO_CIDADE"))
	private Cidade cidade;

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

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
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
	
}
