package br.com.jwm.lalapizzadelivery.app.client.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ClientController {

	@GetMapping
	public String home() {
		return "home";
	}
}
