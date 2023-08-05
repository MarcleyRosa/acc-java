package com.trybe.contabancaria;

public class Cliente {

  private String nome;
  private String cpf;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  /**
   * altera o cpf.
   */
  public void setCpf(String cpf) {
    boolean isValid = ValidaCpf.validarCpf(cpf);
    if (isValid) {
      this.cpf = cpf;
    } else {
      this.cpf = null;
    }
  }


}
