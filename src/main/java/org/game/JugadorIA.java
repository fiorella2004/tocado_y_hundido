package org.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JugadorIA extends Jugador {
  public Random random;

  public JugadorIA(String nombre, Random random) {
    super(nombre);
    this.random = random;
  }

  public JugadorIA(String nombre) {
    super(nombre);
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco) {
    boolean barcoColocado;
    int fila = generarCoordenadaAleatoria();
    int col = generarCoordenadaAleatoria();
    int direccion = generarDireccionAleatoria();
    ArrayList<Coordenada> coordenadas = calcularCoordenadasBarco(fila, col, direccion, dimensionBarco);
    if (coordenadas != null) {
      barcoColocado = tableroPrincipal.colocarBarco(coordenadas);
    } else {
      barcoColocado = false;
    }
    return barcoColocado;
  }

  @Override
  public boolean recibirGolpe(Coordenada coordenada) {
    return tableroPrincipal.recibirGolpe(coordenada);
  }

  private int generarCoordenadaAleatoria() {
    return random.nextInt(10); //0-9
  }

  private int generarDireccionAleatoria() {
    return random.nextInt(4); //0-3
  }

  private ArrayList<Coordenada> calcularCoordenadasBarco(int fila, int col, int direccion, int dimensionBarco) {
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    for (int i = 0; i < dimensionBarco; i++) {
      int nuevaFila = fila;
      int nuevaCol = col;
      switch (direccion) {
        case 0: // Arriba
          nuevaFila = fila - i;
          break;
        case 1: // Abajo
          nuevaFila = fila + i;
          break;
        case 2: // Izquierda
          nuevaCol = col - i;
          break;
        case 3: // Derecha
          nuevaCol = col + i;
          break;
      }
      if (nuevaFila < 0 || nuevaFila > 9 || nuevaCol < 0 || nuevaCol > 9) {
        return null;
      }
      coordenadas.add(new Coordenada(nuevaFila, nuevaCol));
    }
    return coordenadas;
  }

  public Coordenada golpear() {
    boolean coordenadaValida = false;
    Coordenada coordenadaAGolpear = new Coordenada(0, 0);
    while(!coordenadaValida){
      int fila = generarCoordenadaAleatoria();
      int col = generarCoordenadaAleatoria();
      if (fila >= 0 && fila <= 9 && col >= 0 && col <= 9) {
        coordenadaAGolpear.setCol(col);
        coordenadaAGolpear.setFila(fila);
        Casilla casilla = tableroSecundario.buscarCasilla(coordenadaAGolpear);
        if (casilla != null) {
          if (!casilla.esGolpeada()) {
            coordenadaValida = true;
          }
        }
      }
    }
    return coordenadaAGolpear;
  }
}


