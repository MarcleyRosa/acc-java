package com.trybe.acc.java.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Hiber {

  /**
   * SALVA NO BANCO DE DADOS.
   */
  public static void save(Veiculo veiculo) {

    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("com.trybe.acc.java.hibernate.veiculo-hibernate");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.merge(veiculo);
    em.getTransaction().commit();

    em.close();
  }

}
