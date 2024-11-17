package org.game;

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
}