package com.trybe.acc.java.numerospares;

/**
 * Classe NumerosPares.
 * 
 */
public class NumerosPares {

  /**
   * Método para implementar o for que vai gerar os números de 4 a 20.
   * 
   */
  public static void main(String[] args) {
    for (int index = 4; index <= 20; index++) {
      if (index % 2 == 0) {
        NumerosPares.imprime(index);
      }
    }
  }

  /**
   * Método para imprimir no console os números de 4 a 20.
   * 
   */
  public static void imprime(int numero) {
    System.out.println(numero);
  }

}
