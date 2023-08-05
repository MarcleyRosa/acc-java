package com.trybe.contabancaria.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.trybe.contabancaria.Cliente;

class TesteCliente {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @Test
  void testeNome() {
    Cliente cliente = new Cliente();

    cliente.setNome("TestName");

    assertEquals(cliente.getNome(), "TestName");
  }

  @Test
  void testeSetCPFValido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("05849678549");

    assertEquals(cliente.getCpf(), "05849678549");
  }

  @Test
  void testeSetCPFInvalido() {
    Cliente cliente = new Cliente();
    cliente.setCpf("321");

    assertEquals(cliente.getCpf(), null);
  }

}
