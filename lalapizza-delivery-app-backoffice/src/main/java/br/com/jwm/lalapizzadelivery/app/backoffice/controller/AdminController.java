package br.com.jwm.lalapizzadelivery.app.backoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/", "/admin"})
public class AdminController {

	@GetMapping
	public String dash() {
		return "home";
	}

}
