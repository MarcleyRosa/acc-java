package com.trybe.acc.java.sistemarh;

public class PessoaColaboradora {
  private double salarioBruto;

  public double calcularSalarioLiquido() {
    return this.salarioBruto - this.salarioBruto * 20 / 100;
  }

  public double calcularValorBrutoRecebidoAnual(int ano) {
    return (this.salarioBruto * 12) * ano;
  }

  public double calcularValorLiquidoRecebidoAnual(int ano) {
    return ((this.salarioBruto - this.salarioBruto * 20 / 100) * 12) * ano;
  }

  public double calcularValorImpostoAnual(int ano) {
    return ((this.salarioBruto * 20 / 100) * 12) * ano;
  }

  public double getSalarioBruto() {
    return this.salarioBruto;
  }

  public void setSalarioBruto(double salarioBruto) {
    this.salarioBruto = salarioBruto;
  }

}
