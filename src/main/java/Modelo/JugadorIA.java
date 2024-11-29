package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class JugadorIA extends Jugador {
  public Random random;

  public JugadorIA(String nombre, Random random) {
    super(nombre);
    this.random = random;
  }

  public JugadorIA(String nombre) {
    super(nombre);
    random = new Random();
  }

  @Override
  public boolean colocarBarco(ArrayList<Coordenada> casillasBarco, int dimensionBarco) {
    // Precondición
    assert casillasBarco != null : "las casillas del barco no pueden ser nulas";
    assert dimensionBarco >= 2 && dimensionBarco <= 5 :
        "la dimensión del barco solo puede ser 2, 3, 4 o 5";

    boolean barcoColocado;
    int fila = generarCoordenadaAleatoria();
    int col = generarCoordenadaAleatoria();
    int direccion = generarDireccionAleatoria(); // Direccion del barco
    // Calculamos las coordenadas del barco según la primera
    // coordenada generada aleatoriamente y la dirección
    ArrayList<Coordenada> coordenadas = calcularCoordenadasBarco(
        fila, col, direccion, dimensionBarco);
    if (coordenadas != null) {
      barcoColocado = tableroPrincipal.colocarBarco(coordenadas, dimensionBarco);
    } else {
      barcoColocado = false;
    }
    return barcoColocado;
  }

  @Override
  public boolean recibirGolpe(Coordenada coordenada) {
    // Precondición
    assert coordenada != null : "la coordenada no puede ser nula";

    return tableroPrincipal.recibirGolpe(coordenada);
  }

  private int generarCoordenadaAleatoria() {
    return random.nextInt(10); //0-9
  }

  private int generarDireccionAleatoria() {
    return random.nextInt(4); //0-3
  }

  private ArrayList<Coordenada> calcularCoordenadasBarco(int fila, int col,
                                                         int direccion, int dimensionBarco) {
    // Precondición
    assert fila >= 0 && fila <= tableroPrincipal.getNumFilas() - 1 :
        "la fila debe estar entre 0 y dimensión tablero - 1";
    assert col >= 0 && col <= tableroPrincipal.getNumCol() - 1 :
        "la columna debe estar entre 0 y dimensión tablero - 1";
    assert direccion >= 0 && direccion <= 3 : "la dirección debe ser estar entre 0 y 3";
    assert dimensionBarco >= 2 && dimensionBarco <= 5 :
        "la dimensión del barco solo puede ser 2, 3, 4 o 5";

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
        default:
          break;
      }
      if (nuevaFila < 0 || nuevaFila > 9 || nuevaCol < 0 || nuevaCol > 9) {
        return null;
      }
      coordenadas.add(new Coordenada(nuevaFila, nuevaCol));
    }

    // Postcondición
    assert coordenadas.size() == dimensionBarco :
        "el número de coordenadas debe ser igual a la dimensión del barco";

    return coordenadas;
  }

  public Coordenada golpear() {
    boolean coordenadaValida = false;
    Coordenada coordenadaAGolpear = new Coordenada(0, 0);
    while (!coordenadaValida) {
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

    // Postcondición:
    assert coordenadaAGolpear.getFila() >= 0
        && coordenadaAGolpear.getFila() <= tableroPrincipal.getNumFilas() - 1 :
        "la fila debe estar entre 0 y dimensión tablero - 1";
    assert coordenadaAGolpear.getCol() >= 0
        && coordenadaAGolpear.getCol() <= tableroPrincipal.getNumCol() - 1 :
        "la columna debe estar entre 0 y dimensión tablero - 1";

    return coordenadaAGolpear;
  }
}


