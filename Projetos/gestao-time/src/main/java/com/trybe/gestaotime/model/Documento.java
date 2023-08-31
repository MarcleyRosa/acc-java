package com.trybe.gestaotime.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe Documento.
 */
@Entity
public class Documento {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  private String cpf;
  private String numeroCbf;
  private String numeroCarteiraTrabalho;

  public String getNumeroCarteiraTrabalho() {
    return numeroCarteiraTrabalho;
  }

  public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
    this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNumeroCbf() {
    return numeroCbf;
  }

  public void setNumeroCbf(String numeroCbf) {
    this.numeroCbf = numeroCbf;
  }

}
