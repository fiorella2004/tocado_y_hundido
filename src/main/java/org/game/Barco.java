package org.game;

public class Barco extends Casilla {

  Barco(int fila, char col) {
    super(fila, col);
  }

  @Override
  public boolean esGolpeada() {
    return false;
  }

  @Override
  public void recibirGolpe() {

  }

  @Override
  public void printCasilla() {

  }
}