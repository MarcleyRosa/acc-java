package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    Conta conta = new Conta("Corrente", cliente, banco);

    assertEquals(conta.getIdConta().length(), 10);
    assertEquals(conta.getPessoaCliente(), cliente);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    Conta conta = new Conta("Corrente", cliente, banco);

    conta.adicionarTransacao(500, "Depósito recebido");

    assertEquals(conta.retornarSaldo(), 500);

  }


  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    Conta conta = new Conta("Corrente", cliente, banco);

    conta.adicionarTransacao(250, "Depósito recebido");

    assertEquals(conta.retornarResumoConta(), conta.getIdConta() + " : R$250.00 : Corrente");

  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {

    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    Conta conta = new Conta("Corrente", cliente, banco);

    conta.adicionarTransacao(250, "Depósito recebido");

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalPrintStream = System.out;
    System.setOut(printStream);

    conta.retornarExtrato();
    System.out.flush();
    System.setOut(originalPrintStream);

    String saidaEsperada = "Depósito recebido: R$ 250.00";
    String saidaAtual = outputStream.toString().trim();

    assertTrue(saidaAtual.contains(saidaEsperada));

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    Conta conta = new Conta("Corrente", cliente, banco);

    assertEquals(conta.getIdConta().length(), 10);
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    Conta conta = new Conta("Corrente", cliente, banco);

    assertEquals(conta.getPessoaCliente(), cliente);
  }

}
