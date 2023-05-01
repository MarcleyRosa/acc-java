package com.trybe.idadeemdias;

import java.util.Scanner;

public class Main {

  /**
   * Descrição da Class.
   * 
   * @param args total de dias vividos de uma pessoa.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Qual é seu nome?");

    String name = scan.next();

    System.out.println("Qual é sua idade em anos, meses e dias?");

    System.out.println("anos:");

    String getAnos = scan.next();

    System.out.println("meses:");

    String getMeses = scan.next();

    System.out.println("dias:");

    String getDias = scan.next();

    int dias = Integer.parseInt(getDias);

    int anos = Integer.parseInt(getAnos);

    int meses = Integer.parseInt(getMeses);

    Pessoa pessoa = new Pessoa();

    int totalDias = pessoa.calcularIdadeEmDias(anos, meses, dias);

    System.out.println("Olá " + name + ", sua idade em dias é " + totalDias);

    scan.close();
  }

}
