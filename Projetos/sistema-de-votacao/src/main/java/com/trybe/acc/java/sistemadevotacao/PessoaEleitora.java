package com.trybe.acc.java.sistemadevotacao;

public class PessoaEleitora extends Pessoa {
  private String cpf;


  /**
   * cadastra um novo eleitor.
   * 
   * @param nome recebi o nome.
   * @param cpf recebi o cpf.
   */
  public PessoaEleitora(String nome, String cpf) {
    super();
    this.cpf = cpf;
    super.setNome(nome);
  }


  public void setCpf(String cpf) {
    this.cpf = cpf;
  }


  public String getCpf() {
    return cpf;
  }

}
