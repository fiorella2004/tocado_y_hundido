package org.game;

import java.util.ArrayList;
import java.util.List;

public class JugadorIA extends Jugador{

  public JugadorIA(String nombre) {
    super(nombre);
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco) {
      return true;
  }

  @Override
  public void recibirGolpe(Coordenada coordenada) {

  }

  @Override
  public void registrarGolpe(Coordenada coordenada, Tablero tableroPrincipalOponente) {

  }
}


