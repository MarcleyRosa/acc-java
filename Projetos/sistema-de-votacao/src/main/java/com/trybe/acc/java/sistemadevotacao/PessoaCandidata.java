package com.trybe.acc.java.sistemadevotacao;

public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  /**
   * cadastra um novo candidato.
   * 
   * @param nome recebi um nome.
   * @param numero recebi um numero.
   */
  public PessoaCandidata(String nome, int numero) {
    this.numero = numero;
    this.votos = 0;

    super.setNome(nome);
  }



  public int getNumero() {
    return numero;
  }



  public void setNumero(int numero) {
    this.numero = numero;
  }



  public int getVotos() {
    return votos;
  }



  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }

}
