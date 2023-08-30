package com.trybe.acc.java.caixaeletronico;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

  /**
   * cria uma nova conta.
   * 
   * @param tipoConta tipo da con ta, se é corrente ou poupança.
   * @param pessoaCliente cliente.
   * @param banco instancia do banco.
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;

    this.idConta = banco.gerarNumeroNovaConta();
  }

  /**
   * adiciona um nova transação.
   * 
   * @param quantia da transação.
   * @param descricao descrição.
   */
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);

    transacoes.add(novaTransacao);
  }

  /**
   * retorna o valor do saldo em conta.
   */
  public double retornarSaldo() {
    double saldo = 0;
    for (int i = 0; i < transacoes.size(); i++) {
      Transacao transacao = transacoes.get(i);
      if (transacao.getDescricao().contains("Saque efetuado")
          || transacao.getDescricao().contains("Transferência realizada")) {
        saldo -= transacao.getQuantia();
      } else {
        saldo += transacao.getQuantia();
      }

    }

    return saldo;
  }

  public String getIdConta() {
    return idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }

  /**
   * retorna resumo da conta.
   */
  public String retornarResumoConta() {
    Locale.setDefault(Locale.US);

    DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
    DecimalFormat formato = new DecimalFormat("#0.00", simbolos);

    String numeroFormatado = formato.format(this.retornarSaldo());

    return this.idConta + " : R$" + numeroFormatado + " : " + this.tipoConta;
  }

  public void retornarExtrato() {
    System.out.println("\n");
    transacoes.forEach(e -> System.out.println(e.retornarResumoTransacao()));
  }
}
