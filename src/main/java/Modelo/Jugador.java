package Modelo;

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

  public abstract boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco);

  public abstract boolean recibirGolpe(Coordenada coordenada);

  public void registrarGolpe(Coordenada coordenada, Tablero tableroPrincipalOponente) {
    adaptarTableroSecundario(coordenada, tableroPrincipalOponente);
    tableroSecundario.recibirGolpe(coordenada);
  }

  public void adaptarTableroSecundario(Coordenada coordenada, Tablero tableroPrincipalOponente) {
    ArrayList<Coordenada> coordenadasGolpeadas = new ArrayList<>();
    Casilla casillaGolpeada = tableroPrincipalOponente.buscarCasilla(coordenada);
    Coordenada coordGolpeada = casillaGolpeada.obtenerCoordenada();
    coordenadasGolpeadas.add(coordGolpeada);
    if (casillaGolpeada.getId() != 0) { // hay un barco en la casilla
      tableroSecundario.colocarBarco(coordenadasGolpeadas, 1); //solo se muestra 1 casilla
    }
  }
}