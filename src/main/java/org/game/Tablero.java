package org.game;

public class Tablero {
  private ArrayList<Casilla> tablero = new ArrayList<>();
  private int idBarco = 1;
  private int numFilas;
  private int numCols;

  public Tablero(int dimension){
  }

  public void setNumFilas(int filas) {this.numFilas = filas;}
  public void setNumCol(int cols) {this.numCols = cols;}
  public int getNumFilas() {return numFilas;}
  public int getNumCol() {return numCols;}
  public ArrayList<Casilla> obtenerTablero() {return tablero;}
}
