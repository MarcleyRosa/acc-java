package com.trybe.polimorfismo;

public class Principal {

  /**
   * Class main.
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    FuncionarioPessoaJuridica ps1 = new FuncionarioPessoaJuridica();

    ps1.setSalarioBruto(5000);

    System.out.println("O salário líquido pessoa física: " + ps1.calcularSalarioLiquido());
  }

}
