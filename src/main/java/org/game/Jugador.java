package org.game;

import java.util.ArrayList;

public abstract class Jugador {
  protected String nombre;
  protected Tablero tableroPrincipal;
  protected Tablero tableroSecundario;

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

  public Tablero obtenerTableroPrincipal() {return tableroPrincipal;}

  public Tablero obtenerTableroSecundario() {return tableroSecundario;}

  public boolean comprobarTodosBarcosHundidos() {return tableroPrincipal.comprobarTodosBarcosHundidos();}

  public abstract boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco);

  public abstract boolean recibirGolpe(Coordenada coordenada);
}