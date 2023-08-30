package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalPrintStream = System.out;
    System.setOut(printStream);

    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    System.out.flush();
    System.setOut(originalPrintStream);

    String saidaEsperada =
        "Nova pessoa cliente Camaragibe Oliveira com CPF: " + client.getCpf() + " criada!";
    String saidaAtual = outputStream.toString().trim();


    assertEquals(client.getCpf(), "433.892.200-11");
    assertEquals(saidaAtual, saidaEsperada);
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    Banco banco = new Banco();
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    Conta contaCorrente = new Conta("Corrente", client, banco);
    Conta contaPoupanca = new Conta("Poupança", client, banco);

    client.adicionarConta(contaCorrente);
    client.adicionarConta(contaPoupanca);

    assertEquals(client.retornaNumeroDeContas(), 2);

  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    Conta contaCorrente = new Conta("Corrente", client, banco);

    client.adicionarConta(contaCorrente);
    banco.adicionarConta("Corrente", client);

    banco.depositar(client, 0, 210);

    assertEquals(client.retornarSaldoContaEspecifica(1), 210);


  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    Conta contaCorrente = new Conta("Corrente", client, banco);
    Conta contaPoupanca = new Conta("Poupança", client, banco);


    client.adicionarConta(contaCorrente);
    banco.adicionarConta("Corrente", client);
    client.adicionarConta(contaPoupanca);
    banco.adicionarConta("Poupança", client);

    assertEquals(client.retornarIdContaEspecifica(0), contaCorrente.getIdConta());

  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    Conta contaCorrente = new Conta("Corrente", client, banco);
    Conta contaPoupanca = new Conta("Poupança", client, banco);


    client.adicionarConta(contaCorrente);
    banco.adicionarConta("Corrente", client);
    client.adicionarConta(contaPoupanca);
    banco.adicionarConta("Poupança", client);

    banco.depositar(client, 1, 210);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalPrintStream = System.out;
    System.setOut(printStream);

    client.retornarExtratoContaEspecifica(1);

    System.out.flush();
    System.setOut(originalPrintStream);

    String saidaEsperada = "Depósito recebido: R$ 210.00";
    String saidaAtual = outputStream.toString().trim();

    assertTrue(saidaAtual.contains(saidaEsperada));

    // assertEquals(saidaAtual, saidaEsperada);

  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    Conta contaCorrente = new Conta("Corrente", client, banco);
    Conta contaPoupanca = new Conta("Poupança", client, banco);


    client.adicionarConta(contaCorrente);
    banco.adicionarConta("Corrente", client);
    client.adicionarConta(contaPoupanca);
    banco.adicionarConta("Poupança", client);

    banco.depositar(client, 0, 200);

    client.adicionarTransacaoContaEspecifica(1, 127, "Transferência realizada");

    assertEquals(client.retornarSaldoContaEspecifica(1), 73);

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    assertTrue(client.validarSenha("1234"));
    assertFalse(client.validarSenha("777777777"));

  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    Banco banco = new Banco();
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    Conta contaCorrente = new Conta("Corrente", client, banco);

    client.adicionarConta(contaCorrente);
    banco.adicionarConta("Corrente", client);

    banco.depositar(client, 0, 200);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalPrintStream = System.out;
    System.setOut(printStream);

    client.retornarResumoContas();

    System.out.flush();
    System.setOut(originalPrintStream);

    String saidaEsperada = "R$200.00 : Corrente";
    String saidaAtual = outputStream.toString().trim();
    assertTrue(saidaAtual.contains(saidaEsperada));


  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    PessoaCliente client = new PessoaCliente("Camaragibe Oliveira", "433.892.200-11", "1234");

    assertEquals(client.getCpf(), "433.892.200-11");
  }

}
