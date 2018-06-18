package br.com.jwm.lalapizzadelivery.app.client.to.translator;

import br.com.jwm.lalapizzadelivery.app.client.to.CidadeTO;
import br.com.jwm.lalapizzadelivery.app.client.to.EstadoTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Cidade;
import br.com.jwm.lalapizzadelivery.app.core.entity.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class CidadeTOTranslator implements Translator<Cidade,CidadeTO> {

	@Autowired
	private EstadoTOTranslator estadoTOTranslator;

	@Override
	public Cidade toToEntity(CidadeTO to) {

		Cidade cidade = new Cidade();

		cidade.setId(to.getId());
		cidade.setNome(to.getNome());
		cidade.setEstado(estadoTOTranslator.toToEntity(to.getEstado()));

		return cidade;
	}

	@Override
	public CidadeTO entityToTO(Cidade cidade) {
		CidadeTO cidadeTO = new CidadeTO();

		cidadeTO.setId(cidade.getId());
		cidadeTO.setNome(cidade.getNome());
		cidadeTO.setEstado(estadoTOTranslator.entityToTO(cidade.getEstado()));

		return cidadeTO;
	}
}
