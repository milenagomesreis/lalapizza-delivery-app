package br.com.jwm.lalapizzadelivery.app.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@SequenceGenerator(name="pedidoSequence", sequenceName="PEDIDO_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="pedidoSequence")
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_PEDIDO_CLIENTE"))
	private Cliente cliente;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<ProdutoPedido> produtoPedidoList;

	@Column(name = "VALOR_TOTAL")
	private Double valorTotal;

	@Column(name = "DATA")
	private LocalDateTime data;

	@ManyToOne
	@JoinColumn(name = "MOTOBOY_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_PEDIDO_MOTOBOY"))
	private Motoboy motoboy;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<LogStatus> logStatus;

	public Pedido() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoPedido> getProdutoPedidoList() {
		return produtoPedidoList;
	}

	public void setProdutoPedidoList(List<ProdutoPedido> produtoPedidoList) {
		this.produtoPedidoList = produtoPedidoList;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Motoboy getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Motoboy motoboy) {
		this.motoboy = motoboy;
	}

	public List<LogStatus> getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(List<LogStatus> logStatus) {
		this.logStatus = logStatus;
	}
}
