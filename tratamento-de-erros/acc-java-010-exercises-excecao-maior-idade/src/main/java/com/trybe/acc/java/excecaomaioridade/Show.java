package com.trybe.acc.java.excecaomaioridade;

/**
 * Classe do desafio.
 */
public class Show {

  /**
   * Método do desafio.
   * 
   * @throws PessoaMenorDeIdadeException menor de idade.
   */
  public boolean permitirEntrada(int idade) throws PessoaMenorDeIdadeException {
    if (idade < 18) {
      throw new PessoaMenorDeIdadeException();
    }
    return false;
  }
}
