package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Motoboy;
import br.com.jwm.lalapizzadelivery.app.core.repository.MotoboyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class MotoboyService {

	@Autowired
	private MotoboyRepository motoboyRepository;

	public Motoboy salvar(Motoboy motoboy) {

		return motoboyRepository.salvar(motoboy);
	}

	public Motoboy getById(Long id) throws NoResultException {

		return motoboyRepository.getById(id).orElseThrow(()-> new NoResultException("Motoboy não encontrada"));
	}

	public List<Motoboy> listar() {

		return motoboyRepository.listar();
	}
}
