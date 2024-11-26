package org.game;

import java.util.ArrayList;

public class JugadorPersona extends Jugador {

  public JugadorPersona(String nombre) {
    super(nombre);
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco) {
    return tableroPrincipal.colocarBarco(casillasBarco);
  }

  @Override
  public void recibirGolpe(Coordenada coordenada) {
    tableroPrincipal.recibirGolpe(coordenada);
  }
}
