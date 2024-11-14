package org.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarcoTest {

  @Test
  public void testEsGolpeada_expectedFalse() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    boolean golpeada = barco.esGolpeada();

    // Assert
    assertFalse(golpeada);
  }

  @Test
  public void testRecibirGolpe_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    barco.recibirGolpe();
    boolean golpeada = barco.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }

  @Test
  public void testRecibirVariosGolpes_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    barco.recibirGolpe();
    barco.recibirGolpe();
    boolean golpeada = barco.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }
}