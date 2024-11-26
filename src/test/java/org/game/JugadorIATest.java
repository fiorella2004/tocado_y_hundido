package org.game;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorIATest {

  int dimensionTablero = 10;
  ArrayList<Coordenada> casillasBarco = new ArrayList<>();

  @Test
  public void testColocarBarcoVerticalArriba2Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 1}); // fila: 9; col : 0; direccion: 1 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    ArrayList<Coordenada> coordenadasBarcoEsperadas = new ArrayList<>();
    coordenadasBarcoEsperadas.add(new Coordenada(9, 0));
    coordenadasBarcoEsperadas.add(new Coordenada(8, 0));

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
    jugadorIA.colocarBarco(casillasBarco, 2);

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
    MockRandom mockRandom = new MockRandom(new int[] {0, 9, 3}); // fila: 0; col : 9; direccion: 3 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

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
    MockRandom mockRandom = new MockRandom(new int[] {9, 8, 4}); // fila: 9; col : 8; direccion: 4 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

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
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 1}); // fila: 0; col : 0; direccion: 1 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

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
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 2}); // fila: 9; col : 0; direccion: 2 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

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
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 3}); // fila: 0; col : 0; direccion: 3 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

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
    MockRandom mockRandom = new MockRandom(new int[] {9, 9, 4}); // fila: 9; col : 9; direccion: 4 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 2);

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
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 1}); // fila: 9; col : 0; direccion: 1 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 5);

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
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 2}); // fila: 0; col : 0; direccion: 2 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 5);

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
    MockRandom mockRandom = new MockRandom(new int[] {0, 9, 3}); // fila: 0; col : 9; direccion: 3 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", randomMock);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    jugadorIA.colocarBarco(casillasBarco, 5);

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
    jugadorIA.colocarBarco(casillasBarco, 5);

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
    jugadorIA.colocarBarco(casillasBarco, 5);

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
    jugadorIA.colocarBarco(casillasBarco, 5);

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
    jugadorIA.colocarBarco(casillasBarco, 5);

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
    jugadorIA.colocarBarco(casillasBarco, 5);

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
  public void testRecibirGolpValorLimite0_ExpectedTrue() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(0, 0);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertTrue(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testRecibirGolpValorLimite9_ExpectedTrue() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(9, 9);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertTrue(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testRecibirGolpeValorFrontera10_ExpectedFalse() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(10, 10);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertFalse(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testRecibirGolpeValorFronteraNegativo_ExpectedFalse() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(-1, -1);

    //Act
    jugadorIA.recibirGolpe(coordenadaGolpear);

    Tablero tableroPrincipal = jugadorIA.obtenerTableroPrincipal();
    Casilla casillaGolpeada = tableroPrincipal.buscarCasilla(coordenadaGolpear);

    //Assert
    assertFalse(casillaGolpeada.esGolpeada());
  }

  @Test
  public void testGolpearCoordenadaExistenteValorFrontera0_ExpectedTrue() {
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
  public void testGolpearCoordenadaExistenteValorFrontera9_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0}); // fila: 9; col: 0

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertEquals(9, coordenadaAGolpear.getFila());
    assertEquals(9, coordenadaAGolpear.getCol());
  }

  @Test
  public void testGolpearCoordenadaNoExistenteMenorLimite_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {-1, -1}); // fila: -1; col: -1

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertNull(coordenadaAGolpear);
  }

  @Test
  public void testGolpearCoordenadaNoExistenteMayorLimite_ExpectedTrue() {
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

  @Test
  public void recibirGolpe_expectedTrue() {
    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);
    Coordenada coordenada = new Coordenada(1, 1);

    // Act
    jugador.recibirGolpe(coordenada);
    Casilla casillaGolpeada = jugador.obtenerTableroPrincipal().buscarCasilla(coordenada);
    boolean resultado = casillaGolpeada.esGolpeada();

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void recibirGolpe_expectedFalse() {
    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);
    Coordenada coordenada = new Coordenada(16, 16);

    // Act
    jugador.recibirGolpe(coordenada);
    Casilla casillaGolpeada = jugador.obtenerTableroPrincipal().buscarCasilla(coordenada);

    // Assert
    assertNull(casillaGolpeada);
  }

  @Test
  public void testRegistrarGolpe_casillaBarco_expectedTrue() {
    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Coordenada coordenada = new Coordenada(2, 3);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(coordenada);
    Tablero tableroPrincipalOponente = new Tablero(10);
    tableroPrincipalOponente.colocarBarco(coordenadas);

    // Act
    jugador.registrarGolpe(coordenada, tableroPrincipalOponente);
    Tablero tablero = jugador.obtenerTableroSecundario();
    Casilla casilla = tablero.buscarCasilla(coordenada);

    // Assert
    assertTrue(casilla.esGolpeada());
  }

  @Test
  public void testRegistrarGolpe_casillaAgua_expectedTrue() {
    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Coordenada coordenada = new Coordenada(2, 3);
    Tablero tableroPrincipalOponente = new Tablero(10);

    // Act
    jugador.registrarGolpe(coordenada, tableroPrincipalOponente);
    Tablero tablero = jugador.obtenerTableroSecundario();
    Casilla casilla = tablero.buscarCasilla(coordenada);

    // Assert
    assertTrue(casilla.esGolpeada());
  }

  @Test
  public void testAdaptarTableroSecundario_casillaBarco_expectedTrue() {
    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Tablero tableroPrincipalOponente = new Tablero(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    tableroPrincipalOponente.colocarBarco(coordenadasBarco);

    // Act
    Coordenada coordenadaGolpeada = new Coordenada(2, 3);
    jugador.adaptarTableroSecundario(coordenadaGolpeada, tableroPrincipalOponente);
    Casilla casillaTableroSecundario = jugador.obtenerTableroSecundario().buscarCasilla(coordenadaGolpeada);

    // Assert
    assertTrue(casillaTableroSecundario instanceof Barco);
  }

  @Test
  public void testAdaptarTableroSecundario_casillaAgua_expectedTrue() {
    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Tablero tableroPrincipalOponente = new Tablero(10);
    Coordenada coordenadaGolpeada = new Coordenada(2, 3);

    // Act
    jugador.adaptarTableroSecundario(coordenadaGolpeada, tableroPrincipalOponente);
    Casilla casillaTableroSecundario = jugador.obtenerTableroSecundario().buscarCasilla(coordenadaGolpeada);

    // Assert
    assertTrue(casillaTableroSecundario instanceof Agua);
  }

  @Test
  public void testAdaptarTableroSecundario_casillasGolpeadas_expectedTrue() {
    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Tablero tableroPrincipalOponente = new Tablero(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    tableroPrincipalOponente.colocarBarco(coordenadasBarco);

    // Act
    jugador.adaptarTableroSecundario(new Coordenada(2, 3), tableroPrincipalOponente);
    jugador.adaptarTableroSecundario(new Coordenada(3, 5), tableroPrincipalOponente);

    // Assert
    Tablero tableroSecundario = jugador.obtenerTableroSecundario();
    Casilla casillaBarco = tableroSecundario.buscarCasilla(new Coordenada(2, 3));
    Casilla casillaAgua = tableroSecundario.buscarCasilla(new Coordenada(3, 5));
    assertTrue(casillaBarco instanceof Barco);
    assertTrue(casillaAgua instanceof Agua);
  }

  @Test
  public void testComprobarBarcosHundidos_1barco_expectedFalse() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    coordenadasBarco.add(new Coordenada(2, 5));
    boolean resultadoColocarBarco = jugador.colocarBarco(coordenadasBarco, 3);

    // Act
    jugador.recibirGolpe(new Coordenada(2, 3));
    jugador.recibirGolpe(new Coordenada(2, 4));
    boolean resultadoTodosBarcosHundidos = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultadoColocarBarco);
    assertFalse(resultadoTodosBarcosHundidos);
  }

  @Test
  public void testComprobarBarcosHundidos_1barco_expectedTrue() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    coordenadasBarco.add(new Coordenada(2, 5));
    boolean resultadoColocarBarco = jugador.colocarBarco(coordenadasBarco, 3);

    // Act
    jugador.recibirGolpe(new Coordenada(2, 3));
    jugador.recibirGolpe(new Coordenada(2, 4));
    jugador.recibirGolpe(new Coordenada(2, 5));
    boolean resultadoTodosBarcosHundidos = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultadoColocarBarco);
    assertTrue(resultadoTodosBarcosHundidos);
  }

  @Test
  public void testComprobarBarcosHundidos_5barcos_expectedFalse() {
    // Arrange
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    ArrayList<Coordenada> coordenadasBarco1 = new ArrayList<>();
    coordenadasBarco1.add(new Coordenada(1, 3));
    coordenadasBarco1.add(new Coordenada(1, 4));
    coordenadasBarco1.add(new Coordenada(1, 5));
    coordenadasBarco1.add(new Coordenada(1, 6));
    coordenadasBarco1.add(new Coordenada(1, 7));
    boolean resultadoColocarBarco1 = jugador.colocarBarco(coordenadasBarco1, 5);
    ArrayList<Coordenada> coordenadasBarco2 = new ArrayList<>();
    coordenadasBarco2.add(new Coordenada(2, 3));
    coordenadasBarco2.add(new Coordenada(2, 4));
    coordenadasBarco2.add(new Coordenada(2, 5));
    coordenadasBarco2.add(new Coordenada(2, 6));
    boolean resultadoColocarBarco2 = jugador.colocarBarco(coordenadasBarco2, 4);
    ArrayList<Coordenada> coordenadasBarco3 = new ArrayList<>();
    coordenadasBarco3.add(new Coordenada(3, 3));
    coordenadasBarco3.add(new Coordenada(3, 4));
    coordenadasBarco3.add(new Coordenada(3, 5));
    boolean resultadoColocarBarco3 = jugador.colocarBarco(coordenadasBarco3, 3);
    ArrayList<Coordenada> coordenadasBarco4 = new ArrayList<>();
    coordenadasBarco4.add(new Coordenada(4, 3));
    coordenadasBarco4.add(new Coordenada(4, 4));
    coordenadasBarco4.add(new Coordenada(4, 5));
    boolean resultadoColocarBarco4 = jugador.colocarBarco(coordenadasBarco4, 3);
    ArrayList<Coordenada> coordenadasBarco5 = new ArrayList<>();
    coordenadasBarco5.add(new Coordenada(5, 6));
    coordenadasBarco5.add(new Coordenada(5, 7));
    boolean resultadoColocarBarco5 = jugador.colocarBarco(coordenadasBarco5, 2);

    // Act
    jugador.recibirGolpe(new Coordenada(1, 3));
    jugador.recibirGolpe(new Coordenada(1, 4));
    jugador.recibirGolpe(new Coordenada(1, 5));
    jugador.recibirGolpe(new Coordenada(1, 6));
    jugador.recibirGolpe(new Coordenada(1, 7));
    jugador.recibirGolpe(new Coordenada(2, 3));
    jugador.recibirGolpe(new Coordenada(2, 4));
    jugador.recibirGolpe(new Coordenada(2, 5));
    jugador.recibirGolpe(new Coordenada(2, 6));
    jugador.recibirGolpe(new Coordenada(3, 3));
    jugador.recibirGolpe(new Coordenada(3, 4));
    jugador.recibirGolpe(new Coordenada(3, 5));
    jugador.recibirGolpe(new Coordenada(4, 3));
    jugador.recibirGolpe(new Coordenada(4, 4));
    jugador.recibirGolpe(new Coordenada(4, 5));
    jugador.recibirGolpe(new Coordenada(5, 6));
    boolean resultadoTodosBarcosHundidos = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultadoColocarBarco1);
    assertTrue(resultadoColocarBarco2);
    assertTrue(resultadoColocarBarco3);
    assertTrue(resultadoColocarBarco4);
    assertTrue(resultadoColocarBarco5);
    assertFalse(resultadoTodosBarcosHundidos);
  }

  @Test
  public void testComprobarBarcosHundidos_5barcos_expectedTrue() {
    // Arrange
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    ArrayList<Coordenada> coordenadasBarco1 = new ArrayList<>();
    coordenadasBarco1.add(new Coordenada(1, 3));
    coordenadasBarco1.add(new Coordenada(1, 4));
    coordenadasBarco1.add(new Coordenada(1, 5));
    coordenadasBarco1.add(new Coordenada(1, 6));
    coordenadasBarco1.add(new Coordenada(1, 7));
    boolean resultadoColocarBarco1 = jugador.colocarBarco(coordenadasBarco1, 5);
    ArrayList<Coordenada> coordenadasBarco2 = new ArrayList<>();
    coordenadasBarco2.add(new Coordenada(2, 3));
    coordenadasBarco2.add(new Coordenada(2, 4));
    coordenadasBarco2.add(new Coordenada(2, 5));
    coordenadasBarco2.add(new Coordenada(2, 6));
    boolean resultadoColocarBarco2 = jugador.colocarBarco(coordenadasBarco2, 4);
    ArrayList<Coordenada> coordenadasBarco3 = new ArrayList<>();
    coordenadasBarco3.add(new Coordenada(3, 3));
    coordenadasBarco3.add(new Coordenada(3, 4));
    coordenadasBarco3.add(new Coordenada(3, 5));
    boolean resultadoColocarBarco3 = jugador.colocarBarco(coordenadasBarco3, 3);
    ArrayList<Coordenada> coordenadasBarco4 = new ArrayList<>();
    coordenadasBarco4.add(new Coordenada(4, 3));
    coordenadasBarco4.add(new Coordenada(4, 4));
    coordenadasBarco4.add(new Coordenada(4, 5));
    boolean resultadoColocarBarco4 = jugador.colocarBarco(coordenadasBarco4, 3);
    ArrayList<Coordenada> coordenadasBarco5 = new ArrayList<>();
    coordenadasBarco5.add(new Coordenada(5, 6));
    coordenadasBarco5.add(new Coordenada(5, 7));
    boolean resultadoColocarBarco5 = jugador.colocarBarco(coordenadasBarco5, 2);

    // Act
    jugador.recibirGolpe(new Coordenada(1, 3));
    jugador.recibirGolpe(new Coordenada(1, 4));
    jugador.recibirGolpe(new Coordenada(1, 5));
    jugador.recibirGolpe(new Coordenada(1, 6));
    jugador.recibirGolpe(new Coordenada(1, 7));
    jugador.recibirGolpe(new Coordenada(2, 3));
    jugador.recibirGolpe(new Coordenada(2, 4));
    jugador.recibirGolpe(new Coordenada(2, 5));
    jugador.recibirGolpe(new Coordenada(2, 6));
    jugador.recibirGolpe(new Coordenada(3, 3));
    jugador.recibirGolpe(new Coordenada(3, 4));
    jugador.recibirGolpe(new Coordenada(3, 5));
    jugador.recibirGolpe(new Coordenada(4, 3));
    jugador.recibirGolpe(new Coordenada(4, 4));
    jugador.recibirGolpe(new Coordenada(4, 5));
    jugador.recibirGolpe(new Coordenada(5, 6));
    jugador.recibirGolpe(new Coordenada(5, 7));
    boolean resultadoTodosBarcosHundidos = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultadoColocarBarco1);
    assertTrue(resultadoColocarBarco2);
    assertTrue(resultadoColocarBarco3);
    assertTrue(resultadoColocarBarco4);
    assertTrue(resultadoColocarBarco5);
    assertTrue(resultadoTodosBarcosHundidos);
  }

}