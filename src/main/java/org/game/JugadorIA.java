package org.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JugadorIA extends Jugador{
  public Random random;

  public JugadorIA(String nombre , Random random) {
    super(nombre);
    //this.random = random;
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco) {
    boolean barcoColocado = false;
    while (!barcoColocado) {
      int fila = generarCoordenadaAleatoria();
      int col = generarCoordenadaAleatoria();
      int direccion = generarDireccionAleatoria();
      ArrayList<Coordenada> coordenadas = calcularCoordenadasBarco(fila, col, direccion, dimensionBarco);
      if (coordenadas != null) {
        barcoColocado = tableroPrincipal.colocarBarco(coordenadas);
      }
    }
    return barcoColocado;
  }

  @Override
  public void recibirGolpe(Coordenada coordenada) {
    tableroPrincipal.recibirGolpe(coordenada);
  }

  private int generarCoordenadaAleatoria() {
    Random random = new Random();
    return random.nextInt(10); //0-9
  }

  private int generarDireccionAleatoria() {
    Random random = new Random();
    return random.nextInt(4) + 1;
  }

  private ArrayList<Coordenada> calcularCoordenadasBarco(int fila, int col, int direccion, int dimensionBarco) {
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    for (int i = 0; i < dimensionBarco; i++) {
      int nuevaFila = fila;
      int nuevaCol = col;
      switch (direccion) {
        case 1: // Arriba
          nuevaFila = fila - i;
          break;
        case 2: // Abajo
          nuevaFila = fila + i;
          break;
        case 3: // Izquierda
          nuevaCol = col - i;
          break;
        case 4: // Derecha
          nuevaCol = col + i;
          break;
      }
      if (nuevaFila <= 0 || nuevaFila >= 10 || nuevaCol <= 0 || nuevaCol >= 10) {
        return null;
      }
      coordenadas.add(new Coordenada(nuevaFila, nuevaCol));
    }
    return coordenadas;
  }

  public Coordenada golpear(){
    int fila = generarCoordenadaAleatoria();
    int col = generarCoordenadaAleatoria();
    Coordenada coordenadaAGolpear = new Coordenada(fila,col);
    return coordenadaAGolpear;
  }
}


