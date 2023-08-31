package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {

  private Class<T> entity;
  public static final EntityManager em =
      Persistence.createEntityManagerFactory("crudHibernatePU").createEntityManager();

  /**
   * constructor do generic que recebi uma class.
   */
  public GenericDao(Class<T> entity) {

    super();
    this.entity = entity;
  }

  /**
   * recebi uma entidade e salva no banco de dados.
   */

  public void salvar(T s) {
    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();
  }

  /**
   * recebi uma entidade e edita no banco de dados.
   */
  public void editar(T s) {
    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();
  }

  /**
   * recebi um id e deleta no banco de dados.
   */
  public void deletar(Long id) {
    T find = em.find(this.entity, id);

    em.getTransaction().begin();
    em.remove(find);
    em.getTransaction().commit();
  }

  /**
   * lista as entidades.
   */
  public List<T> listar() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(this.entity);
    Root<T> rootEntry = cq.from(this.entity);
    CriteriaQuery<T> all = cq.select(rootEntry);

    TypedQuery<T> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  /**
   * acha uma entidade no banco de dados.
   */
  public T findById(Long id) {
    return em.find(this.entity, id);
  }

}
