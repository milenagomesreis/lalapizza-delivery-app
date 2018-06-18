package br.com.jwm.lalapizzadelivery.app.backoffice.to;

import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MotoboyTO extends BaseTO {

	private Long id;

	@NotBlank(message = "Nome não pode estar em branco")
	private String nome;

	@NotBlank(message = "Telefone não pode estar em branco")
	@Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$",
			message = "Telefone informado não corresponde ao padrão (99) 9999-9999")
	private String telefone;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
