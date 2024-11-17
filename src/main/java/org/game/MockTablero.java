package org.game;

import java.util.ArrayList;

public class MockTablero extends Tablero {
  private boolean colocarBarcoResult;

  public MockTablero(int dimension, boolean resultadoColocarBarco) {
    super(dimension);
    this.colocarBarcoResult = resultadoColocarBarco;
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> coordenadas) {
    return colocarBarcoResult;
  }
}