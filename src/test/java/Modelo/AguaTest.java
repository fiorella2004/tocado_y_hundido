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
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Act
    agua.recibirGolpe();
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }

  @Test
  public void testRecibirGolpe_variosGolpes_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Act
    agua.recibirGolpe();
    agua.recibirGolpe();
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }

  @Test
  public void testGetDibujo_sinGolpear_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Act
    String dibujo = agua.getDibujo();

    // Assert
    assertEquals("🌊", dibujo);
  }

  @Test
  public void testGetDibujo_conGolpe_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Act
    agua.recibirGolpe();
    String dibujo = agua.getDibujo();

    // Assert
    assertEquals("⬜", dibujo);
  }

  @Test
  public void testEquals_mismoObjeto_expectedTrue() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Act
    boolean resultado = agua.equals(agua);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testEquals_objetoNull_expectedFalse() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Act
    boolean resultado = agua.equals(null);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testEquals_objetoDeOtraClase_expectedFalse() {
    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);
    int noAgua = 1;

    // Act
    boolean resultado = agua.equals(noAgua);

    // Assert
    assertFalse(resultado);
  }
}

