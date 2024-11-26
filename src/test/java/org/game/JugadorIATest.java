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
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalAbajo2Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 2}); // fila: 0; col : 0; direccion: 2 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda2Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 9, 3}); // fila: 0; col : 9; direccion: 3 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalDerecha2Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 8, 4}); // fila: 9; col : 8; direccion: 4 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalArriba2Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 1}); // fila: 0; col : 0; direccion: 1 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalAbajo2Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 2}); // fila: 9; col : 0; direccion: 2 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda2Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 3}); // fila: 0; col : 0; direccion: 3 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcoHorizontalaDerecha2Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 9, 4}); // fila: 9; col : 9; direccion: 4 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcoVerticalArriba5Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 1}); // fila: 9; col : 0; direccion: 1 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalAbajo5Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 2}); // fila: 0; col : 0; direccion: 2 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda5Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 9, 3}); // fila: 0; col : 9; direccion: 3 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalDerecha5Dimensiones_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 5, 4}); // fila: 9; col: 5; direccion: 4 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalArriba5Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {3, 0, 1}); // fila: 3; col: 0; direccion: 1 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalAbajo5Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {6, 0, 2}); // fila: 6; col: 0; direccion: 2 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda5Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 3, 3}); // fila: 0; col: 3; direccion: 3 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalDerecha5Dimensiones_ExpectedFalse() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 6, 4}); // fila: 9; col: 6; direccion: 4 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testRecibirGolpeValorFrontera0_ExpectedTrue() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(0, 0);

    //Act
    boolean resultado = jugadorIA.recibirGolpe(coordenadaGolpear);

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testRecibirGolpeValorLimite10_ExpectedTrue() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(10, 10);

    //Act
    boolean resultado = jugadorIA.recibirGolpe(coordenadaGolpear);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testGolpearCoordenadaExistenteValorFrontera0_ExpectedTrue() {
    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0}); // fila: 0; col: 0

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
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
    MockRandom mockRandom = new MockRandom(new int[] {10, 10}); // fila: 10; col: 10

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertNull(coordenadaAGolpear);
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