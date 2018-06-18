package br.com.jwm.lalapizzadelivery.app.client.objectsession;

import br.com.jwm.lalapizzadelivery.app.core.entity.ProdutoPedido;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Sacola {

	List<ProdutoPedido> itens = new ArrayList<ProdutoPedido>();

	public List<ProdutoPedido> getItens() {
		return itens;
	}

	public void setItens(List<ProdutoPedido> itens) {
		this.itens = itens;
	}

	public void addItem(ProdutoPedido item) {
		itens.add(item);
	}
}
