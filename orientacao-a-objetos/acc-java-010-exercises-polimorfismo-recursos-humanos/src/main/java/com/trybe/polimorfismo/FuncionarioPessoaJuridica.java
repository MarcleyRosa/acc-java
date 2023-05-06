package com.trybe.polimorfismo;

public class FuncionarioPessoaJuridica extends Funcionario {

  /**
   * Funcionario pessoa juridica.
   */

  @Override
  public double calcularSalarioLiquido() {
    return this.salarioBruto - this.salarioBruto * 0.10;
  }

}
