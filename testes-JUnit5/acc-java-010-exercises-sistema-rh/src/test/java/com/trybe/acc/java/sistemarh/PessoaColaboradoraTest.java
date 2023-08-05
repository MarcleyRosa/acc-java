package com.trybe.acc.java.sistemarh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaColaboradoraTest {


  @Test
  @DisplayName("Testa se o cálculo do salario líquido é feito corretamente")
  void testeCalcularSalarioLiquido() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(5000);

    assertEquals(colaborador.getSalarioBruto(), 5000);
    assertEquals(colaborador.calcularSalarioLiquido(), 4000);
  }

  @Test
  @DisplayName("Testa se o valor bruto anual é feito corretamente")
  void testeCalcularValorBrutoRecebidoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(2000);

    assertEquals(colaborador.calcularValorBrutoRecebidoAnual(2), 48000);
  }

  @Test
  @DisplayName("Testa se o calculo do valor liquido recebido por ano está certo")
  void testeCalcularValorLiquidoRecebidoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(5000);

    assertEquals(colaborador.calcularValorLiquidoRecebidoAnual(2), 96000);
  }

  @Test
  @DisplayName("Testa se o calculo do valor do imposto é feito corretamente")
  void testeCalcularValorImpostoAnual() {
    PessoaColaboradora colaborador = new PessoaColaboradora();
    colaborador.setSalarioBruto(5000);

    assertEquals(colaborador.calcularValorImpostoAnual(3), 36000);
  }


}
