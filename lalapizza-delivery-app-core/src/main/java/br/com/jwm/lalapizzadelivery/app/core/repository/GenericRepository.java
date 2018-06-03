package br.com.jwm.lalapizzadelivery.app.core.repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericRepository<T extends Object, ID extends Object> {

	@PersistenceContext
	private EntityManager entityManager;

	public GenericRepository() {
	}

	private String getClassName() {
		return getPersistenceClass().getSimpleName();
	}

	public T salvar(T t) {

		entityManager.getTransaction().begin();
		t = entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();

		return t;
	}

	public List<T> listar() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteria = builder.createQuery((Class<T>) getPersistenceClass());
		criteria.from(getPersistenceClass());

		return entityManager.createQuery(criteria).getResultList();

	}

	public T getById(ID id) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteria = builder.createQuery((Class<T>) getPersistenceClass());
		Root<T> from = criteria.from((Class<T>) getPersistenceClass());
		TypedQuery<T> typedQuery = entityManager.createQuery(criteria.select(from).where(builder.equal(from.get("id"), id)));

		return typedQuery.getSingleResult();
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
