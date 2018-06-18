package br.com.jwm.lalapizzadelivery.app.core.service;

import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.entity.Produto;
import br.com.jwm.lalapizzadelivery.app.core.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto salvar(Produto produto) {

		return produtoRepository.salvar(produto);
	}

	public Produto getById(Long id) throws NoResultException {

		return produtoRepository.getById(id).orElseThrow(()-> new NoResultException("Produto não encontrado"));
	}

	public List<Produto> getXProdutosByCategoriaAleatorio(int quantidade, Categoria categoria) {

		return produtoRepository.getProdutosByCategoria(categoria);
	}

	public List<Produto> listar() {
		return produtoRepository.listar();
	}
}
