package com.trybe.acc.java.jogodasfazendas;

public class Rectangle extends Polygon implements Farm {
  Rectangle(double base, double height) {
    super(base, height);
  }

  public double area() {
    return super.base * super.height;
  }
}
