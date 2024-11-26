package Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AguaTest {

  @Test
  public void testEsGolpeada_expectedFalse() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Act
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertFalse(golpeada);
  }

  @Test
  public void testRecibirGolpe_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(2, 2);
    Agua agua = new Agua(coordenada);

    // Act
    agua.recibirGolpe();
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }

  @Test
  public void testRecibirVariosGolpes_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(3, 3);
    Agua agua = new Agua(coordenada);

    // Act
    agua.recibirGolpe();
    agua.recibirGolpe();
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }
}

