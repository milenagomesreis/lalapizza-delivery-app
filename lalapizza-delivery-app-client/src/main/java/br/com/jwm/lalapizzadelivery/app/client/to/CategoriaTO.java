package br.com.jwm.lalapizzadelivery.app.client.to;

import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class CategoriaTO extends BaseTO {

	private Long id;

	@NotBlank
	@Length(max = 20)
	private String nome;

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
