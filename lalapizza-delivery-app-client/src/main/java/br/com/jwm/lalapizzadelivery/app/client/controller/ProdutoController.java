package br.com.jwm.lalapizzadelivery.app.client.controller;

import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.entity.Produto;
import br.com.jwm.lalapizzadelivery.app.core.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cardapio")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public String listar(Model model) {

		List<Produto> produtos = produtoService.listar();

		Map<Categoria, List<Produto>> produtorPorCategoria = produtos
				.stream()
				.collect(Collectors.groupingBy(Produto::getCategoria));

		model.addAttribute("produtos", produtorPorCategoria);

		return "produto/lista";
	}

}
