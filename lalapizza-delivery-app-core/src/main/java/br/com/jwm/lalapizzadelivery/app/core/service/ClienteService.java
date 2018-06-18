package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Cliente;
import br.com.jwm.lalapizzadelivery.app.core.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		cliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));

		return clienteRepository.salvar(cliente);
	}

	public Cliente getById(Long id) throws NoResultException {

		return clienteRepository.getById(id).orElseThrow(()-> new NoResultException("Cliente não encontrada"));
	}

	public List<Cliente> listar() {

		return clienteRepository.listar();
	}
}
