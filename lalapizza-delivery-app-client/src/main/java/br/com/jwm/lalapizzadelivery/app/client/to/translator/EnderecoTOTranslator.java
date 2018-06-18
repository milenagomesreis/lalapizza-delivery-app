package br.com.jwm.lalapizzadelivery.app.client.to.translator;

import br.com.jwm.lalapizzadelivery.app.client.to.EnderecoTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoTOTranslator implements Translator<Endereco, EnderecoTO> {

	@Autowired
	private CidadeTOTranslator cidadeTOTranslator;

	@Autowired
	private ClienteTOTranslator clienteTOTranslator;

	@Override
	public Endereco toToEntity(EnderecoTO to) {

		if(to == null) {
			return null;
		}

		Endereco endereco = new Endereco();

		endereco.setLogradouro(to.getLogradouro());
		endereco.setBairro(to.getBairro());
		endereco.setNumero(to.getNumero());
		endereco.setCep(to.getCep());
		endereco.setComplemento(to.getComplemento());
		endereco.setReferencia(to.getReferencia());
		endereco.setCidade(cidadeTOTranslator.toToEntity(to.getCidade()));
		endereco.setCliente(clienteTOTranslator.toToEntity(to.getCliente()));

		return endereco;
	}

	@Override
	public EnderecoTO entityToTO(Endereco endereco) {

		if(endereco == null) {
			return null;
		}

		EnderecoTO enderecoTO = new EnderecoTO();

		enderecoTO.setLogradouro(endereco.getLogradouro());
		enderecoTO.setBairro(endereco.getBairro());
		enderecoTO.setNumero(endereco.getNumero());
		enderecoTO.setCep(endereco.getCep());
		enderecoTO.setComplemento(endereco.getComplemento());
		enderecoTO.setReferencia(endereco.getReferencia());
		enderecoTO.setCidade(cidadeTOTranslator.entityToTO(endereco.getCidade()));
		enderecoTO.setCliente(clienteTOTranslator.entityToTO(endereco.getCliente()));

		return enderecoTO;
	}
}
