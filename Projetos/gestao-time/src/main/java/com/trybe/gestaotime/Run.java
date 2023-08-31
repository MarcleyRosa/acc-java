package com.trybe.gestaotime;

import com.trybe.gestaotime.dao.JogadorDao;
import com.trybe.gestaotime.model.Jogador;

/**
 * Classe Run.
 */

public class Run {

  /**
   * method main.
   */
  public static void main(String[] args) {
    Jogador jogador = new Jogador();
    jogador.setNome("jogador17");
    jogador.setPosicao("meia");

    JogadorDao jogadorDao = new JogadorDao();

    jogadorDao.salvar(jogador);
  }

}
