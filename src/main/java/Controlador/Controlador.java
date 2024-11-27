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

      if (dimensionTablero == 10) {
        if (coordenada.length() != 2) {
          return false;
        }
      } else {
        if (coordenada.length() != 3) {
          return false;
        }
      }

      char[] caracteres = coordenada.toCharArray();
      if(dimensionTablero == 10){
        char filaChar = caracteres[0];
        char columna = caracteres[1];
        if (!Character.isDigit(filaChar)) {
          return false;
        }

        int filaNum = Character.getNumericValue(filaChar);
        if (filaNum < 0 || filaNum >= limiteFila && columna <= 'A' || columna >= limiteColumna) {
          return false;
        }
      }
      else{

        if(coordenada.length() == 2){
          char filaChar = caracteres[0];
          char columna = caracteres[1];
          if (!Character.isDigit(filaChar)) {
            return false;
          }

          int filaNum = Character.getNumericValue(filaChar);
          if (filaNum < 0 || filaNum >= limiteFila && columna <= 'A' || columna >= limiteColumna) {
            return false;
          }
        }
        else{
          char filaChar1 = caracteres[0];
          char filaChar2 = caracteres[1];
          char columna = caracteres[2];

          if (!Character.isDigit(filaChar1)) {
            return false;
          }
          if (!Character.isDigit(filaChar2)) {
            return false;
          }
          int filaNum1 = Character.getNumericValue(filaChar1);
          int filaNum2 = Character.getNumericValue(filaChar2);
          int filaNum = filaNum1 + filaNum2;

          if (filaNum < 0 || filaNum > limiteFila && columna < 'A' || columna > limiteColumna) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public void colocarBarcosJugadorPersona() {
    //llamar a comprobar formato coordenadas
  }
}
