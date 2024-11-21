package org.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JugadorPersonaTest {

  @Test
  void testAsignarNombre_expectedTrue() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");

    // Act
    jugador.asignarNombre("Fiorella");

    // Assert
    assertEquals("Fiorella", jugador.getNombre());
  }

  @Test
  void recibirGolpe_expectedTrue() {
    // Arrange
    //MockTablero mockTableroPrincipal = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);
    Coordenada coordenada = new Coordenada(1, 1);

    // Act
    jugador.recibirGolpe(coordenada);
    Casilla casillaGolpeada = jugador.obtenerTableroPrincipal().buscarCasilla(coordenada);
    boolean resultado = casillaGolpeada.esGolpeada();

    // Assert
    assertTrue(resultado);
  }

  @Test
  void recibirGolpe_expectedFalse() {
    // Arrange
    //MockTablero mockTableroPrincipal = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);
    Coordenada coordenada = new Coordenada(16, 16);

    // Act
    jugador.recibirGolpe(coordenada);
    Casilla casillaGolpeada = jugador.obtenerTableroPrincipal().buscarCasilla(coordenada);
    boolean resultado = casillaGolpeada.esGolpeada();

    // Assert
    assertFalse(resultado);
  }

  @Test
  void testObtenerTableroPrincipal_expectedTrue() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);

    // Act
    boolean resultado = jugador.obtenerTableroPrincipal() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  void testObtenerTableroSecundario_expectedTrue() {
    // Arrange
    //MockTablero mockTableroPrincipal = new MockTablero(10, true);
    //MockTablero mockTableroSecundario = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);

    // Act
    boolean resultado = jugador.obtenerTableroSecundario() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  void testColocarBarcos_expectedTrue() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    coordenadasBarco.add(new Coordenada(2, 5));

    // Act
    jugador.colocarBarco(coordenadasBarco);

    // Assert
    Tablero tablero = jugador.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarco) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  void testColocarBarcos_expectedFalse() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, false);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(5, 6));
    coordenadasBarco.add(new Coordenada(5, 6));

    // Act
    jugador.colocarBarco(coordenadasBarco);

    // Assert
    Tablero tablero = jugador.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarco) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  void testComprobarBarcosHundidos_expectedTrue() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    coordenadasBarco.add(new Coordenada(2, 5));
    jugador.colocarBarco(coordenadasBarco);

    // Act
    jugador.recibirGolpe(new Coordenada(2, 3));
    jugador.recibirGolpe(new Coordenada(2, 4));
    jugador.recibirGolpe(new Coordenada(2, 5));
    boolean resultado = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultado);
  }

  @Test
  void testComprobarBarcosHundidos_expectedFalse() {
    // Arrange
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10, 10);

    ArrayList<Coordenada> coordenadasBarco1 = new ArrayList<>();
    coordenadasBarco1.add(new Coordenada(2, 3));
    coordenadasBarco1.add(new Coordenada(2, 4));
    coordenadasBarco1.add(new Coordenada(2, 5));
    jugador.colocarBarco(coordenadasBarco1);
    ArrayList<Coordenada> coordenadasBarco2 = new ArrayList<>();
    coordenadasBarco2.add(new Coordenada(4, 6));
    coordenadasBarco2.add(new Coordenada(4, 7));
    jugador.colocarBarco(coordenadasBarco2);

    // Act
    jugador.recibirGolpe(new Coordenada(2, 3));
    jugador.recibirGolpe(new Coordenada(2, 4));
    jugador.recibirGolpe(new Coordenada(2, 5));
    boolean resultado = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertFalse(resultado);
  }
}