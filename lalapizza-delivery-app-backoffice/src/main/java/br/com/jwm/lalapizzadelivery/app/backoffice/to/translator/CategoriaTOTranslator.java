package br.com.jwm.lalapizzadelivery.app.backoffice.to.translator;

import br.com.jwm.lalapizzadelivery.app.backoffice.to.CategoriaTO;
import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CategoriaTOTranslator implements Translator<Categoria, CategoriaTO> {


	@Override
	public Categoria toToEntity(@NonNull CategoriaTO categoriaTO) {

		Categoria categoria = new Categoria();

		categoria.setId(categoriaTO.getId());
		categoria.setNome(categoriaTO.getNome());

		return categoria;
	}

	@Override
	public CategoriaTO entityToTO(Categoria categoria) {

		CategoriaTO categoriaTO = new CategoriaTO();

		categoriaTO.setNome(categoria.getNome());
		categoriaTO.setId(categoria.getId());

		return categoriaTO;
	}
}
