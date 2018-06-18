package br.com.jwm.lalapizzadelivery.app.client.controller;

import br.com.jwm.lalapizzadelivery.app.client.to.ClienteTO;
import br.com.jwm.lalapizzadelivery.app.client.to.translator.ClienteTOTranslator;
import br.com.jwm.lalapizzadelivery.app.core.entity.Cliente;
import br.com.jwm.lalapizzadelivery.app.core.service.ClienteService;
import br.com.jwm.lalapizzadelivery.app.core.service.EstadoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.NoResultException;
import javax.validation.Valid;

@Controller
public class ClienteController {

	@Autowired
	private ClienteTOTranslator clienteTOTranslator;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EstadoService estadoService;

	@GetMapping("/registre-se")
	public String exibirFormulario(Model model, ClienteTO clienteTO) {

		model.addAttribute("estados", estadoService.listar());
		return "cliente/formulario";
	}

	@PostMapping("/registre-se")
	public String adicionar(Model model, @Valid ClienteTO clienteTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return exibirFormulario(model, clienteTO);
		}

		Cliente cliente = clienteTOTranslator.toToEntity(clienteTO);
		cliente.getEndereco().setCliente(cliente);

		clienteService.salvar(cliente);

		return "redirect:/admin/clientes";
	}

	@GetMapping("/clientes/{id}/editar")
	public String exibirFormulario(Model model, @PathVariable String id) {

		if(!StringUtils.isNumeric(id)) {
			return "/errors/404";
		}

		try {
			Cliente cliente = clienteService.getById(Long.valueOf(id));
			model.addAttribute("clienteTO", clienteTOTranslator.entityToTO(cliente));
		} catch (NoResultException e) {
			return "/errors/404";
		}

		return "cliente/formulario";
	}

	@GetMapping("/clientes/{id}")
	public String detalhe(Model model, @PathVariable String id) {

		if(!StringUtils.isNumeric(id)) {
			return "/errors/404";
		}

		try {
			Cliente cliente = clienteService.getById(Long.valueOf(id));
			model.addAttribute("clienteTO", clienteTOTranslator.entityToTO(cliente));
		} catch (NoResultException e) {
			return "/errors/404";
		}

		return "cliente/minha-conta";
	}
}
