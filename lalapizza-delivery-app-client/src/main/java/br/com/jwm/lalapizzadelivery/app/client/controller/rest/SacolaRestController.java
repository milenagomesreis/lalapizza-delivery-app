package br.com.jwm.lalapizzadelivery.app.client.controller.rest;

import br.com.jwm.lalapizzadelivery.app.client.objectsession.Sacola;
import br.com.jwm.lalapizzadelivery.app.client.to.ProdutoPedidoTO;
import br.com.jwm.lalapizzadelivery.app.client.to.translator.ProdutoPedidoTOTranslator;
import br.com.jwm.lalapizzadelivery.app.core.entity.ProdutoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sacola")
public class SacolaRestController {

	@Autowired
	private Sacola sacola;

	@Autowired
	private ProdutoPedidoTOTranslator produtoPedidoTOTranslator;

	@PostMapping("/item")
	public ResponseEntity<?> novoItem(@Valid @RequestBody ProdutoPedidoTO produtoPedidoTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}

		ProdutoPedido produtoPedido = produtoPedidoTOTranslator.toToEntity(produtoPedidoTO);

		sacola.addItem(produtoPedido);

		return ResponseEntity.ok(sacola);
	}
}
