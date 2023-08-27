package com.trybe.acc.java.controledeacesso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    System.out.println(5000 - (5000 * 10 / 100));
    Scanner scan = new Scanner(System.in);
    boolean optionSelect = true;
    ArrayList<Short> arrayIdades = new ArrayList<Short>();

    while (optionSelect) {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Acessar o estabelecimento\n" + "2 - Finalizar sistema e mostrar relatório");
      String option = scan.next();

      if (option.contains("2")) {
        optionSelect = false;
        Estatistica estatistica = new Estatistica();
        estatistica.quantity(arrayIdades);
      } else if (option.contains("1")) {

        System.out.println("Entre com a idade:");

        String idade = scan.next();

        try {

          short parseIdade = Short.parseShort(idade);

          arrayIdades.add(parseIdade);

          Idade authIdade = new Idade();

          authIdade.faixaEtaria(parseIdade);
        } catch (NumberFormatException e) {
          System.out.println("Não é um valor válido para a idade");
        }
      } else {
        System.out.println("Entre com uma opção válida!");
      }

    }
    scan.close();
  }
}
