package Controlador;

import Modelo.*;
import Vista.VistaConsola;
import java.util.ArrayList;

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
      if (!validarLongitudCoordenada(coordenada)) {
        return false;
      }
      char[] caracteres = coordenada.toCharArray();
      if (dimensionTablero == 10) {
        if (!validarCoordenada2Caracteres(caracteres, limiteFila, limiteColumna)) {
          return false;
        }
      } else {
        if (coordenada.length() == 2) {
          if (!validarCoordenada2Caracteres(caracteres, limiteFila, limiteColumna)) {
            return false;
          }
        } else {
          if (!validarCoordenada3Caracteres(caracteres, limiteFila, limiteColumna)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean validarLongitudCoordenada(String coordenada) {
    if (dimensionTablero == 10) {
      return coordenada.length() == 2;
    } else {
      return coordenada.length() == 3;
    }
  }

  private boolean validarCoordenada2Caracteres(char[] caracteres, int limiteFila, char limiteColumna) {
    char filaChar = caracteres[0];
    char columna = caracteres[1];
    if (!Character.isDigit(filaChar)) {
      return false;
    }
    int filaNum = Character.getNumericValue(filaChar);
    if (filaNum < 0 || filaNum >= limiteFila) {
      return false;
    }
    if (columna < 'A' || columna >= limiteColumna) {
      return false;
    }
    return true;
  }

  private boolean validarCoordenada3Caracteres(char[] caracteres, int limiteFila, char limiteColumna) {
    char filaChar1 = caracteres[0];
    char filaChar2 = caracteres[1];
    char columna = caracteres[2];
    if (!Character.isDigit(filaChar1) || !Character.isDigit(filaChar2)) {
      return false;
    }
    int filaNum1 = Character.getNumericValue(filaChar1);
    int filaNum2 = Character.getNumericValue(filaChar2);
    int filaNum = filaNum1 * 10 + filaNum2;
    if (filaNum < 0 || filaNum > limiteFila) {
      return false;
    }
    if (columna < 'A' || columna > limiteColumna) {
      return false;
    }
    return true;
  }

  public Coordenada parsearCoordenada(String coordenada) {

  }

  public void colocarBarcosJugadorPersona() {
    
  }
}
