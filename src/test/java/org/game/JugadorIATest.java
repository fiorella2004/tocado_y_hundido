package org.game;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorIATest {

  int dimensionTablero = 10;
  ArrayList<Coordenada> casillasBarco = new ArrayList<>();

  @Test
  public void testColocarBarcoVerticalArriba2Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(9, 0); // 9 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(1); //Arriba

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(9, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(8, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoVerticalAbajo2Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(0, 0); // 0 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(2); //Abajo

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,2);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(0, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(1, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda2Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(0, 9); // 0 para fila, 9 para columna
    when(randomMock.nextInt(4)).thenReturn(3); //Izquierda

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,2);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(0, 9));
    coordenadasBarcoEsperadas.add(new Coordenada(0, 8));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalDerecha2Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(9, 8); // 9 para fila, 8 para columna
    when(randomMock.nextInt(4)).thenReturn(4); //Derecha

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,2);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(9, 8));
    coordenadasBarcoEsperadas.add(new Coordenada(9, 9));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoVerticalArriba2Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(0, 0); // 0 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(1); //Arriba

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,2);

    ArrayList<Coordenada> coordenadasNoBarco = new ArrayList<>();
    coordenadasNoBarco.add(new Coordenada(0, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasNoBarco) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoVerticalAbajo2Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(9, 0); // 9 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(2); //Abajo

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,2);

    ArrayList<Coordenada> coordenadasNoBarco = new ArrayList<>();
    coordenadasNoBarco.add(new Coordenada(9, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasNoBarco) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda2Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(0, 0); // 0 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(3); //Izquierda

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,2);

    ArrayList<Coordenada> coordenadasNoBarco = new ArrayList<>();
    coordenadasNoBarco.add(new Coordenada(0, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasNoBarco) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalaDerecha2Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(9, 9); // 9 para fila, 9 para columna
    when(randomMock.nextInt(4)).thenReturn(4); //Derecha

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,2);

    ArrayList<Coordenada> coordenadasNoBarco = new ArrayList<>();
    coordenadasNoBarco.add(new Coordenada(9, 9));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasNoBarco) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoVerticalArriba5Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(9, 0); // 9 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(1); //Arriba

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(9, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(8, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(7, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(6, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(5, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoVerticalAbajo5Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(0, 0); // 0 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(2); //Abajo

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(0, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(1, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(2, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(3, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(4, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda5Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(0, 9); // 0 para fila, 9 para columna
    when(randomMock.nextInt(4)).thenReturn(3); //Izquierda

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(0, 9));
    coordenadasBarcoEsperadas.add(new Coordenada(0, 8));
    coordenadasBarcoEsperadas.add(new Coordenada(0, 7));
    coordenadasBarcoEsperadas.add(new Coordenada(0, 6));
    coordenadasBarcoEsperadas.add(new Coordenada(0, 5));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalDerecha5Dimensiones_ExpectedTrue() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(9, 5); // 9 para fila, 5 para columna
    when(randomMock.nextInt(4)).thenReturn(4); //Derecha

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(9, 5));
    coordenadasBarcoEsperadas.add(new Coordenada(9, 6));
    coordenadasBarcoEsperadas.add(new Coordenada(9, 7));
    coordenadasBarcoEsperadas.add(new Coordenada(9, 8));
    coordenadasBarcoEsperadas.add(new Coordenada(9, 9));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertTrue(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoVerticalArriba5Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(3, 0); // 3 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(1); //Arriba

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoNoEsperadas = new ArrayList<>();
    coordenadasBarcoNoEsperadas.add(new Coordenada(3, 0));
    coordenadasBarcoNoEsperadas.add(new Coordenada(2, 0));
    coordenadasBarcoNoEsperadas.add(new Coordenada(1, 0));
    coordenadasBarcoNoEsperadas.add(new Coordenada(0, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoNoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoVerticalAbajo5Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(6, 0); // 6 para fila, 0 para columna
    when(randomMock.nextInt(4)).thenReturn(2); //Abajo

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoNoEsperadas = new ArrayList<>();
    coordenadasBarcoNoEsperadas.add(new Coordenada(6, 0));
    coordenadasBarcoNoEsperadas.add(new Coordenada(7, 0));
    coordenadasBarcoNoEsperadas.add(new Coordenada(8, 0));
    coordenadasBarcoNoEsperadas.add(new Coordenada(9, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoNoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda5Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(0, 3); // 0 para fila, 3 para columna
    when(randomMock.nextInt(4)).thenReturn(3); //Izquierda

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoNoEsperadas = new ArrayList<>();
    coordenadasBarcoNoEsperadas.add(new Coordenada(0, 3));
    coordenadasBarcoNoEsperadas.add(new Coordenada(0, 2));
    coordenadasBarcoNoEsperadas.add(new Coordenada(0, 1));
    coordenadasBarcoNoEsperadas.add(new Coordenada(0, 0));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoNoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testColocarBarcoHorizontalDerecha5Dimensiones_ExpectedFalse() {
    // Arrange
    Random randomMock = mock(Random.class);

    when(randomMock.nextInt(10)).thenReturn(9, 6); // 0 para fila, 6 para columna
    when(randomMock.nextInt(4)).thenReturn(4); //Derecha

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco,5);

    ArrayList<Coordenada> coordenadasBarcoNoEsperadas = new ArrayList<>();
    coordenadasBarcoNoEsperadas.add(new Coordenada(9, 6));
    coordenadasBarcoNoEsperadas.add(new Coordenada(9, 7));
    coordenadasBarcoNoEsperadas.add(new Coordenada(9, 8));
    coordenadasBarcoNoEsperadas.add(new Coordenada(9, 9));

    // Assert
    Tablero tablero = jugadorIA.obtenerTableroPrincipal();
    for (Coordenada coordenada : coordenadasBarcoNoEsperadas) {
      Casilla casilla = tablero.buscarCasilla(coordenada);
      assertFalse(casilla instanceof Barco);
    }
  }

  @Test
  public void testRecibirGolpValorLimite0_ExpectedTrue(){
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(0,0);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertTrue(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testRecibirGolpValorLimite9_ExpectedTrue(){
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(9,9);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertTrue(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testRecibirGolpeValorFrontera10_ExpectedFalse(){
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(10,10);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertFalse(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testRecibirGolpeValorFronteraNegativo_ExpectedFalse(){
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(-1,-1);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertFalse(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testGolpearCoordenadaExistenteValorFrontera0_ExpectedTrue(){
    // Arrange
    Random randomMock = mock(Random.class);
    when(randomMock.nextInt(10)).thenReturn(0, 0);

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertEquals(0, coordenadaAGolpear.getFila());
    assertEquals(0, coordenadaAGolpear.getCol());
  }

  @Test
  public void testGolpearCoordenadaExistenteValorFrontera9_ExpectedTrue(){
    // Arrange
    Random randomMock = mock(Random.class);
    when(randomMock.nextInt(10)).thenReturn(9, 9);

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertEquals(9, coordenadaAGolpear.getFila());
    assertEquals(9, coordenadaAGolpear.getCol());
  }

  @Test
  public void testGolpearCoordenadaNoExistenteMenorLimite_ExpectedTrue(){
    // Arrange
    Random randomMock = mock(Random.class);
    when(randomMock.nextInt(10)).thenReturn(-1, -1);

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertNull(coordenadaAGolpear);
  }

  @Test
  public void testGolpearCoordenadaNoExistenteMayorLimite_ExpectedTrue(){
    // Arrange
    Random randomMock = mock(Random.class);
    when(randomMock.nextInt(10)).thenReturn(10, 10);

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertNull(coordenadaAGolpear);
  }
}