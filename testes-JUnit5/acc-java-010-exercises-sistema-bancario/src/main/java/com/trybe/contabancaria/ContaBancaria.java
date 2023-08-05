package com.trybe.contabancaria;

/**
 * Classe ContaBancaria.
 **/

public class ContaBancaria {

  private int saldo;
  private Cliente cliente;

  public ContaBancaria() {
    this.saldo = 0;
    this.cliente = new Cliente();
  }

  public void setNomeCliente(String nome) {
    this.cliente.setNome(nome);
  }

  public String getNomeCliente() {
    return this.cliente.getNome();
  }

  public void setCpfCliente(String cpf) {
    this.cliente.setCpf(cpf);
  }

  public String getCpfCliente() {
    return this.cliente.getCpf();
  }

  public int depositar(int valor) {
    this.saldo += valor;
    return this.saldo;
  }

  public int sacar(int valor) {
    this.saldo -= valor;
    return this.saldo;
  }

  public int verSaldo() {
    return this.saldo;
  }
}
