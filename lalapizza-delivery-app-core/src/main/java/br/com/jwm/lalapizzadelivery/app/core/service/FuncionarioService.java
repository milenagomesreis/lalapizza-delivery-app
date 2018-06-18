package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Funcionario;
import br.com.jwm.lalapizzadelivery.app.core.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario salvar(Funcionario funcionario) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		funcionario.setSenha(bCryptPasswordEncoder.encode(funcionario.getSenha()));

		return funcionarioRepository.salvar(funcionario);
	}

	public Funcionario getById(Long id) throws NoResultException {

		return funcionarioRepository.getById(id).orElseThrow(()-> new NoResultException("Funcionario não encontrada"));
	}

	public List<Funcionario> listar() {

		return funcionarioRepository.listar();
	}
}
