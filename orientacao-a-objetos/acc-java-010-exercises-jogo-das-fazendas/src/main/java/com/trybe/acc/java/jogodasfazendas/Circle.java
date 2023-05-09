package com.trybe.acc.java.jogodasfazendas;

public class Circle implements Farm {
  private static final double PI = 3.14;
  double radius;

  Circle(double raduis) {
    this.radius = raduis;
  }

  public double area() {
    return PI * (this.radius * this.radius);
  }
}
