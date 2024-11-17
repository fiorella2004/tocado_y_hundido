package org.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

  @Test
  void testAsignarNombre_expectedTrue() {
    // Arrange
    MockTablero mockTablero1 = new MockTablero(5);
    MockTablero mockTablero2 = new MockTablero(5);
    Jugador jugador = new Jugador("noname", mockTablero1, mockTablero2);

    // Act
    jugador.asignarNombre("Fiorella");

    // Assert
    assertEquals("Fiorella", jugador.getNombre());
  }


}
