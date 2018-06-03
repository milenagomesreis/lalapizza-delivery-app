package br.com.jwm.lalapizzadelivery.app.core.entity;

import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOG_STATUS")
public class LogStatus {

	@Id
	@SequenceGenerator(name = "logStatusSequence", sequenceName = "LOG_STATUS_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "logStatusSequence")
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_LOG_STATUS_PEDIDO"))
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_LOG_STATUS_USUARIO"))
	private Usuario usuario;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;

	@Column(name = "DATA")
	private LocalDateTime data;

	public LogStatus() {

	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
