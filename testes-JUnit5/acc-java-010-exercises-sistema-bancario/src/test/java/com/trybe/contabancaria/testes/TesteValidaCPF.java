package com.trybe.contabancaria.testes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.trybe.contabancaria.ValidaCpf;

class TesteValidaCPF {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @Test
  void testeValidarCPFValido() {
    assertTrue(ValidaCpf.validarCpf("51428569524"));
  }

  @Test
  void testeValidarCPFInvalido() {
    assertFalse(ValidaCpf.validarCpf("123"));
  }

}
