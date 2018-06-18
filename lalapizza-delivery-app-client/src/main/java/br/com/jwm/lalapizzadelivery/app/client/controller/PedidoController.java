package br.com.jwm.lalapizzadelivery.app.client.controller;

import br.com.jwm.lalapizzadelivery.app.client.objectsession.Sacola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private Sacola sacola;


}
