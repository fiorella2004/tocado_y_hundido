package Vista;

import Modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola {
  private Scanner scanner = new Scanner(System.in);
  private Partida partida;

  public VistaConsola() {
  }

  public void setPartida(Partida partida) {
    this.partida = partida;
  }


  public void mostrarMensajeInicioJuego() {
    System.out.println("Bienvenido/a al juego de Tocado y Hundido");
    System.out.println();
  }

  public void mostrarMensajeFinJuego() {
    System.out.println("Fin del juego");
    System.out.println();
  }

  public void mostrarMensajeTurnoIA() {
    System.out.println("Turno del oponente");
    System.out.println();
  }

  public int pedirDimensionTablero() {
    System.out.println("Indica qué medida de tablero deseas:\n");
    System.out.println("Opción 1: 10x10\n");
    System.out.println("Opción 2: 11x11\n");
    System.out.println("Opción 3: 12x12\n");
    System.out.println("Opción 4: 13x13\n");
    System.out.println("Opción 5: 14x14\n");
    System.out.println("Opción 6: 15x15\n");

    int opcionSeleccionada;

    while (true) {
      if (scanner.hasNextInt()) {
        opcionSeleccionada = scanner.nextInt();

        if (opcionSeleccionada >= 1 && opcionSeleccionada <= 6) {
          return convertirDimensionTablero(opcionSeleccionada);
        } else {
          System.out.println("Por favor, selecciona un número entre 1 y 6\n");
        }
      } else {
        System.out.println("Entrada inválida. Introduce un número\n");
        scanner.next();
      }
    }
  }

  public int convertirDimensionTablero(int opcionSeleccionada) {
    switch (opcionSeleccionada) {
      case 1:
        return 10;
      case 2:
        return 11;
      case 3:
        return 12;
      case 4:
        return 13;
      case 5:
        return 14;
      case 6:
        return 15;
    }
    return -1;
  }


  public String pedirColocarBarco(int dimensionBarco) {
    switch (dimensionBarco) {
      case 2:
        return pedirColocarBarco2casilla();
      case 3:
        return pedirColocarBarco3casilla();
      case 4:
        return pedirColocarBarco4casilla();
      case 5:
        return pedirColocarBarco5casilla();
    }
    return "null";
  }

  public String pedirColocarBarco2casilla() {
    System.out.println("Introduce las coordenadas del barco de 2 casillas (ejemplo: 1A 2A): ");
    return scanner.nextLine();
  }

  public String pedirColocarBarco3casilla() {
    System.out.println("Introduce las coordenadas del barco de 3 casillas (ejemplo: 1A 2A 3A): ");
    return scanner.nextLine();
  }

  public String pedirColocarBarco4casilla() {
    System.out.println("Introduce las coordenadas del barco de 4 casillas (ejemplo: 1A 2A 3A 4A): ");
    return scanner.nextLine();
  }

  public String pedirColocarBarco5casilla() {
    System.out.println("Introduce las coordenadas del barco de 5 casillas (ejemplo: 1A 2A 3A 4A 5A):");
    return scanner.nextLine();
  }

  public String pedirGolpe() {
    System.out.println("Introduce las coordenadas donde quieras lanzar un golpe (ejemplo: 1A):");
    return scanner.nextLine();
  }

  public void mostrarErrorColocarBarco() {
    System.out.println("Las coordenadas no se han introducido en el formato correcto\n");
  }

  public void mostrarTableros() {
    Jugador jugador = partida.getJugadorPersona();
    Tablero tableroPrincipal = jugador.obtenerTableroPrincipal();
    Tablero tableroSecundario = jugador.obtenerTableroSecundario();
    printTableros(tableroPrincipal.obtenerTablero(), tableroSecundario.obtenerTablero(),
        tableroSecundario.getNumFilas(), tableroSecundario.getNumCol());
  }

  private void printTableros(ArrayList<Casilla> tableroPrincipal, ArrayList<Casilla> tableroSecundario,
                             int filas, int columnas) {

    final String separadorLetras = "   ";
    System.out.println("           Tablero Principal                                  Tablero Secundario");

    System.out.print("    ");
    for (int col = 0; col < columnas; col++) {
      char columnaLetra = (char) ('A' + col);
      System.out.print(columnaLetra + separadorLetras);
    }

    System.out.print("|      ");
    for (int col = 0; col < columnas; col++) {
      char columnaLetra = (char) ('A' + col);
      System.out.print(columnaLetra + separadorLetras);
    }
    System.out.println();

    for (int fila = 0; fila < filas; fila++) {
      System.out.printf("%-3d", fila);
      for (int col = 0; col < columnas; col++) {
        Casilla casilla1 = tableroPrincipal.get(fila * columnas + col);
        System.out.print(casilla1.getDibujo() + "  ");
      }
      System.out.print("|   ");

      System.out.printf("%-3d", fila);
      for (int col = 0; col < columnas; col++) {
        Casilla casilla2 = tableroSecundario.get(fila * columnas + col);
        System.out.print(casilla2.getDibujo() + "  ");
      }
      System.out.println();
    }
  }
}
