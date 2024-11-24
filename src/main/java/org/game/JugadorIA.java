package org.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JugadorIA extends Jugador{
  public Random random;

  public JugadorIA(String nombre, Random random) {
    super(nombre);
    this.random = random;
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


