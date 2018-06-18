package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Estado;
import br.com.jwm.lalapizzadelivery.app.core.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> listar() {
		return estadoRepository.listar();
	}
}
