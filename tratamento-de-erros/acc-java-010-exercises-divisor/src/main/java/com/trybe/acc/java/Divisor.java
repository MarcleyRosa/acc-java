package com.trybe.acc.java;

public class Divisor {

  /**
   * faz uma opreação de divisão.
   *
   */
  public int dividir(int num1, int num2) {
    try {
      return num1 / num2;
    } catch (ArithmeticException e) {
      return 0;
    }
  }
}
