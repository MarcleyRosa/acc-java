package com.trybe.idadeemdias;

public class Pessoa {

  int calcularIdadeEmDias(int ano, int meses, int dias) {
    int diasDeVida = (ano * 365) + (meses * 30) + dias;
    return diasDeVida;
  }

}
