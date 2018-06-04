package br.com.jwm.lalapizzadelivery.app.core.repository;

import br.com.jwm.lalapizzadelivery.app.core.entity.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public abstract class GenericRepository<T extends BaseEntity, ID extends Object> {

	@PersistenceContext
	private EntityManager entityManager;

	private String getClassName() {
		return getPersistenceClass().getSimpleName();
	}

	@Transactional
	public T salvar(T t) {
		t = entityManager.merge(t);
		return t;
	}

	public List<T> listar() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteria = builder.createQuery((Class<T>) getPersistenceClass());
		criteria.from(getPersistenceClass());

		return entityManager.createQuery(criteria).getResultList();

	}

	public Optional<T> getById(ID id) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteria = builder.createQuery((Class<T>) getPersistenceClass());
		Root<T> from = criteria.from((Class<T>) getPersistenceClass());
		TypedQuery<T> typedQuery = entityManager.createQuery(criteria.select(from).where(builder.equal(from.get("id"), id)));

		return Optional.ofNullable(typedQuery.getSingleResult());
	}

	private Class<?> getPersistenceClass() {
		Type type = null;
		Class<?> clazz = getClass();

		while (clazz != null && !(type instanceof ParameterizedType)) {
			type = clazz != null ? clazz.getGenericSuperclass() : null;
			clazz = clazz.getSuperclass();
		}

		return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
	}
}
