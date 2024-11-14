package org.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordenadaTest {

  @Test
  public void testConstructor_expectedTrue() {
    //Arrange
    Coordenada coordenada = new Coordenada(5, 6);

    //Assert
    assertEquals(5, coordenada.getFila());
    assertEquals(6, coordenada.getCol());
  }

  @Test
  void testEquals_expectedTrue() {
    // Arrange
    Coordenada coordenada1 = new Coordenada(5, 6);
    Coordenada coordenada2 = new Coordenada(5, 6);

    // Assert
    assertTrue(coordenada1.equals(coordenada2));
  }

  @Test
  void testEquals_expectedFalseRow() {
    // Arrange
    Coordenada coordenada1 = new Coordenada(5, 6);
    Coordenada coordenada2 = new Coordenada(1, 6);

    // Assert
    assertTrue(coordenada1.equals(coordenada2));
  }

  @Test
  void testEquals_expectedFalseCol() {
    // Arrange
    Coordenada coordenada1 = new Coordenada(5, 6);
    Coordenada coordenada2 = new Coordenada(5, 7);

    // Assert
    assertTrue(coordenada1.equals(coordenada2));
  }
}