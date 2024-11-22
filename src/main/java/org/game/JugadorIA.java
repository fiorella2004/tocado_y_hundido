package org.game;

import java.util.ArrayList;
import java.util.List;

public class JugadorIA extends Jugador{

  private List<Integer> barcos;

  public JugadorIA(String nombre, List<Integer> barcos) {
    super(nombre);
    this.barcos = barcos;
  }

  @Override
  public void colocarBarco(ArrayList<Coordenada> casillasBarco) {
    for (int dimensionBarco : barcos) {
      colocarBarcoAleatoriamente(dimensionBarco);
    }
  }

  public boolean colocarBarcoAleatoriamente(int dimensionBarco) {
    return true;
  }
}


