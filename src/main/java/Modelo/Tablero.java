package Modelo;

import java.util.ArrayList;

public class Tablero {
  private ArrayList<Casilla> tablero = new ArrayList<>();
  private int idBarco = 1; // Identificador único para cada barco
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

  public boolean colocarBarco(ArrayList<Coordenada> coordenadas, int dimensionBarco) {
    if (!comprobarBarcoDentroTablero(coordenadas) || !comprobarSolaparBarco(coordenadas) ||
        !comprobarCoordenadasContiguas(coordenadas, dimensionBarco)) {
      return false;
    }
    for (Coordenada coordenada : coordenadas) {
      for (int i = 0; i < tablero.size(); i++) {
        Casilla casilla = tablero.get(i);
        Coordenada coordenadaCasilla = casilla.obtenerCoordenada();
        if (coordenadaCasilla.equals(coordenada)) {
          // Cambiar la casilla de agua a una casilla de barco
          tablero.set(i, new Barco(coordenadaCasilla));
          tablero.get(i).setId(idBarco);
        }
      }
    }
    idBarco++;
    return true;
  }

  private boolean comprobarSolaparBarco(ArrayList<Coordenada> coordenadas) {
    // Verificar si el barco se solapa con otro ya colocado en el tablero
    for (Coordenada coordenada : coordenadas) {
      for (Casilla casilla : tablero) {
        Coordenada coordenadaCasilla = casilla.obtenerCoordenada();
        if (coordenadaCasilla.equals(coordenada)) {
          if (casilla.getId() != 0) // Si la casilla ya tiene un barco, no se puede colocar otro
            return false;
        }
      }
    }
    return true;
  }

  private boolean comprobarBarcoDentroTablero(ArrayList<Coordenada> coordenadas) {
    // Verificar si todas las coordenadas del barco están dentro del tablero
    for (Coordenada coordenada : coordenadas) {
      if (coordenada.getFila() >= numFilas || coordenada.getFila() < 0 ||
          coordenada.getCol() >= numCols || coordenada.getCol() < 0) {
        return false;
      }
    }
    return true;
  }

  private boolean comprobarCoordenadasContiguas(ArrayList<Coordenada> coordenadas, int dimensionBarco) {
    if (coordenadas.size() != dimensionBarco) {
      return false;
    }
    // Recorrer las coordenadas y verificar si cada par de coordenadas es adyacente
    for (int i = 1; i < coordenadas.size(); i++) {
      Coordenada anterior = coordenadas.get(i - 1);
      Coordenada actual = coordenadas.get(i);
      boolean esAdyacente = (anterior.getFila() == actual.getFila() && Math.abs(anterior.getCol() - actual.getCol()) == 1) ||
          (anterior.getCol() == actual.getCol() && Math.abs(anterior.getFila() - actual.getFila()) == 1);
      if (!esAdyacente) {
        return false;
      }
    }
    return true;
  }

  public boolean recibirGolpe(Coordenada coordenada) {
    // Simula el golpe recibido en una coordenada específica
    Casilla casillaGolpeada = buscarCasilla(coordenada);
    if (casillaGolpeada != null && !casillaGolpeada.esGolpeada()) {
      casillaGolpeada.recibirGolpe();
      return true;
    }
    return false; // La casilla ya estaba golpeada o no existe
  }

  public Casilla buscarCasilla(Coordenada coordenada) {
    for (Casilla casilla : tablero) {
      Coordenada coordenadaCasilla = casilla.obtenerCoordenada();
      if (coordenadaCasilla.equals(coordenada)) {
        return casilla; // Si existe la casilla que se busca
      }
    }
    return null;
  }

  public boolean comprobarTodosBarcosHundidos() {
    for (Casilla casilla : tablero) {
      if (casilla.getId() != 0 && !casilla.esGolpeada()) {
        return false; // Si existe algún barco que no ha sido golpeado
      }
    }
    return true; // Todos los barcos han sido hundidos
  }
}
