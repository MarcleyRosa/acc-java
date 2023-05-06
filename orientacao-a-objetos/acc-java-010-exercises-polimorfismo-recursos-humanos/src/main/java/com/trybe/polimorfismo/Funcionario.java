package com.trybe.polimorfismo;

public abstract class Funcionario {
  protected String nome;
  protected String cpf;
  protected double salarioBruto;

  public abstract double calcularSalarioLiquido();

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSalarioBruto() {
    return this.salarioBruto;
  }

  public void setSalarioBruto(double salarioBruto) {
    this.salarioBruto = salarioBruto;
  }

  public String getCpf() {
    return this.cpf;
  }

}
