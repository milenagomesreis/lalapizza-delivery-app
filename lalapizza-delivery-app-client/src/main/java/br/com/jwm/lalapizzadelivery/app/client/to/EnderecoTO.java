package br.com.jwm.lalapizzadelivery.app.client.to;

import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Valid
public class EnderecoTO extends BaseTO {

	private String logradouro;

	private Integer numero;

	private String complemento;

	private String referencia;

	@Pattern(regexp = "^[0-9]{5}\\-[0-9]{3}$",
			message = "Telefone informado não corresponde ao padrão (99) 9999-9999")
	private String cep;

	private String bairro;

	private CidadeTO cidade;

	private ClienteTO cliente;

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

	public CidadeTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeTO cidade) {
		this.cidade = cidade;
	}

	public ClienteTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteTO cliente) {
		this.cliente = cliente;
	}
}
