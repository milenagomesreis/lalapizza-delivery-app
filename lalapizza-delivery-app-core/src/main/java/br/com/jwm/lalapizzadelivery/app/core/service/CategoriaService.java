package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria salvar(Categoria categoria) {
		
		return categoriaRepository.salvar(categoria);
	}

	public Categoria getById(Long id) throws NoResultException {

		return categoriaRepository.getById(id).orElseThrow(()-> new NoResultException("Categoria não encontrada"));
	}

	public List<Categoria> listar() {

		return categoriaRepository.listar();
	}
}
