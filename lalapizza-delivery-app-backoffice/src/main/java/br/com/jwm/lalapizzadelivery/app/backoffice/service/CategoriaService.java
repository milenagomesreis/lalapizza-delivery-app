package br.com.jwm.lalapizzadelivery.app.backoffice.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.exception.RegistroNaoEncontradoException;
import br.com.jwm.lalapizzadelivery.app.core.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria salvar(Categoria categoria) {
		
		categoria = categoriaRepository.salvar(categoria);

		return categoria;
	}

	public Categoria getById(Long id) throws NoResultException {

		return categoriaRepository.getById(id).orElseThrow(()-> new NoResultException("Categoria não encontrada"));
	}
}
