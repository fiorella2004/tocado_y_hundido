package org.game;

public class Tablero {
  private ArrayList<Casilla> tablero = new ArrayList<>();
  private int idBarco = 1;
  private final int numFilas;
  private final int numCol;

  public Tablero(int numFilas, int numCol){

  }

  public int getNumFilas() {return numFilas;}
  public int getNumCol() {return numCol;}
  public ArrayList<Casilla> obtenerTablero() {return tablero;}
}
