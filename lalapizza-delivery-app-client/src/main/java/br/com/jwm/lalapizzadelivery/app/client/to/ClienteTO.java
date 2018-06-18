package br.com.jwm.lalapizzadelivery.app.client.to;

import br.com.jwm.lalapizzadelivery.app.core.entity.Endereco;
import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Cargo;
import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Perfil;
import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ClienteTO extends BaseTO {


	private Long id;

	@NotBlank(message = "Nome não pode estar em branco")
	private String nome;

	@NotBlank(message = "Telefone não pode estar em branco")
	@Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$",
	message = "Telefone informado não corresponde ao padrão (99) 9999-9999")
	private String telefone;

	@Email
	@NotBlank(message = "Email não pode estar em branco")
	private String email;

	@NotBlank(message = "Senha não pode estar em branco")
	private String senha;

	private Perfil perfil;

	private EnderecoTO endereco;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public EnderecoTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoTO endereco) {
		this.endereco = endereco;
	}
}
