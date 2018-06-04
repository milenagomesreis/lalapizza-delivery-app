package br.com.jwm.lalapizzadelivery.app.backoffice.controller;

import br.com.jwm.lalapizzadelivery.app.backoffice.service.CategoriaService;
import br.com.jwm.lalapizzadelivery.app.backoffice.to.CategoriaTO;
import br.com.jwm.lalapizzadelivery.app.backoffice.to.translator.CategoriaTOTranslator;
import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.exception.RegistroNaoEncontradoException;
import br.com.jwm.lalapizzadelivery.app.core.repository.CategoriaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/categorias")
public class BackofficeCategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	CategoriaTOTranslator categoriaTOTranslator;

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public String listar(Model model) {

		List<Categoria> categorias = categoriaRepository.listar();

		model.addAttribute("categorias", categorias);

		return "categoria/lista";
	}

	@GetMapping("/novo")
	public String exibirFormulario(CategoriaTO categoriaTO) {

		return "categoria/formulario";
	}

	@PostMapping("/novo")
	public String adicionar(Model model, @Valid CategoriaTO categoriaTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return exibirFormulario(categoriaTO);
		}

		Categoria categoria = categoriaTOTranslator.toToEntity(categoriaTO);

		categoriaService.salvar(categoria);

		return "categoria/lista";
	}

	@GetMapping("/{id}/editar")
	public String exibirFormulario(Model model, CategoriaTO categoriaTO, @PathVariable String id) {

		if(!StringUtils.isNumeric(id)) {
			return "/errors/404";
		}

		try {
			Categoria categoria = categoriaService.getById(Long.valueOf(id));
			categoriaTO = categoriaTOTranslator.entityToTO(categoria);
		} catch (NoResultException e) {
			return "/errors/404";
		}

		return "categoria/formulario";
	}


}
