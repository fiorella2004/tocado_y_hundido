package org.game;

import java.util.ArrayList;
import java.util.List;

public class JugadorIA extends Jugador{

  public JugadorIA(String nombre, Tablero tableroPrincipal, Tablero tableroSecundario) {
    super(nombre, tableroPrincipal, tableroSecundario);
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco) {
    return true;
  }

  @Override
  public boolean recibirGolpe(Coordenada coordenada) {
    return true;
  }
}


