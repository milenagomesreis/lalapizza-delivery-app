package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Produto;
import br.com.jwm.lalapizzadelivery.app.core.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	public Produto salvar(Produto produto) {

		return produtoRepository.salvar(produto);
	}

	public Produto getById(Long id) throws NoResultException {

		return produtoRepository.getById(id).orElseThrow(()-> new NoResultException("Produto não encontrado"));
	}
}
