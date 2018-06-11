package br.com.jwm.lalapizzadelivery.app.backoffice.controller;

import br.com.jwm.lalapizzadelivery.app.backoffice.to.FuncionarioTO;
import br.com.jwm.lalapizzadelivery.app.backoffice.to.translator.FuncionarioTOTranslator;
import br.com.jwm.lalapizzadelivery.app.core.entity.Funcionario;
import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Cargo;
import br.com.jwm.lalapizzadelivery.app.core.entity.constant.Perfil;
import br.com.jwm.lalapizzadelivery.app.core.service.FuncionarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.NoResultException;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/funcionarios")
public class BackofficeFuncionarioController {

	@Autowired
	FuncionarioTOTranslator funcionarioTOTranslator;

	@Autowired
	FuncionarioService funcionarioService;

	@GetMapping
	public String listar(Model model) {

		model.addAttribute("funcionarios", funcionarioService.listar());

		return "funcionario/lista";
	}

	@GetMapping("/novo")
	public String exibirFormulario(Model model, FuncionarioTO funcionarioTO) {

		model.addAttribute("perfis", Perfil.getFuncionarioPerfis());
		model.addAttribute("cargos", Cargo.values());
		return "funcionario/formulario";
	}

	@PostMapping("/novo")
	public String adicionar(Model model, @Valid FuncionarioTO funcionarioTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return exibirFormulario(model, funcionarioTO);
		}

		funcionarioService.salvar(funcionarioTOTranslator.toToEntity(funcionarioTO));

		return "redirect:/admin/funcionarios";
	}

	@GetMapping("/{id}/editar")
	public String exibirFormulario(Model model, @PathVariable String id) {

		if(!StringUtils.isNumeric(id)) {
			return "/errors/404";
		}

		try {
			Funcionario funcionario = funcionarioService.getById(Long.valueOf(id));
			model.addAttribute("funcionarioTO", funcionarioTOTranslator.entityToTO(funcionario));
		} catch (NoResultException e) {
			return "/errors/404";
		}

		return "funcionario/formulario";
	}
}
