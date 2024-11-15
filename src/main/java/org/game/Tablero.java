package org.game;

import java.util.ArrayList;

public class Tablero {
  private ArrayList<Casilla> tablero = new ArrayList<>();
  private int idBarco = 1;
  private int numFilas;
  private int numCols;

  public Tablero(int dimension) {

    dimension = comprobarDimension(dimension);

    this.numFilas = dimension;
    this.numCols = dimension;


    for (int fila = 0; fila < this.numFilas; fila++) {
      for (int col = 0; col < this.numCols; col++) {
        tablero.add(new Agua(new Coordenada(fila, col)));
      }
    }
  }

  public int comprobarDimension(int dimension) {

    int dimensionAux;

    if (dimension < 10) {
      dimensionAux = 10;
      return dimensionAux;
    } else if (dimension > 15) {
      dimensionAux = 15;
      return dimensionAux;
    }

    return dimension;
  }

  public void setDimension(int dimension) {
  }

  public int getNumFilas() {
    return numFilas;
  }

  public int getNumCol() {
    return numCols;
  }

  public ArrayList<Casilla> obtenerTablero() {
    return tablero;
  }
}
