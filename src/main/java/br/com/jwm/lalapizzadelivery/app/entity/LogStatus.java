package br.com.jwm.lalapizzadelivery.app.entity;

import br.com.jwm.lalapizzadelivery.app.entity.hardcode.Status;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOG_STATUS")
public class LogStatus {

	private Pedido pedido;

	private Usuario usuario;

	private Status status;

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
