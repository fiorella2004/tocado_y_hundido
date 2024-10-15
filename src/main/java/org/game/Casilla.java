package org.game;

public abstract class Casilla {

  protected int fila;
  protected char columna;
  protected boolean golpeada;

  Casilla(int fila, char col)
  {
    this.fila = fila;
    this.columna = col;
    golpeada = false;
  }

  public abstract char getDibujo();
  public abstract boolean esGolpeada();
  public abstract void recibirGolpe();
  public abstract void printCasilla();

}
