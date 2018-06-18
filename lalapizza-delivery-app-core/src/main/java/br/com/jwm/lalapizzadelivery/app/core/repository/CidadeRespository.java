package br.com.jwm.lalapizzadelivery.app.core.repository;

import br.com.jwm.lalapizzadelivery.app.core.entity.Cidade;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class CidadeRespository extends GenericRepository<Cidade, Long> {

	public List<Cidade> findByEstadoUF(String uf) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Cidade> criteria = builder.createQuery(Cidade.class);
		Root<Cidade> from = criteria.from(Cidade.class);
		TypedQuery<Cidade> typedQuery = entityManager.createQuery(criteria.select(from).where(builder.equal(from.get("estado").get("uf"), uf)));

		return typedQuery.getResultList();
	}
}
