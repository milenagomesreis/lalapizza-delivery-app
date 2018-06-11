package br.com.jwm.lalapizzadelivery.app.backoffice.controller;

import br.com.jwm.lalapizzadelivery.app.backoffice.to.MotoboyTO;
import br.com.jwm.lalapizzadelivery.app.backoffice.to.translator.MotoboyTOTranslator;
import br.com.jwm.lalapizzadelivery.app.core.entity.Motoboy;
import br.com.jwm.lalapizzadelivery.app.core.service.MotoboyService;
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
import java.util.List;

@Controller
@RequestMapping("/admin/motoboys")
public class BackofficeMotoboyController {

	@Autowired
	MotoboyTOTranslator motoboyTOTranslator;

	@Autowired
	MotoboyService motoboyService;

	@GetMapping
	public String listar(Model model) {

		List<Motoboy> motoboys = motoboyService.listar();

		model.addAttribute("motoboys", motoboys);

		return "motoboy/lista";
	}

	@GetMapping("/novo")
	public String exibirFormulario(MotoboyTO motoboyTO) {

		return "motoboy/formulario";
	}

	@PostMapping("/novo")
	public String adicionar(Model model, @Valid MotoboyTO motoboyTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return exibirFormulario(motoboyTO);
		}

		Motoboy motoboy = motoboyTOTranslator.toToEntity(motoboyTO);

		motoboyService.salvar(motoboy);

		return "redirect:/admin/motoboys";
	}

	@GetMapping("/{id}/editar")
	public String exibirFormulario(Model model, @PathVariable String id) {

		if(!StringUtils.isNumeric(id)) {
			return "/errors/404";
		}

		try {
			Motoboy motoboy = motoboyService.getById(Long.valueOf(id));
			MotoboyTO motoboyTO = motoboyTOTranslator.entityToTO(motoboy);

			model.addAttribute("motoboyTO", motoboyTO);
		} catch (NoResultException e) {
			return "/errors/404";
		}

		return "motoboy/formulario";
	}
}
