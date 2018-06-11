package br.com.jwm.lalapizzadelivery.app.core.entity.constant;

public enum Cargo {

	COZINHA("Cozinha"),
	ATENDIMENTO("Atendimento"),
	ADMINISTRACAO("Administração"),
	CLIENTE("Cliente");

	private String descricao;

	Cargo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
