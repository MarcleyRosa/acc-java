package com.trybe.acc.java.recursoshumanos;

/**
 * Classe que representa uma pessoa funcionária no sistema de recursos humanos.
 */
public class PessoaFuncionaria {
  private String nomeCompleto;
  private String cpf;
  private String endereco;
  private double salario;

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getCpf() {
    return cpf;
  }

  /**
   * Constructor da Class.
   * 
   * @param nomeCompleto recebi o nome.
   * @param cpf recebi o cpf.
   * @param endereco recebi o endereço.
   * @param salario recebi o salario.
   */
  public PessoaFuncionaria(String nomeCompleto, String cpf, String endereco, double salario) {
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.endereco = endereco;
    this.salario = salario;
  }
}
