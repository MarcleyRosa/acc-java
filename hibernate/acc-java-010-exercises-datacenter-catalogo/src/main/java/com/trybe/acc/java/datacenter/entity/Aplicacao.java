package com.trybe.acc.java.datacenter.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * class aplicacao hibernate.
 */
@Entity
public class Aplicacao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private String descricao;
  
  @ManyToMany(mappedBy = "aplicacoes")
  private Set<Servidor> servidores;

  public Set<Servidor> getServidores() {
    return servidores;
  }

  public void setServidores(Set<Servidor> servidores) {
    this.servidores = servidores;
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

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
