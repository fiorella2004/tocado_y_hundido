package Controlador;

import Modelo.*;
import Vista.VistaConsola;

public class Controlador {
  private Partida partida;
  private VistaConsola vista;
  private JugadorPersona jugadorPersona;
  private JugadorIA jugadorIA;
  private int dimensionTablero;

  public Controlador(VistaConsola vista, Partida partida, JugadorPersona jugadorPersona, JugadorIA jugadorIA) {
    this.vista = vista;
    this.partida = partida;
    this.jugadorPersona = jugadorPersona;
    this.jugadorIA = jugadorIA;
    dimensionTablero = vista.pedirDimensionTablero();
    partida.setDimensionTablero(dimensionTablero);
    partida.colocarBarcosIA();
    vista.setPartida(this.partida);
    vista.mostrarTableros();
  }

  public Partida getPartida() {
    return partida;
  }

  public VistaConsola getVistaConsola() {
    return vista;
  }

  public JugadorPersona getJugadorPersona() {
    return jugadorPersona;
  }

  public JugadorIA getJugadorIA() {
    return jugadorIA;
  }

  public boolean comprobarFormatoCoordenadas(String coordenadasJugador, int casillasBarco) {
    String[] coordenadas = coordenadasJugador.split(" ");

    int numeroDeCasillasAColocar = coordenadas.length;
    if (numeroDeCasillasAColocar != casillasBarco) {
      return false;
    }

    int limiteFila = dimensionTablero;
    char limiteColumna = (char) ('A' + limiteFila);

    for (String coordenada : coordenadas) {
      char[] caracteres = coordenada.toCharArray();
      char filaChar = caracteres[0];
      char columna = caracteres[1];
      if (!Character.isDigit(filaChar)) {
        return false;
      }

      int filaNum = Character.getNumericValue(filaChar);
      if (filaNum <= 0 || filaNum >= limiteFila && columna <= 'A' || columna >= limiteColumna) {
        return false;
      }
    }
    return true;
  }

  public void colocarBarcosJugadorPersona() {
    //llamar a comprobar formato coordenadas
  }
}
