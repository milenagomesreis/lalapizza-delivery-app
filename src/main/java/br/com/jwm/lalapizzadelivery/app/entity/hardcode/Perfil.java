package br.com.jwm.lalapizzadelivery.app.entity.hardcode;

public enum Perfil {

	COZINHA("Cozinha"),
	ATENDIMENTO("Atendimento"),
	ADMINISTRACAO("Administração"),
	CLIENTE("Cliente");

	private String descricao;

	Perfil(String descricao) {

	}

	public String getDescricao() {
		return descricao;
	}

}
