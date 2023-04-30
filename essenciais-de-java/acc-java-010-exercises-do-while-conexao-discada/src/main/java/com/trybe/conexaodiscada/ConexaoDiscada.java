package com.trybe.conexaodiscada;

import java.util.Random;

/**
 * Classe ConexaoDiscada.
 *
 */
public class ConexaoDiscada {

  /**
   * Método principal.
   *
   */
  @SuppressWarnings("static-access")
  public static void main(String[] args) {
    int count = 0;
    boolean connect = false;
    do {
      boolean con = conexaoDiscada.conectou();
      connect = con;
      count += 1;
    } while (!connect && count < 3);
  }

  static boolean conectou() {
    return conexaoDiscada.verdadeiroOuFalso();
  }

  static ConexaoDiscada conexaoDiscada = new ConexaoDiscada();

  boolean verdadeiroOuFalso() {
    return new Random().nextInt(2) == 1;
  }

}
