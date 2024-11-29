package Modelo;

import java.util.ArrayList;

public abstract class Jugador {
  protected String nombre;
  protected Tablero tableroPrincipal; // Barcos del jugador
  protected Tablero tableroSecundario; // Registro de los ataques

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
    // Precondición
    assert dimension > 0 : "la dimensión del tablero debe ser mayor que 0";

    // Inicializa tableros vacíos con casillas de agua
    tableroPrincipal = new Tablero(dimension);
    tableroSecundario = new Tablero(dimension);

    // Postcondición
    assert tableroPrincipal != null : "el tablero principal no existe";
    assert tableroSecundario != null : "el tablero secundario no existe";
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
    // Precondición
    assert coordenada != null : "la coordenada no pueden ser nula";
    assert tableroPrincipalOponente != null : "el tablero principal del oponente no existe";

    // Registra un golpe en el tablero secundario tras atacar al oponente
    adaptarTableroSecundario(coordenada, tableroPrincipalOponente);
    // Marca la casilla correspondiente como golpeada
    tableroSecundario.recibirGolpe(coordenada);
  }

  public void adaptarTableroSecundario(Coordenada coordenada, Tablero tableroPrincipalOponente) {
    // Precondición
    assert coordenada != null : "la coordenada no puede ser nula";
    assert tableroPrincipalOponente != null : "el tablero principal del oponente no existe";

    // Actualiza el tablero secundario según el resultado de un ataque al oponente
    ArrayList<Coordenada> coordenadasGolpeadas = new ArrayList<>();
    Casilla casillaGolpeada = tableroPrincipalOponente.buscarCasilla(coordenada);
    assert casillaGolpeada != null : "la casilla golpeada no puede ser null";
    Coordenada coordGolpeada = casillaGolpeada.obtenerCoordenada();
    coordenadasGolpeadas.add(coordGolpeada);
    if (casillaGolpeada.getId() != 0) { // Si la casilla contiene un barco
      tableroSecundario.colocarBarco(coordenadasGolpeadas, 1); // Solo se golpea 1 casilla
    }
  }
}