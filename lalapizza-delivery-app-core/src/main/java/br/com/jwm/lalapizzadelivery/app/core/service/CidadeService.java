package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Cidade;
import br.com.jwm.lalapizzadelivery.app.core.repository.CidadeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

	@Autowired
	private CidadeRespository cidadeRespository;

	public List<Cidade> findByEstadoUF(String UF) {

		return cidadeRespository.findByEstadoUF(UF);
	}
}
