package br.com.jwm.lalapizzadelivery.app.core.repository;

import br.com.jwm.lalapizzadelivery.app.core.entity.Categoria;
import br.com.jwm.lalapizzadelivery.app.core.entity.Produto;
import org.omg.DynamicAny._DynAnyStub;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository extends GenericRepository<Produto, Long> {

	public List<Produto> getProdutosByCategoria(Categoria categoria) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> from = criteria.from(Produto.class);
		TypedQuery<Produto> typedQuery = entityManager.createQuery(
				criteria.select(from).where(builder.equal(from.get("categoria"), categoria))
		);

		return typedQuery.getResultList();
	}
}
