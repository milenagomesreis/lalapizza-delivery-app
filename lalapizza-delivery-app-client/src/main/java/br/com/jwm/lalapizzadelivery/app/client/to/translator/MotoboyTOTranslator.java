package br.com.jwm.lalapizzadelivery.app.client.to.translator;

import br.com.jwm.lalapizzadelivery.app.client.to.MotoboyTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Motoboy;
import org.springframework.stereotype.Component;

@Component
public class MotoboyTOTranslator implements Translator<Motoboy, MotoboyTO> {

	@Override
	public Motoboy toToEntity(MotoboyTO to) {
		Motoboy motoboy = new Motoboy();

		motoboy.setId(to.getId());
		motoboy.setNome(to.getNome());
		motoboy.setTelefone(to.getTelefone());

		return motoboy;
	}

	@Override
	public MotoboyTO entityToTO(Motoboy motoboy) {

		MotoboyTO motoboyTO = new MotoboyTO();

		motoboyTO.setId(motoboy.getId());
		motoboyTO.setNome(motoboy.getNome());
		motoboyTO.setTelefone(motoboy.getTelefone());

		return motoboyTO;
	}
}
