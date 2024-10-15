package org.game;

public class Agua extends Casilla{

  char aguaDibujo;

  Agua(int fila, char col) {super(fila, col);}

  @Override
  public boolean esGolpeada() {return golpeada;}

  @Override
  public void recibirGolpe() {};

  @Override
  public void printCasilla() {};
}
