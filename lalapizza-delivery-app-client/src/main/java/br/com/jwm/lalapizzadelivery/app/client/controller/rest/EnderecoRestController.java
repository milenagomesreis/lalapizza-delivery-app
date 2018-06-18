package br.com.jwm.lalapizzadelivery.app.client.controller.rest;

import br.com.jwm.lalapizzadelivery.app.client.to.EnderecoTO;
import br.com.jwm.lalapizzadelivery.app.client.to.translator.EnderecoTOTranslator;
import br.com.jwm.lalapizzadelivery.app.core.entity.Endereco;
import br.com.jwm.lalapizzadelivery.app.core.service.EnderecoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/enderecos")
public class EnderecoRestController {

	private final String cepRegex = "^[0-9]{5}\\-[0-9]{3}$";

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EnderecoTOTranslator enderecoTOTranslator;

	@PostMapping ("/cep/busca")
	public ResponseEntity<?> buscaCEP(@RequestBody String cep) {
		if(!Pattern.matches(cepRegex, cep)) {
			return ResponseEntity.badRequest().body("CEP inválido");
		}

		try {

			Endereco endereco = enderecoService.getByCEP(cep);
			EnderecoTO enderecoTO = enderecoTOTranslator.entityToTO(endereco);

			return ResponseEntity.ok(enderecoTO);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
