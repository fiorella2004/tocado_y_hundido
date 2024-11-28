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
    vista.mostrarMensajeInicioJuego();
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

  public boolean comprobarFormatoCoordenadas(String coordenadasJugador, int casillasTotales) {
    String[] coordenadas = coordenadasJugador.split(" ");
    int numeroDeCasillasAColocar = coordenadas.length;
    if (numeroDeCasillasAColocar != casillasTotales) {
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
      return (coordenada.length() == 2 || coordenada.length() == 3);
    }
  }

  private boolean validarCoordenada2Caracteres(char[] caracteres, int limiteFila, char limiteColumna) {
    char filaChar = caracteres[0];
    char columna = caracteres[1];
    if (!Character.isDigit(filaChar)) {
      return false;
    }
    int filaNum = Character.getNumericValue(filaChar);
    if (filaNum < 0 || filaNum >= limiteFila || columna < 'A' || columna >= limiteColumna) {
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
    if (filaNum < 0 || filaNum > limiteFila || columna < 'A' || columna > limiteColumna) {
      return false;
    }

    return true;
  }

  public Coordenada parsearCoordenada(String coordenada) {
    int fila = Integer.parseInt(coordenada.substring(0, coordenada.length() - 1));
    char columnaChar = coordenada.charAt(coordenada.length() - 1);
    int columna = columnaChar - 'A';
    return new Coordenada(fila, columna);
  }

  public void colocarBarcosJugadorPersona() {
    int[] dimensionesBarcos = {2, 3, 3, 4, 5};
    for (int dimension : dimensionesBarcos) {
      boolean barcoColocado = false;
      while (!barcoColocado) {
        String casillasBarcoString = vista.pedirColocarBarco(dimension);
        if (comprobarFormatoCoordenadas(casillasBarcoString, dimension)) {
          String[] coordenadas = casillasBarcoString.split(" ");
          ArrayList<Coordenada> casillasBarcoCoordenadas = new ArrayList<>();
          for (String coordenada : coordenadas) {
            Coordenada coord = parsearCoordenada(coordenada);
            casillasBarcoCoordenadas.add(coord);
          }
          barcoColocado = partida.colocarBarcoJugador(casillasBarcoCoordenadas, dimension);
          if (barcoColocado) {
            vista.mostrarTableros();
          } else {
            vista.mostrarErrorCoordenada();
          }
        } else {
          vista.mostrarErrorCoordenada();
        }
      }
    }
  }

  public void comenzarPartida() {
    while (!partida.comprovarFinPartida()) {
      if (partida.obtenerTurno() == 1) {
        turnoJugadorpersona();
      } else {
        turnoJugadorIA();
      }
      partida.cambiarTurno();
    }
    vista.mostrarMensajeFinJuego();
  }

  private void turnoJugadorpersona() {
    boolean golpeado = false;
    while (!golpeado) {
      String coordenadaGolpe = vista.pedirGolpe();
      if (comprobarFormatoCoordenadas(coordenadaGolpe, 1)) {
        Coordenada coordenadaAGolpear = parsearCoordenada(coordenadaGolpe);
        golpeado = partida.golpeaJugadorPersona(coordenadaAGolpear);
        if (!golpeado) {
          vista.mostrarErrorCoordenada();
        }
      } else {
        vista.mostrarErrorCoordenada();
      }
    }
    vista.mostrarTableros();
  }

  private void turnoJugadorIA() {
    vista.mostrarMensajeTurnoIA();
    partida.golpeaJugadorIA();
    vista.mostrarTableros();
  }
}
