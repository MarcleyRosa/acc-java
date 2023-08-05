package com.trybe.contabancaria.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.trybe.contabancaria.ContaBancaria;

class TesteContaBancaria {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @Test
  void testeNomeCliente() {
    ContaBancaria conta = new ContaBancaria();

    conta.setNomeCliente("TestName");

    assertEquals(conta.getNomeCliente(), "TestName");
  }

  @Test
  void testeCPFClienteValido() {
    ContaBancaria conta = new ContaBancaria();

    conta.setCpfCliente("98884155061");

    assertEquals(conta.getCpfCliente(), "98884155061");
  }

  @Test
  void testeCPFClienteInvalido() {
    ContaBancaria conta = new ContaBancaria();

    conta.setCpfCliente("741");

    assertEquals(conta.getCpfCliente(), null);
  }

  @Test
  void testeDepositar() {
    ContaBancaria conta = new ContaBancaria();

    conta.depositar(500);

    assertEquals(conta.verSaldo(), 500);
  }

  @Test
  void testeSacar() {
    ContaBancaria conta = new ContaBancaria();

    conta.depositar(500);
    conta.sacar(300);

    assertEquals(conta.verSaldo(), 200);
  }


}
