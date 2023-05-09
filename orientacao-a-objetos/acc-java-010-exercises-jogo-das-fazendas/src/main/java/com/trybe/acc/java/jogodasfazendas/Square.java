package com.trybe.acc.java.jogodasfazendas;

public class Square implements Farm {
  double side;

  Square(double side) {
    this.side = side;
  }

  public double area() {
    return this.side * this.side;
  }
}
