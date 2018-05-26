package br.com.jwm.lalapizzadelivery.app.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericRepository<T extends Object, ID extends Object> {

	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public GenericRepository() {
		entityManagerFactory = Persistence.createEntityManagerFactory(getClassName());
	}

	private String getClassName() {
		return getPersistenceClass().getName();
	}

	public T salvar(T t) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		t = entityManager.merge(t);
		entityManager.getTransaction().commit();
		entityManager.close();

		return t;
	}

	public List<T> listar() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteria = builder.createQuery((Class<T>) getPersistenceClass());
		criteria.from(getPersistenceClass());

		List<T> list = entityManager.createQuery(criteria).getResultList();

		entityManager.close();

		return list;
	}

	public T getById(ID id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteria = builder.createQuery((Class<T>) getPersistenceClass());
		Root<T> from = criteria.from((Class<T>) getPersistenceClass());
		TypedQuery<T> typedQuery = entityManager.createQuery(criteria.select(from).where(builder.equal(from.get("id"), id)));

		T t = typedQuery.getSingleResult();

		entityManager.close();

		return t;
	}


	private Class<?> getPersistenceClass() {
		Type type = null;
		Class<?> clazz = getClass();

		while (clazz != null && !(type instanceof ParameterizedType)) {
			type = clazz != null ? clazz.getGenericSuperclass() : null;
			clazz = clazz.getSuperclass();
		}

		return (Class<T>) ((ParameterizedType)type).getActualTypeArguments()[0];
	}
}
