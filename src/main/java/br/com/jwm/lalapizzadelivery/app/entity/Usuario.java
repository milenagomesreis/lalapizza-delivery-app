package br.com.jwm.lalapizzadelivery.app.entity;

import br.com.jwm.lalapizzadelivery.app.entity.hardcode.Perfil;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario extends Pessoa {

	@Column(name = "EMAIL", length = 100)
	private String email;

	@Column(name = "SENHA", length = 100)
	private String senha;

	@Column(name = "PERFIL")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	public Usuario() {

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
}
