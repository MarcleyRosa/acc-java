package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  ArrayList<Conta> contas = new ArrayList<Conta>();

  /**
   * gera um numero de uma conta.
   */

  /**
   * verifica se um numero de uma conta existe.
   */
  private boolean existeNumeroConta(String numeroConta) {
    for (Conta conta : contas) {
      if (conta.getIdConta().equals(numeroConta)) {
        return true;
      }
    }
    return false;
  }

  /**
   * gera um numero novo da conta.
   */
  public String gerarNumeroNovaConta() {

    Random random = new Random();
    String numeroConta;


    do {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 10; i++) {
        int digito = random.nextInt(10);
        sb.append(digito);
      }
      numeroConta = sb.toString();
    } while (this.existeNumeroConta(numeroConta));

    return numeroConta;
  }

  /**
   * adiciona um cliente.
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    pessoasClientes.add(cliente);
    return cliente;
  }

  /**
   * adiciona uma nova conta.
   */
  public void adicionarConta(String tipoConta, PessoaCliente pessoaCliente) {
    Conta novaConta = new Conta(tipoConta, pessoaCliente, new Banco());
    pessoaCliente.adicionarConta(novaConta);
    contas.add(novaConta);
  }

  /**
   * login de um cliente.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    PessoaCliente pessoaCliente = pessoasClientes.stream()
        .filter(cliente -> cliente.getCpf().equals(cpf) && cliente.validarSenha(senha)).findFirst()
        .orElse(null);
    return pessoaCliente;
  }

  /**
   * faz transações entre as proprias contas do usuario.
   */
  public void transferirFundos(PessoaCliente pessoaCliente, int daConta, int paraConta,
      double quantia) {

    contas.get(daConta).adicionarTransacao(quantia, "Transferência realizada");
    contas.get(paraConta).adicionarTransacao(quantia, "Transferência recebida");
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia, "Transferência realizada");
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Transferência recebida");
  }

  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia, "Saque efetuado");
    contas.get(daConta).adicionarTransacao(quantia, "Saque efetuado");;
  }

  public void depositar(PessoaCliente pessoaCliente, int paraConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Depósito recebido");
    contas.get(paraConta).adicionarTransacao(quantia, "Depósito recebido");
  }

  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    contas.get(conta).retornarExtrato();
  }
}
