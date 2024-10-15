package org.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AguaTest {

  @Test
  public void testConstructor_filaFueraDeRango_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Agua(11, 'A');});

    // Assert
    assertEquals("La fila debe estar entre 1 y 10.", exception.getMessage());
  }

  @Test
  public void testConstructor_columnaFueraDeRango_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Agua(1, 'K');});

    // Assert
    assertEquals("La columna debe estar entre 'A' y 'J'.", exception.getMessage());
  }

  @Test
  public void testConstructor_filaNegativa_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Agua(-1, 'A');});

    // Assert
    assertEquals("La fila debe estar entre 1 y 10.", exception.getMessage());
  }

  @Test
  public void testConstructor_columnaNegativa_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Agua(1, '`');});

    // Assert
    assertEquals("La columna debe estar entre 'A' y 'J'.", exception.getMessage());
  }

  @Test
  public void testEsGolpeada_expectedFalse() {
    // Arrange
    Agua agua = new Agua(1, 'A');

    // Act
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertFalse(golpeada);
    assertEquals(agua.aguaDibujo, '⬜' );
  }

  @Test
  public void testRecibirGolpe_expectedTrue() {
    // Arrange
    Agua agua = new Agua(1, 'A');

    // Act
    agua.recibirGolpe();
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertTrue(golpeada);
    assertEquals(agua.aguaDibujo, '☒' );
  }

  @Test
  public void testRecibirVariosGolpes_expectedTrue() {
    // Arrange
    Agua agua = new Agua(1, 'A');

    // Act
    agua.recibirGolpe();
    agua.recibirGolpe();
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertTrue(golpeada);
    assertEquals(agua.aguaDibujo, '☒' );
  }
}

