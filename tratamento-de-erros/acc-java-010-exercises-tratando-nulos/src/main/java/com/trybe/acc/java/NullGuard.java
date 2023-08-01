package com.trybe.acc.java;

public class NullGuard {

  /**
   * Retorna menssagem da validação.
   */
  public String printName(int divisor) {
    try {
      NullGenerator nullGenerator = new NullGenerator();

      return nullGenerator.getNome(divisor);
    } catch (NullPointerException e) {
      return "Nome nulo";
    }
  }
}
