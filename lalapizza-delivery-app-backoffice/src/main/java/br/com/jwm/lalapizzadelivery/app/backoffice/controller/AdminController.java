package br.com.jwm.lalapizzadelivery.app.backoffice.controller;

import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/", "/admin"})
public class AdminController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public String dash(Model model) {

		return "home";
	}

}
