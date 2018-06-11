package br.com.jwm.lalapizzadelivery.app.backoffice.to.translator;

import br.com.jwm.lalapizzadelivery.app.backoffice.to.FuncionarioTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioTOTranslator implements Translator<Funcionario, FuncionarioTO>{
	@Override
	public Funcionario toToEntity(FuncionarioTO to) {
		Funcionario funcionario = new Funcionario();

		funcionario.setId(to.getId());
		funcionario.setNome(to.getNome());
		funcionario.setTelefone(to.getTelefone());
		funcionario.setEmail(to.getEmail());
		funcionario.setSenha(to.getSenha());
		funcionario.setPerfil(to.getPerfil());
		funcionario.setCargo(to.getCargo());
		
		return funcionario;

	}

	@Override
	public FuncionarioTO entityToTO(Funcionario funcionario) {
		
		FuncionarioTO funcionarioTO = new FuncionarioTO();

		funcionarioTO.setId(funcionario.getId());
		funcionarioTO.setNome(funcionario.getNome());
		funcionarioTO.setTelefone(funcionario.getTelefone());
		funcionarioTO.setEmail(funcionario.getEmail());
		funcionarioTO.setSenha(funcionario.getSenha());
		funcionarioTO.setPerfil(funcionario.getPerfil());
		funcionarioTO.setCargo(funcionario.getCargo());
		
		return funcionarioTO;
	}
}
