package br.com.jwm.lalapizzadelivery.app.client.to.translator;

import br.com.jwm.lalapizzadelivery.app.client.to.ClienteTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteTOTranslator implements Translator<Cliente, ClienteTO> {

	@Autowired
	private EnderecoTOTranslator enderecoTOTranslator;

	@Override
	public Cliente toToEntity(ClienteTO to) {

		if(to == null) {
			return null;
		}

		Cliente cliente = new Cliente();

		cliente.setId(to.getId());
		cliente.setNome(to.getNome());
		cliente.setTelefone(to.getTelefone());
		cliente.setEmail(to.getEmail());
		cliente.setSenha(to.getSenha());
		cliente.setPerfil(to.getPerfil());
		cliente.setEndereco(enderecoTOTranslator.toToEntity(to.getEndereco()));


		return cliente;

	}

	@Override
	public ClienteTO entityToTO(Cliente cliente) {

		if(cliente == null) {
			return null;
		}
		
		ClienteTO clienteTO = new ClienteTO();

		clienteTO.setId(cliente.getId());
		clienteTO.setNome(cliente.getNome());
		clienteTO.setTelefone(cliente.getTelefone());
		clienteTO.setEmail(cliente.getEmail());
		clienteTO.setSenha(cliente.getSenha());
		clienteTO.setPerfil(cliente.getPerfil());
		clienteTO.setEndereco(enderecoTOTranslator.entityToTO(cliente.getEndereco()));

		return clienteTO;
	}
}
