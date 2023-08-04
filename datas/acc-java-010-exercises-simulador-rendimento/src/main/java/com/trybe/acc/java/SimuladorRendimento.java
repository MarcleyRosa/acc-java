package com.trybe.acc.java;

import java.time.LocalDateTime;

public class SimuladorRendimento {


  /**
   * cria a instancia de simularRendimentoAnos.
   * 
   */
  public static void main(String[] args) {
    SimuladorRendimento obj = new SimuladorRendimento();
    double inicial = 500;
    double objetivo = 5000;
    System.out.println("Com " + inicial + " seu rendimento será " + objetivo + " no ano "
        + obj.simularRendimentoAnos(inicial, objetivo));
  }

  /**
   * simula um rendimento e retorna em que ano vai ser alcançado.
   * 
   * @param montante montante inicial.
   * @param objetivo valor do objetivo.
   */
  public int simularRendimentoAnos(double montante, double objetivo) {
    LocalDateTime anoAtual = LocalDateTime.now();
    int quantidadeAnos = 0;
    for (int index = 0; montante < objetivo; index++) {
      montante = montante + montante * 10 / 100;
      quantidadeAnos = index;
    }
    System.out.println(montante);
    return anoAtual.plusYears(quantidadeAnos + 1).getYear();
  }
}
