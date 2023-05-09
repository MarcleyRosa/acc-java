package com.trybe.acc.java.jogodasfazendas;

public class PlayerResult {
  String playerName;
  Farm[] farms;


  /**
   * Class para achar a maior area.
   * 
   * @param name recebi o nome.
   * @param farms recebi um conjunto de metodos.
   */
  public PlayerResult(String name, Farm[] farms) {
    this.playerName = name;
    this.farms = farms;

  }

  /**
   * metdodo para achar a maior area.
   * 
   * @return maior area.
   */
  public double score() {
    double value = 0;
    for (Farm farm : this.farms) {
      value += farm.area();
    }
    return value;
  }

  public String toString() {
    return "Desafio";
  }

}
