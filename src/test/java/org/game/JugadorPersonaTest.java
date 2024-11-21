package org.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JugadorPersonaTest {

  @Test
  void testAsignarNombre_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname", mockTablero, mockTablero);

    // Act
    jugador.asignarNombre("Fiorella");

    // Assert
    assertEquals("Fiorella", jugador.getNombre());
  }

  @Test
  void recibirGolpe_expectedTrue() {
    // Arrange
    MockTablero mockTableroPrincipal = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname", mockTableroPrincipal, mockTableroPrincipal);
    Coordenada coordenada = new Coordenada(1,1);

    // Act
    jugador.recibirGolpe(coordenada);
    Casilla casillaGolpeada = mockTableroPrincipal.buscarCasilla(coordenada);
    boolean resultado = casillaGolpeada.esGolpeada();

    // Assert
    assertTrue(resultado);
  }

  @Test
  void recibirGolpe_expectedFalse() {
    // Arrange
    MockTablero mockTableroPrincipal = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname", mockTableroPrincipal, mockTableroPrincipal);
    Coordenada coordenada = new Coordenada(16,16);

    // Act
    boolean resultado = jugador.recibirGolpe(coordenada);

    // Assert
    assertTrue(resultado);
  }

  @Test
  void testObtenerTableroPrincipal_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname", mockTablero, mockTablero);

    // Act
    boolean resultado = jugador.obtenerTableroPrincipal() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  void testObtenerTableroSecundario_expectedTrue() {
    // Arrange
    MockTablero mockTableroPrincipal = new MockTablero(10, true);
    MockTablero mockTableroSecundario = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname", mockTableroPrincipal, mockTableroSecundario);

    // Act
    boolean resultado = jugador.obtenerTableroSecundario() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  void testColocarBarcos_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname", mockTablero, mockTablero);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(5, 6));
    coordenadasBarco.add(new Coordenada(5, 6));

    // Act
    boolean resultado = jugador.colocarBarcos(coordenadasBarco);

    // Assert
    assertTrue(resultado);
  }

  @Test
  void testColocarBarcos_expectedFalse() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, false);
    Jugador jugador = new JugadorPersona("noname", mockTablero, mockTablero);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(5, 6));
    coordenadas.add(new Coordenada(5, 6));

    // Act
    boolean resultado = jugador.colocarBarcos(coordenadas);

    // Assert
    assertFalse(resultado);
  }

  @Test
  void testComprobarBarcosHundidos_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname", mockTablero, mockTablero);

    // Act
    boolean resultado = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultado);
  }

  @Test
  void testComprobarBarcosHundidos_expectedFalse() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, false);
    Jugador jugador = new JugadorPersona("noname", mockTablero, mockTablero);

    // Act
    boolean resultado = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertFalse(resultado);
  }


}