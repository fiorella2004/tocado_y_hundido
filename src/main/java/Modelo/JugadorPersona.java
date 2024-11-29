package Modelo;

import java.util.ArrayList;

public class JugadorPersona extends Jugador {

  public JugadorPersona(String nombre) {
    super(nombre);
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco) {
    // Precondición
    assert casillasBarco != null : "las casillas del barco no pueden ser nulas";
    assert dimensionBarco >= 2 && dimensionBarco <= 5 :
        "la dimensión del tablero solo puede ser 2, 3, 4 o 5";

    return tableroPrincipal.colocarBarco(casillasBarco, dimensionBarco);
  }

  @Override
  public boolean recibirGolpe(Coordenada coordenada) {
    // Precondición
    assert coordenada != null : "la coordenada no puede ser nula";

    return tableroPrincipal.recibirGolpe(coordenada);
  }
}
