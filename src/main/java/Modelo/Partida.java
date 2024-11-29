package Modelo;

import java.util.ArrayList;

public class Partida {
  private JugadorPersona jugadorPersona;
  private JugadorIA jugadorIA;
  private int turno = 1;
  private int dimensionTablero;

  public Partida(JugadorPersona jugadorPersona, JugadorIA jugadorIA) {
    this.jugadorPersona = jugadorPersona;
    this.jugadorIA = jugadorIA;
  }

  public JugadorPersona getJugadorPersona() {
    return jugadorPersona;
  }

  public JugadorIA getjugadorIA() {
    return jugadorIA;
  }

  public int getDimensionTablero() {
    return dimensionTablero;
  }

  public void setDimensionTablero(int dimension) {
    // Precondición
    assert dimension > 0 : "la dimensión del barco debe ser mayor que 0";

    this.dimensionTablero = dimension;
    crearTablero(dimension);

    // Postcondición
    assert this.dimensionTablero == dimension : "la dimensión del tablero es incorrecta";
  }

  private void crearTablero(int dimension) {
    // Precondición
    assert dimension > 0 : "la dimensión del barco debe ser mayor que 0";

    jugadorPersona.asignarTablerosVacios(dimension);
    jugadorIA.asignarTablerosVacios(dimension);

    // Postcondición
    assert jugadorPersona.obtenerTableroPrincipal() == null : "el jugador persona no tiene tablero";
    assert jugadorIA.obtenerTableroPrincipal() == null : "el jugador IA no tiene tablero";
  }

  public boolean colocarBarcoJugador(ArrayList<Coordenada> coordenadas, int dimensionBarco) {
    // Precondición
    assert coordenadas != null : "las coordenadas no pueden ser nulas";
    assert dimensionBarco > 0 : "la dimensión del barco debe ser mayor que 0";

    return jugadorPersona.colocarBarco(coordenadas, dimensionBarco);
  }

  public void colocarBarcosIA() {
    int[] dimensionesBarcos = {2, 3, 3, 4, 5};
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 0));

    for (int dimension : dimensionesBarcos) {
      boolean barcoColocado = false;
      while (!barcoColocado) {
        barcoColocado = jugadorIA.colocarBarco(coordenadas, dimension);
      }
    }
  }

  public boolean golpeaJugadorPersona(Coordenada coordenada) {
    // Precondición
    assert coordenada != null : "las coordenadas no pueden ser nulas";

    boolean result = jugadorIA.recibirGolpe(coordenada);
    jugadorPersona.registrarGolpe(coordenada, jugadorIA.obtenerTableroPrincipal());
    return result;
  }

  public boolean golpeaJugadorIA() {
    Coordenada coordenada = jugadorIA.golpear();
    boolean result = jugadorPersona.recibirGolpe(coordenada);
    jugadorIA.registrarGolpe(coordenada, jugadorPersona.obtenerTableroPrincipal());
    return result;
  }

  public int obtenerTurno() {
    return turno;
  }

  public void cambiarTurno() {
    if (turno == 1)
      turno = 2;
    else
      turno = 1;
  }

  public boolean comprovarFinPartida() {
    boolean jugador1Perdido = jugadorPersona.comprobarTodosBarcosHundidos();
    boolean jugador2Perdido = jugadorIA.comprobarTodosBarcosHundidos();
    return jugador1Perdido || jugador2Perdido;
  }
}