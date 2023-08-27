package com.trybe.acc.java.sistemadevotacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {


  /**
   * metodo principal.
   * 
   */
  public static void main(String[] args) {
    try {
      Scanner scan = new Scanner(System.in);
      byte option = 1;

      GerenciamentoVotacao gerenciar = new GerenciamentoVotacao();

      while (option != 2) {

        System.out.println("Cadastrar pessoa candidata?\n" + "  1 - Sim\n" + "  2 - Não\n"
            + "Entre com o número correspondente à opção desejada:");
        option = scan.nextByte();

        if (option == 1) {
          System.out.println("Entre com o nome da pessoa candidata:");

          String name = scan.next();

          System.out.println("Entre com o número da pessoa candidata:");

          int number = scan.nextInt();

          System.out.println(number);

          gerenciar.cadastrarPessoaCandidata(name, number);
        } else if (option == 2) {
          byte optionEleitor = 0;

          while (optionEleitor != 2) {

            System.out.println("Cadastrar pessoa eleitora?\n" + "  1 - Sim\n" + "  2 - Não\n"
                + "Entre com o número correspondente à opção desejada:");
            optionEleitor = scan.nextByte();

            if (optionEleitor == 1) {
              System.out.println("Entre com o nome da pessoa eleitora:");

              String name = scan.next();

              System.out.println("Entre com o cpf da pessoa eleitora:");

              String cpf = scan.next();

              gerenciar.cadastrarPessoaEleitora(name, cpf);
            } else if (optionEleitor == 2) {
              byte optionVoto = 0;
              while (optionVoto != 3) {

                System.out.println("Entre com o número correspondente à opção desejada:\n"
                    + "  1 - Votar\n" + "  2 - Resultado Parcial\n" + "  3 - Finalizar Votação");
                optionVoto = scan.nextByte();

                if (optionVoto == 1) {
                  System.out.println("Entre com o cpf da pessoa eleitora:");

                  String name = scan.next();

                  System.out.println("Entre com o número da pessoa candidata:");

                  byte number = scan.nextByte();

                  gerenciar.votar(name, number);
                } else if (optionVoto == 2) {
                  gerenciar.mostrarResultado();

                } else if (optionVoto == 3) {
                  gerenciar.mostrarResultado();
                } else {
                  System.out.println("Entre com uma opção válida!");
                }

              }

            } else {
              System.out.println("Entre com uma opção válida!");
            }
          }
        } else {
          System.out.println("Entre com uma opção válida!");
        }

      }
      scan.close();
    } catch (InputMismatchException e) {
      System.out.println("Opção inválida");
    }
  }
}
