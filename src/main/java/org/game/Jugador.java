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

  public void asignarTablerosVacios(int numFilas, int numColumnas){
    tableroPrincipal = new Tablero(numFilas, numColumnas);
    tableroSecundario = new Tablero(numFilas, numColumnas);
  }

  public Tablero obtenerTableroPrincipal() {return tableroPrincipal;}

  public Tablero obtenerTableroSecundario() {return tableroSecundario;}

  public boolean comprovarTodosBarcosHundidos() {return tableroPrincipal.comprobarTodosBarcosHundidos();}

  public abstract void colocarBarcos(ArrayList<Coordenada> casillasBarco);

  public abstract void recibirGolpe(Coordenada coordenada);
}