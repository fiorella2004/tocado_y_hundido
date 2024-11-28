package Modelo;

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
  public void testRecibirGolpe_variosGolpes_expectedTrue() {
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

  @Test
  public void testGetDibujo_sinGolpear_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    String dibujo = barco.getDibujo();

    // Assert
    assertEquals("⛵", dibujo);
  }

  @Test
  public void testGetDibujo_conGolpe_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    barco.recibirGolpe();
    String dibujo = barco.getDibujo();

    // Assert
    assertEquals("💥", dibujo);
  }

  @Test
  public void testEquals_mismoObjeto_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    boolean resultado = barco.equals(barco);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testEquals_objetoNull_expectedFalse() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    boolean resultado = barco.equals(null);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testEquals_objetoDeOtraClase_expectedFalse() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);
    int noBarco = 1;

    // Act
    boolean resultado = barco.equals(noBarco);

    // Assert
    assertFalse(resultado);
  }
}