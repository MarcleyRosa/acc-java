package com.trybe.contabancaria;

/**
 * Classe ValidaCpf.
 **/

public class ValidaCpf {

  /**
   * Atributos.
   **/

  public static boolean validarCpf(String cpf) {
    if (cpf.length() != 11) {
      return false;
    }

    int somaDigit1 = 0;
    int somaDigit2 = 0;
    int peso = 10;

    for (int i = 0; i <= 9; i++) {
      int num = Byte.parseByte(Character.toString(cpf.charAt(i)));

      if (i <= 8) {
        somaDigit1 += num * peso;
      }
      somaDigit2 += num * (peso + 1);

      peso--;
    }

    int dv1 = 11 - (somaDigit1 % 11);
    int dv2 = 11 - (somaDigit2 % 11);

    dv1 = (dv1 == 10 || dv1 == 11) ? 0 : dv1;
    dv2 = (dv2 == 10 || dv2 == 11) ? 0 : dv2;

    byte cpfDigit1 = Byte.parseByte(Character.toString(cpf.charAt(9)));
    byte cpfDigit2 = Byte.parseByte(Character.toString(cpf.charAt(10)));
    return dv1 == cpfDigit1 && dv2 == cpfDigit2;
  }
}

