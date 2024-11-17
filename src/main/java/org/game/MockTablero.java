package org.game;

import java.util.ArrayList;

public class MockTablero extends Tablero {
  private boolean resultado;

  public MockTablero(int dimension, boolean resultado) {
    super(dimension);
    this.resultado = resultado;
  }

  public boolean colocarBarco(ArrayList<Coordenada> coordenadas) {
    return resultado;
  }

  public boolean comprobarTodosBarcosHundidos() {
    return resultado;
  }
}