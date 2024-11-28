package Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarcoTest {

  @Test
  public void testEsGolpeada_expectedFalse() {
    // Verifica que un barco recién creado no esté golpeado

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
    // Comprueba que un barco recibe un golpe correctamente

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
    // Confirma que el estado de golpeado no cambia
    // con múltiples golpes

    // Arrange
    Coordenada coordenada = new Coordenada(1, 1);
    Barco barco = new Barco(coordenada);

    // Act
    barco.recibirGolpe(); // Golpe 1
    barco.recibirGolpe(); // Golpe 2
    boolean golpeada = barco.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }

  @Test
  public void testGetDibujo_sinGolpear_expectedTrue() {
    // Verifica el dibujo de un barco sin golpear

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
    // Comprueba que el dibujo cambia después de un golpe

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
    // Verifica que una casilla sea igual a sí misma

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
    // Verifica que una casilla no sea igual a un objeto nulo

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
    // Verifica que una casilla no sea igual a un objeto de otra clase

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