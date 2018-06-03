package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class PKProdutoPedido implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUTO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUTO_PRODUTO"))
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PEDIDO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUTO_PEDIDO"))
	private Pedido pedido;

	public PKProdutoPedido() {

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
