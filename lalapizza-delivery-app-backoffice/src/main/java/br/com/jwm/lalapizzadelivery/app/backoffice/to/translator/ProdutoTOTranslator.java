package br.com.jwm.lalapizzadelivery.app.backoffice.to.translator;

import br.com.jwm.lalapizzadelivery.app.backoffice.to.ProdutoTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoTOTranslator implements Translator<Produto,ProdutoTO> {

	@Override
	public Produto toToEntity(ProdutoTO to) {
		Produto produto = new Produto();

		produto.setId(to.getId());
		produto.setDescricao(to.getDescricao());
		produto.setNome(to.getNome());
		produto.setValorUnitario(to.getValorUnitario());
		produto.setCategoria(to.getCategoria());
		return produto;
	}

	@Override
	public ProdutoTO entityToTO(Produto produto) {
		ProdutoTO produtoTO = new ProdutoTO();

		produtoTO.setId(produto.getId());
		produtoTO.setNome(produto.getNome());
		produtoTO.setDescricao(produto.getDescricao());
		produtoTO.setCategoria(produto.getCategoria());
		produtoTO.setValorUnitario(produto.getValorUnitario());

		return produtoTO;
	}
}
