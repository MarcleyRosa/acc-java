package com.trybe.acc.java.anobissexto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnoBissexto {

  /**
   * verifica se um ano é bissexto.
   */
  public boolean identificarAnoBissexto(int ano) {
    if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * verifica qual proximo ano bissexto.
   * 
   * @param data de inicio.
   */
  public int identificarProximoAnoBissexto(String data) {
    DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate formatData = LocalDate.parse(data, formater);
    for (int index = 0; index < 4; index++) {
      System.out.println(this.identificarAnoBissexto(formatData.getYear()));
      if (this.identificarAnoBissexto(formatData.plusYears(index).getYear())) {
        return formatData.plusYears(index).getYear();
      }
    }
    return formatData.getYear();
  }
}
