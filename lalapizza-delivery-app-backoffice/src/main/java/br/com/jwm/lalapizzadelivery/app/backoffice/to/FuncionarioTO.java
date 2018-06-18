package br.com.jwm.lalapizzadelivery.app.backoffice.to;

import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Cargo;
import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Perfil;
import br.com.jwm.lalapizzadelivery.app.core.to.BaseTO;

import javax.validation.constraints.*;

public class FuncionarioTO extends BaseTO {


	private Long id;

	@NotBlank(message = "Nome não pode estar em branco")
	private String nome;

	@NotBlank(message = "Telefone não pode estar em branco")
	@Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$",
	message = "Telefone informado não corresponde ao padrão (99)s 9999-9999")
	private String telefone;

	@Email
	@NotBlank(message = "Email não pode estar em branco")
	private String email;

	@NotBlank(message = "Senha não pode estar em branco")
	private String senha;

	@NotNull(message = "Um pefil deve ser escolhido")
	private Perfil perfil;

	@NotNull(message = "Um cargo deve ser escolhido")
	private Cargo cargo;

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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
