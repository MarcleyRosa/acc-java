package com.trybe.acc.java;

import java.util.Scanner;

public class Main {

  /**
   * Descrição da Class.
   * 
   * @param args calcula media de notas.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Qual é o seu nome?");

    String name = scan.next();

    System.out.println("Entre com as notas das provas:");
    System.out.println("Avaliação 1:");

    String getAv1 = scan.next();

    System.out.println("Avaliação 2:");

    String getAv2 = scan.next();

    System.out.println("Avaliação 3:");

    String getAv3 = scan.next();

    System.out.println("Avaliação 4:");

    String getAv4 = scan.next();

    Nota nota = new Nota();

    double av1 = Double.parseDouble(getAv1);
    double av2 = Double.parseDouble(getAv2);
    double av3 = Double.parseDouble(getAv3);
    double av4 = Double.parseDouble(getAv4);

    double media = nota.calcularMedia(av1, av2, av3, av4);

    System.out.println("Olá, " + name + ", sua média é " + media);

  }

}
