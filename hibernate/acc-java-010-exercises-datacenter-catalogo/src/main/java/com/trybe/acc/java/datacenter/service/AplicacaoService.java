package com.trybe.acc.java.datacenter.service;

import com.trybe.acc.java.datacenter.entity.Aplicacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * service da aplicação.
 */
public class AplicacaoService implements ServiceInterface<Aplicacao, Long> {
  private EntityManagerFactory emf;
  
  public AplicacaoService() {
    super();
    this.emf = ServiceInterface.emf;
  }

  @Override
  public void save(Aplicacao s) {
    EntityManager em = this.emf.createEntityManager();

    em.getTransaction().begin();
    em.persist(s);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void update(Aplicacao s) {
    EntityManager em = this.emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(s);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public void delete(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Aplicacao aplicacao = em.find(Aplicacao.class, id);

    em.getTransaction().begin();
    em.remove(aplicacao);
    em.getTransaction().commit();

    em.close();
  }

  @Override
  public List<Aplicacao> list() {
    EntityManager em = this.emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Aplicacao> cq = cb.createQuery(Aplicacao.class);
    Root<Aplicacao> rootEntry = cq.from(Aplicacao.class);
    CriteriaQuery<Aplicacao> all = cq.select(rootEntry);

    TypedQuery<Aplicacao> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  @Override
  public Aplicacao findById(Long id) {
    EntityManager em = this.emf.createEntityManager();

    Aplicacao aplicacao = em.find(Aplicacao.class, id);
    return aplicacao;
  }

}
