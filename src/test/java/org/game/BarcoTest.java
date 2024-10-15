package org.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarcoTest {

  @Test
  public void testConstructor_filaFueraDeRango_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Barco(11, 'A');});

    // Assert
    assertEquals("La fila debe estar entre 1 y 10.", exception.getMessage());
  }

  @Test
  public void testConstructor_columnaFueraDeRango_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Barco(1, 'K');});

    // Assert
    assertEquals("La columna debe estar entre 'A' y 'J'.", exception.getMessage());
  }

  @Test
  public void testConstructor_filaNegativa_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Barco(-1, 'A');});

    // Assert
    assertEquals("La fila debe estar entre 1 y 10.", exception.getMessage());
  }

  @Test
  public void testConstructor_columnaNegativa_expectedException() {
    // Arrange
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Barco(1, '`');});

    // Assert
    assertEquals("La columna debe estar entre 'A' y 'J'.", exception.getMessage());
  }

  @Test
  public void testEsGolpeada_expectedFalse() {
    // Arrange
    Barco barco = new Barco(1, 'A');

    // Act
    boolean golpeada = barco.esGolpeada();

    // Assert
    assertFalse(golpeada);
  }

  @Test
  public void testRecibirGolpe_expectedTrue() {
    // Arrange
    Barco barco = new Barco(1, 'A');

    // Act
    barco.recibirGolpe();
    boolean golpeada = barco.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }

  @Test
  public void testRecibirVariosGolpes_expectedTrue() {
    // Arrange
    Barco barco = new Barco(1, 'A');

    // Act
    barco.recibirGolpe();
    barco.recibirGolpe();
    boolean golpeada = barco.esGolpeada();

    // Assert
    assertTrue(golpeada);
    assertEquals(barco.getDibujo, '⚫' );
  }
}