package com.trybe.acc.java.caixaeletronico;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;
  // private Conta conta;

  /**
   * transação.
   */
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = this.retornarInstante();
  }

  public String getDescricao() {
    return descricao;
  }

  public double getQuantia() {
    return quantia;
  }

  /**
   * retorna o resumo da transação.
   */
  public String retornarResumoTransacao() {
    Locale.setDefault(Locale.US);

    DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
    DecimalFormat formato = new DecimalFormat("#0.00", simbolos);

    String numeroFormatado = formato.format(this.quantia);
    return this.instante + " -------- " + this.descricao + ": " + "R$ " + numeroFormatado + " +";
  }

  /**
   * retorna a data e hora da criação.
   */
  public String retornarInstante() {
    LocalDateTime instante = LocalDateTime.now();
    DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String momentoFormatado = instante.format(formatoBrasileiro);

    return momentoFormatado;
  }

}

