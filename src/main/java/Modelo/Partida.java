package Modelo;

import java.util.ArrayList;

public class Partida {
  private JugadorPersona jugadorPersona;
  private JugadorIA jugadorIA;
  private int turno = 1;
  private int dimensionTablero;
  private boolean finPartida;

  public Partida(JugadorPersona jugadorPersona, JugadorIA jugadorIA) {
    this.jugadorPersona = jugadorPersona;
    this.jugadorIA = jugadorIA;
    finPartida = false;
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
    this.dimensionTablero = dimension;
    crearTablero(dimension);
  }

  private void crearTablero(int dimension) {
    jugadorPersona.asignarTablerosVacios(dimension);
    jugadorIA.asignarTablerosVacios(dimension);
  }

  public boolean colocarBarcoJugador(ArrayList<Coordenada> coordenadas, int dimensionBarco) {
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
    if (jugador1Perdido || jugador2Perdido) {
      return true;
    }
    return false;
  }
}
