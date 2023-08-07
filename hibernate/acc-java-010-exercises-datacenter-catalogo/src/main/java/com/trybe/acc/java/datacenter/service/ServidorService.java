package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Servidor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * service do servidor.
 */
public class ServidorService implements ServiceInterface<Servidor, Long> {
  private EntityManagerFactory emf;
  
  public ServidorService() {
    super();
    this.emf = ServiceInterface.emf;
  }

  @Override
  public void save(Servidor s) {
    EntityManager em = this.emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();

    em.close();

  }

  @Override
  public void update(Servidor s) {
    EntityManager em = this.emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void delete(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Servidor servidor = em.find(Servidor.class, id);

    em.getTransaction().begin();
    em.remove(servidor);
    em.getTransaction().commit();

    em.close();

  }

  @Override
  public List<Servidor> list() {
    EntityManager em = this.emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Servidor> cq = cb.createQuery(Servidor.class);
    Root<Servidor> rootEntry = cq.from(Servidor.class);
    CriteriaQuery<Servidor> all = cq.select(rootEntry);

    TypedQuery<Servidor> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  @Override
  public Servidor findById(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Servidor find = em.find(Servidor.class, id);
    return find;
  }

}
