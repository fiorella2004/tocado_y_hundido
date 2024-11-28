package Modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AguaTest {

  @Test
  public void testEsGolpeada_expectedFalse() {
    // Verifica que una casilla de agua no está
    // golpeada al ser creada

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
    // Verifica que una casilla de agua sea golpeada
    // después de llamar a recibirGolpe()

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
    // Verifica que una casilla de agua permanezca
    // golpeada tras múltiples golpes

    // Arrange:
    Coordenada coordenada = new Coordenada(1, 1);
    Agua agua = new Agua(coordenada);

    // Arrange
    agua.recibirGolpe(); // Golpe 1
    agua.recibirGolpe(); // Golpe 2
    boolean golpeada = agua.esGolpeada();

    // Assert
    assertTrue(golpeada);
  }

  @Test
  public void testGetDibujo_sinGolpear_expectedTrue() {
    // Verifica que el dibujo de una casilla de agua
    // sin golpear sea el esperado

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
    // Verifica que el dibujo de una casilla de
    // agua golpeada cambie

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
    // Verifica que una casilla sea igual a sí misma

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
    // Verifica que una casilla no sea igual a un objeto nulo

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
    // Verifica que una casilla no sea igual a un objeto de otra clase

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

