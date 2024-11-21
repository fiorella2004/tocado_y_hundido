package org.game;

import java.util.ArrayList;

public abstract class Jugador {
  protected String nombre;
  protected Tablero tableroPrincipal;
  protected Tablero tableroSecundario;

  public Jugador(String nombre) {
    this.nombre = nombre;
  }

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

  public void asignarTablerosVacios(int numFilas, int numColumnas) {
    tableroPrincipal = new Tablero(numFilas, numColumnas);
    tableroSecundario = new Tablero(numFilas, numColumnas);
  }

  public Tablero obtenerTableroPrincipal() {
    return tableroPrincipal;
  }

  public Tablero obtenerTableroSecundario() {
    return tableroSecundario;
  }

  public boolean comprobarTodosBarcosHundidos() {
    return tableroPrincipal.comprobarTodosBarcosHundidos();
  }

  public abstract void colocarBarco(ArrayList<Coordenada> casillasBarco);

  public abstract void recibirGolpe(Coordenada coordenada);

  public abstract void registrarGolpe(Coordenada coordenada, Tablero tableroPrincipalOponent);

  public void adaptarTableroSecundario(Coordenada coordenada, Tablero tablePrincipalOponente) {

  }
}