package br.com.jwm.lalapizzadelivery.app.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO_PEDIDO")
@IdClass(PKProdutoPedido.class)
public class ProdutoPedido {

	@Id
	private Produto produto;

	@Id
	private Pedido pedido;

	@Column(name = "QUANTIDADE")
	private Integer quantidade;

	@Column(name = "VALOR_UNITARIO")
	private Double valorUnitario;

	@Column(name = "VALOR_TOTAL")
	private Double valorTotal;

	public ProdutoPedido() {

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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
