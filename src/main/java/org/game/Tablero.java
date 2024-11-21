package org.game;

import java.util.ArrayList;

public class Tablero {
  private ArrayList<Casilla> tablero = new ArrayList<>();
  private int idBarco = 1;
  private int numFilas;
  private int numCols;

  public Tablero(int dimension) {
    dimension = comprobarDimension(dimension);
    this.numFilas = dimension;
    this.numCols = dimension;
    for (int fila = 0; fila < this.numFilas; fila++) {
      for (int col = 0; col < this.numCols; col++) {
        tablero.add(new Agua(new Coordenada(fila, col)));
      }
    }
  }

  public int comprobarDimension(int dimension) {
    int dimensionAux;
    if (dimension <= 10) {
      dimensionAux = 10;
      return dimensionAux;
    } else if (dimension >= 15) {
      dimensionAux = 15;
      return dimensionAux;
    }
    return dimension;
  }

  public int getNumFilas() {
    return numFilas;
  }

  public int getNumCol() {
    return numCols;
  }

  public ArrayList<Casilla> obtenerTablero() {
    return tablero;
  }

  public boolean colocarBarco(ArrayList<Coordenada> coordenadas) {
    if (!comprobarBarcoDentroTablero(coordenadas) || !comprobarSolaparBarco(coordenadas)) {
      return false;
    }
    for (Coordenada coordenada : coordenadas) {
      for (int i = 0; i < tablero.size(); i++) {
        Casilla casilla = tablero.get(i);
        Coordenada coordenadaCasilla = casilla.obtenerCoordenada();
        if (coordenadaCasilla.equals(coordenada)) {
          tablero.set(i, new Barco(coordenadaCasilla));
          tablero.get(i).setId(idBarco);
        }
      }
    }
    idBarco++;
    return true;
  }

  public boolean comprobarSolaparBarco(ArrayList<Coordenada> coordenadas) {
    for (Coordenada coordenada : coordenadas) {
      for (Casilla casilla : tablero) {
        Coordenada coordenadaCasilla = casilla.obtenerCoordenada();
        if (coordenadaCasilla.equals(coordenada)) {
          if (casilla.getId() != 0)
            return false;
        }
      }
    }
    return true;
  }

  public boolean comprobarBarcoDentroTablero(ArrayList<Coordenada> coordenadas) {
    for (Coordenada coordenada : coordenadas) {
      if (coordenada.getFila() >= numFilas || coordenada.getFila() < 0 ||
          coordenada.getCol() >= numCols || coordenada.getCol() < 0) {
        return false;
      }
    }
    return true;
  }

  public boolean recibirGolpe(Coordenada coordenada) {
    Casilla casillaGolpeada = buscarCasilla(coordenada);

    if (casillaGolpeada != null) {
      casillaGolpeada.recibirGolpe();
      return true;
    }
    return false;
  }

  public Casilla buscarCasilla(Coordenada coordenada) {
    for (Casilla casilla : tablero) {
      Coordenada coordenadaCasilla = casilla.obtenerCoordenada();
      if (coordenadaCasilla.equals(coordenada)) {
        return casilla;
      }
    }
    return null;
  }

  public boolean comprobarTodosBarcosHundidos() {
    for (Casilla casilla : tablero) {
      if (casilla.getId() != 0 && !casilla.esGolpeada()) {
        return false;
      }
    }
    return true;
  }
}
