package org.game;

public class Agua extends Casilla{

  char aguaDibujo = '⬜';

  Agua(int fila, char col) {

    super(fila, col);

    if (fila < 1 || fila > 10) {
      throw new IllegalArgumentException("La fila debe estar entre 1 y 10.");
    }
    if (col < 'A' || col > 'J') {
      throw new IllegalArgumentException("La columna debe estar entre 'A' y 'J'.");
    }

  }

  @Override
  public boolean esGolpeada()
  {
    return golpeada;
  }

  @Override
  public void recibirGolpe()
  {
    golpeada = true;
    aguaDibujo = '☒';
  }

  @Override
  public void printCasilla()
  {
    System.out.print(aguaDibujo);
  }
}