package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Estatistica {
  void quantity(ArrayList<Short> array) {
    try {
      short menor18 = 0;
      short de18a49 = 0;
      short maior50 = 0;
      int total = array.size();
      for (short idade : array) {
        if (idade < 18) {
          menor18 += 1;
        } else if (idade >= 50) {
          maior50 += 1;
        } else {
          de18a49 += 1;
        }
      }
      float menor = menor18;
      float adulto = de18a49;
      float maior = maior50;
      DecimalFormat df = new DecimalFormat("0.00%");
      String percentMenor = df.format(menor / total);
      String percentDe18a49 = df.format(adulto / total);
      String percentMaior = df.format(maior / total);
      System.out.println("----- Quantidade -----\n" + "menores: " + menor18 + "\n" + "adultas: "
          + de18a49 + "\n" + "a partir de 50: " + maior50 + "\n" + "\n" + "----- Percentual -----\n"
          + "menores: " + percentMenor + "\n" + "adultas: " + percentDe18a49 + "\n"
          + "a partir de 50: " + percentMaior + "\n" + "\n" + "TOTAL: " + total);
      System.out.println(menor);
    } catch (ArithmeticException e) {
      System.out.println("Lista vazia");
    }
  }
}
