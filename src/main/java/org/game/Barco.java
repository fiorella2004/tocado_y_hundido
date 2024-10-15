package org.game;

public class Barco extends Casilla {

  char barcoDibujo = '⚪';

  Barco(int fila, char col) {
    super(fila, col);
    if (fila < 1 || fila > 10) {
      throw new IllegalArgumentException("La fila debe estar entre 1 y 10.");
    }
    if (col < 'A' || col > 'J') {
      throw new IllegalArgumentException("La columna debe estar entre 'A' y 'J'.");
    }
  }

  @Override
  public boolean esGolpeada() {
    return golpeada;
  }

  @Override
  public void recibirGolpe() {
    golpeada = true;
    barcoDibujo = '⚫';
  }

  @Override
  public void printCasilla() {
    System.out.print(barcoDibujo);
  }
}