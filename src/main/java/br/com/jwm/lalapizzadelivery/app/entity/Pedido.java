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

	private Cliente cliente;

	private List<ProdutoPedido> produtoPedidoList;

	private Double valorTotal;

	private LocalDateTime data;

	private Motoboy motoboy;

	private List<LogStatus> logStatus;


}
