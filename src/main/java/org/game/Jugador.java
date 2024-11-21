package org.game;

import java.util.ArrayList;

public abstract class Jugador {
  protected String nombre;
  protected Tablero tableroPrincipal;
  protected Tablero tableroSecundario;

  public Jugador(String nombre) {
    this.nombre = nombre;
  }

  public void asignarNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return nombre;
  }

  public void asignarTablerosVacios(int dimension) {
    tableroPrincipal = new Tablero(dimension);
    tableroSecundario = new Tablero(dimension);
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

  public void adaptarTableroSecundario(Coordenada coordenada, Tablero tableroPrincipalOponente) {
    ArrayList<Coordenada> coordenadaGolpeada = new ArrayList<>();
    Casilla casillaGolpeada = tableroPrincipalOponente.buscarCasilla(coordenada);
    Coordenada coordGolpeada = casillaGolpeada.obtenerCoordenada();
    coordenadaGolpeada.add(coordGolpeada);
    if (casillaGolpeada.getId() != 0) { // hay un barco en la casilla
      tableroSecundario.colocarBarco(coordenadaGolpeada);
    }
  }
}