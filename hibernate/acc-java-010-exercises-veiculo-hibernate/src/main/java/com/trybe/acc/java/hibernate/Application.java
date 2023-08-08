package com.trybe.acc.java.hibernate;

import com.trybe.acc.java.hibernate.entity.Hiber;
import com.trybe.acc.java.hibernate.entity.Veiculo;

public class Application {

  /**
   * Método principal.
   * 
   * @param args argumentos da linha de comando
   */

  /**
   * metdodo main.
   */
  public static void main(String[] args) {

    Veiculo veiculo = new Veiculo();

    veiculo.setId(5415485);
    veiculo.setAno(2009);
    veiculo.setModelo("Morea");
    veiculo.setQuilometragem("5124");
    Hiber.save(veiculo);
  }

}
