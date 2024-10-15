package org.game;

public abstract class Casilla {

  public int fila;
  public char columna;
  boolean golpeada;

  Casilla(int fila, char col)
  {
    this.fila = fila;
    this.columna = col;
    golpeada = false;
  }

  public abstract boolean esGolpeada();
  public abstract void recibirGolpe();
  public abstract void printCasilla();
}
