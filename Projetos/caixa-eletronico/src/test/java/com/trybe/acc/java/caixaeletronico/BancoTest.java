package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();

    assertEquals(banco.gerarNumeroNovaConta().length(), 10);
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();

    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    assertEquals(cliente.getCpf(), "433.892.200-11");
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();

    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    PessoaCliente clienteLogin = banco.pessoaClienteLogin("433.892.200-11", "1234");
    PessoaCliente clienteLoginFailure = banco.pessoaClienteLogin("433.892.200-11", "88888888");

    assertEquals(cliente, clienteLogin);
    assertEquals(clienteLoginFailure, null);

  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();

    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    banco.adicionarConta("Poupança", cliente);
    banco.adicionarConta("Corrente", cliente);

    banco.depositar(cliente, 1, 200);

    banco.transferirFundos(cliente, 1, 0, 130);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalPrintStream = System.out;
    System.setOut(printStream);

    banco.mostrarExtrato(cliente, 1);
    System.out.flush();
    System.setOut(originalPrintStream);

    String saidaEsperadaTrasnfer = "Transferência realizada: R$ 130.00 +";
    String saidaAtual = outputStream.toString().trim();
    assertTrue(saidaAtual.contains(saidaEsperadaTrasnfer));

  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();

    PessoaCliente cliente =
        banco.adicionarPessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");
    banco.adicionarConta("Poupança", cliente);
    banco.adicionarConta("Corrente", cliente);

    banco.depositar(cliente, 1, 200);

    banco.sacar(cliente, 1, 50);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalPrintStream = System.out;
    System.setOut(printStream);

    banco.mostrarExtrato(cliente, 1);
    System.out.flush();
    System.setOut(originalPrintStream);

    String saidaEsperadaSaque = "Saque efetuado: R$ 50.00 +";
    String saidaAtual = outputStream.toString().trim();
    assertTrue(saidaAtual.contains(saidaEsperadaSaque));

  }

}
