package com.trybe.polimorfismo;

public class FuncionarioPessoaFisica extends Funcionario {

  /**
   * Funcionario pessoa fisica.
   */

  @Override
  public double calcularSalarioLiquido() {
    return this.salarioBruto - this.salarioBruto * 0.20;
  }

}
