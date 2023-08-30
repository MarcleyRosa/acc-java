package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * Contructor do cliente.
   * 
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;
    System.out
        .println("Nova pessoa cliente " + this.nomeCompleto + " com CPF: " + cpf + " criada!\n");
  }

  public void adicionarConta(Conta conta) {
    contas.add(conta);
  }

  public int retornaNumeroDeContas() {
    return contas.size();
  }

  public double retornarSaldoContaEspecifica(int indice) {
    return contas.get(indice).retornarSaldo();
  }

  public String retornarIdContaEspecifica(int indice) {
    return contas.get(indice).getIdConta();
  }

  public void retornarExtratoContaEspecifica(int indice) {
    contas.get(indice).retornarExtrato();
  }

  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    contas.get(indice).adicionarTransacao(quantia, descricao);
  }

  /**
   * valida uma senha.
   */
  public boolean validarSenha(String senha) {
    if (senha.contains(this.senha)) {
      return true;
    }
    return false;
  }

  /**
   * retorna o resumo da conta.
   */
  public void retornarResumoContas() {
    System.out.println("\nResumo das Contas da pessoa " + this.nomeCompleto + ":\n");
    for (int i = 0; i < contas.size(); i++) {
      Conta conta = contas.get(i);
      System.out.println(i + 1 + ") " + conta.retornarResumoConta() + "\n");
    }
  }

  public String getCpf() {
    return this.cpf;
  }
}
