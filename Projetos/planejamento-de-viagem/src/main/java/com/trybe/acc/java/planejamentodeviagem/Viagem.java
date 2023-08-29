package com.trybe.acc.java.planejamentodeviagem;

public class Viagem {
  private String embarque;
  private String origem;
  private String destino;
  private double distanciaKm;
  // private Voo voo;

  /**
   * Método construtor da classe.
   * 
   */
  public Viagem(String embarque, String origem, String destino, double distanciaKm) {
    this.embarque = embarque;
    this.origem = origem;
    this.destino = destino;
    this.distanciaKm = distanciaKm;
  }

  /**
   * Método para retorno do horário de Desembarque no Destino.
   * 
   */
  public String retonarDesembarqueHorarioLocalDestino() {
    Tempo tempoViagem =
        new Tempo(this.embarque, this.origem, this.destino, this.retornarDuracaoVoo());
    return tempoViagem.retonarDesembarqueHorarioLocalDestino();
  }

  // aqui consideramos que um aviao percorre em media 700 km a cada hora
  public int retornarDuracaoVoo() {
    double duration = this.distanciaKm / 700;
    return (int) duration;
  }

  /**
   * Método para retorno da informaçao da viagem.
   * 
   */
  public String retornarInformacaoViagem() {
    Tempo tempoViagem =
        new Tempo(this.embarque, this.origem, this.destino, this.retornarDuracaoVoo());
    // System.out.println(tempoViagem.retonarDesembarqueHorarioLocalDestino());
    // System.out.println(tempoViagem.retonarDesembarqueHorarioLocalOrigem());
    return "Partida: " + this.embarque + "\n" + "Origem: " + this.origem + "\n\n" + "Chegada: "
        + tempoViagem.retonarDesembarqueHorarioLocalDestino() + "\n" + "Destino: " + this.destino
        + "\n\n" + "Atenção: o desembarque em " + this.destino + " será: "
        + tempoViagem.retonarDesembarqueHorarioLocalDestino() + " no horário de " + this.destino
        + " e " + tempoViagem.retonarDesembarqueHorarioLocalOrigem() + " no horário de "
        + this.origem;

    /* Implemente sua solução aqui */
  }
}
