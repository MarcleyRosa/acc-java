package com.trybe.acc.java.datacenter.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * datacenter banco de dados.
 */
@Entity
public class Datacenter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @OneToMany(mappedBy = "datacenter", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Servidor> servidores;

  public Datacenter() {
    super();
    this.servidores = new HashSet<Servidor>();
  }

  public void addServidor(Servidor servidor) {
    this.servidores.add(servidor);
  }

  private String nome;
  private String localidade;

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

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

}
