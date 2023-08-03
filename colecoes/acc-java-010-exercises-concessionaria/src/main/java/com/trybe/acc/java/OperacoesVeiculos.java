package com.trybe.acc.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacoesVeiculos {

  public <T> long numVeiculosDiferentesVendidos(Stream<T> veiculosVendidos) {
    return veiculosVendidos.distinct().count();
  }

  public <T> Stream<String> obterRepresentacao(Stream<T> veiculos) {
    return veiculos.map(e -> e.toString());
  }

  public <T> List<T> obterLista(Stream<T> veiculos) {
    return veiculos.collect(Collectors.toList());
  }
}
