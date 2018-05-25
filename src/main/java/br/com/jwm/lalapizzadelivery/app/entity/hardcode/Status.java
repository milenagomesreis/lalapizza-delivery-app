package br.com.jwm.lalapizzadelivery.app.entity.hardcode;

public enum Status {

	ENTREGUE("Entregue"),
	A_CAMINHO("A Caminho"),
	PREPARANDO("Preparando"),
	AGUARDANDO_SAIDA("Aguardando saída"),
	NEGADO("Negado"),
	RECEBIDO("Recebido"),
	NOVO("Novo");

	private String nome;

	Status(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
