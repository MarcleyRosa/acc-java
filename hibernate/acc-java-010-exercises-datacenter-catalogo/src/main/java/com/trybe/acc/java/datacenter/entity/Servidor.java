package com.trybe.acc.java.datacenter.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * class servidor hibernate.
 */
@Entity
public class Servidor {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  
  @ManyToOne
  @JoinColumn(name = "datacenter_id")
  private Datacenter datacenter;
  
  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "relacionamento_servidor_aplicacao",
      joinColumns = {@JoinColumn(name = "servidor_id")},
      inverseJoinColumns = {@JoinColumn(name = "aplicacao_id")})
  private Set<Aplicacao> aplicacoes;

  public Servidor() {
    super();
    this.aplicacoes = new HashSet<Aplicacao>();
  }

  public Set<Aplicacao> getAplicacoes() {
    return aplicacoes;
  }

  public void addAplicacao(Aplicacao aplicacao) {
    this.aplicacoes.add(aplicacao);
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Datacenter getDatacenter() {
    return datacenter;
  }

  public void setDatacenter(Datacenter datacenter) {
    this.datacenter = datacenter;
  }

}
