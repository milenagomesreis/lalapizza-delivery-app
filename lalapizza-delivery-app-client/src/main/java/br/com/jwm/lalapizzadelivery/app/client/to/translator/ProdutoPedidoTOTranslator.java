package br.com.jwm.lalapizzadelivery.app.client.to.translator;

import br.com.jwm.lalapizzadelivery.app.client.to.ProdutoPedidoTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.ProdutoPedido;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPedidoTOTranslator implements Translator<ProdutoPedido, ProdutoPedidoTO> {

	@Override
	public ProdutoPedido toToEntity(ProdutoPedidoTO to) {
		ProdutoPedido produtoPedido = new ProdutoPedido();

		return produtoPedido;
	}

	@Override
	public ProdutoPedidoTO entityToTO(ProdutoPedido produtoPedido) {
		return null;
	}
}
