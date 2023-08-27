package com.trybe.acc.java.controledeacesso;

public class Idade {
  void faixaEtaria(short idade) {
    if (idade < 18) {
      System.out.println("Pessoa cliente menor de idade, catraca liberada!");
    } else if (idade >= 50) {
      System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
    } else if (idade >= 18 && idade <= 49) {
      System.out.println("Pessoa adulta, catraca liberada!");
    }
  }
}
