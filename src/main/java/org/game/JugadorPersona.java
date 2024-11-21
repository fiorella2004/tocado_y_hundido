package org.game;

import java.util.ArrayList;

public class JugadorPersona extends Jugador{

  public JugadorPersona(String nombre, Tablero tableroPrincipal, Tablero tableroSecundario) {
    super(nombre, tableroPrincipal, tableroSecundario);
  }

  @Override
  public boolean colocarBarcos(ArrayList<Coordenada> casillasBarco) {
    return tableroPrincipal.colocarBarco(casillasBarco);
  }

  @Override
  public boolean recibirGolpe(Coordenada coordenada) {
    return tableroPrincipal.recibirGolpe(coordenada);
  }

}
