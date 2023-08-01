package com.trybe.acc.java.excecaomaioridade;

@SuppressWarnings("serial")
public class PessoaMenorDeIdadeException extends Exception {
  public PessoaMenorDeIdadeException() {
    super("Pessoa menor de 18 anos! Operação não permitida");
  }
}
