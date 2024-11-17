package org.game;

import java.util.ArrayList;

public class Jugador {
  private String nombre;
  private Tablero tableroPrincipal;
  private Tablero tableroSecundario;

  public Jugador(String nombre, Tablero tableroPrincipal, Tablero tableroSecundario) {
    this.nombre = nombre;
    this.tableroPrincipal = tableroPrincipal;
    this.tableroSecundario = tableroSecundario;
  }

  public void asignarNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public Tablero obtenerTableroPrincipal() {
    return tableroPrincipal;
  }

  public Tablero obtenerTableroSecundario() {
    return tableroSecundario;
  }

  public boolean colocarBarcos(ArrayList<Coordenada> casillasBarco) {

  }

  public void recibirGolpe(Coordenada coordenada) {

  }
}