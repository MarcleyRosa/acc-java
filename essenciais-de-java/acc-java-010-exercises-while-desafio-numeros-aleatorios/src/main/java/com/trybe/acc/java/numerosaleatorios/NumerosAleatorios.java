package com.trybe.acc.java.numerosaleatorios;

import java.util.Random;

public class NumerosAleatorios {
  /**
   * Método principal para a execuçao do código.
   * 
   */
  public static void main(String[] args) {
    int num = NumerosAleatorios.numeroAleatorio();
    while (num != 4) {
      NumerosAleatorios.imprime(num);
      num = NumerosAleatorios.numeroAleatorio();
    }
    NumerosAleatorios.imprime(4);
  }

  // Chame a função escrevendo `imprime()`.
  static void imprime(int numero) {
    System.out.println(numero);
  }

  // Chame a função escrevendo `numeroAleatorio()`.
  static int numeroAleatorio() {
    return numerosAleatorios.entreUmECinco();
  }

  static NumerosAleatorios numerosAleatorios = new NumerosAleatorios();

  int entreUmECinco() {
    return new Random().nextInt(5) + 1;
  }
}
