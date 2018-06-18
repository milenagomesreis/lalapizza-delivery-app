package br.com.jwm.lalapizzadelivery.app.client.to.translator;

import br.com.jwm.lalapizzadelivery.app.client.to.EstadoTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Estado;
import org.springframework.stereotype.Component;

@Component
public class EstadoTOTranslator implements Translator<Estado, EstadoTO> {

	@Override
	public Estado toToEntity(EstadoTO to) {

		Estado estado = new Estado();

		estado.setId(to.getId());
		estado.setNome(to.getNome());
		estado.setUf(to.getUf());

		return estado;
	}

	@Override
	public EstadoTO entityToTO(Estado estado) {

		EstadoTO estadoTO = new EstadoTO();

		estadoTO.setId(estado.getId());
		estadoTO.setNome(estado.getNome());
		estadoTO.setUf(estado.getUf());

		return estadoTO;

	}
}
