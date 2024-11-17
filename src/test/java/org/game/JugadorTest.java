package org.game;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

  @Test
  void testAsignarNombre_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new Jugador("noname", mockTablero, mockTablero);

    // Act
    jugador.asignarNombre("Fiorella");

    // Assert
    assertEquals("Fiorella", jugador.getNombre());
  }

  @Test
  void testObtenerTableroPrincipal_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new Jugador("noname", mockTablero, mockTablero);

    // Act
    resultado = jugador.obtenerTableroPrincipal() instanceof MockTablero;

    //Assert
    assertTrue(resultado);
  }

  @Test
  void testObtenerTableroSecundario_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new Jugador("noname", mockTablero, mockTablero);

    // Act
    resultado = jugador.obtenerTableroSecundario() instanceof MockTablero;

    //Assert
    assertTrue(resultado);
  }

  @Test
  void testColocarBarcos_expectedTrue() {
    // Arrange
    MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new Jugador("noname", mockTablero, mockTablero);
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
    Jugador jugador = new Jugador("noname", mockTablero, mockTablero);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(5, 6));
    coordenadas.add(new Coordenada(5, 6));

    // Act
    boolean resultado = jugador.colocarBarcos(coordenadas);

    // Assert
    assertFalse(resultado);
  }
}
