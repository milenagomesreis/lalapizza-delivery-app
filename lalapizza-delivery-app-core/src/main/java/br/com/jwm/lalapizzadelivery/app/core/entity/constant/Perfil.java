package br.com.jwm.lalapizzadelivery.app.core.entity.constant;

import java.util.Arrays;
import java.util.List;

public enum Perfil {

	COZINHA("Cozinha"),
	ATENDIMENTO("Atendimento"),
	ADMINISTRACAO("Administração"),
	CLIENTE("Cliente");

	private String descricao;

	Perfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static List<Perfil> getFuncionarioPerfis() {
		return Arrays.asList(COZINHA, ADMINISTRACAO, ATENDIMENTO);
	}

}
