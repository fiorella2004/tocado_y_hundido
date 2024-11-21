package org.game;

import java.util.ArrayList;

public class JugadorPersona extends Jugador {

  public JugadorPersona(String nombre) {
    super(nombre);
  }

  @Override
  public void colocarBarco(ArrayList<Coordenada> casillasBarco) {
    tableroPrincipal.colocarBarco(casillasBarco);
  }

  @Override
  public void recibirGolpe(Coordenada coordenada) {
    tableroPrincipal.recibirGolpe(coordenada);
  }

  @Override
  public void registrarGolpe(Coordenada coordenada, Tablero tableroPrincipalOponente) {
    adaptarTableroSecundario(coordenada, tableroPrincipalOponente);
    tableroSecundario.recibirGolpe(coordenada);
  }
}
