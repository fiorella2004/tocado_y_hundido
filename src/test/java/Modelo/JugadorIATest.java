package Modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorIATest {

  int dimensionTablero = 10;
  ArrayList<Coordenada> casillasBarco = new ArrayList<>();

  // En los tests de colocarBarco se ha tenido en cuenta las siguientes particiones equivalentes:
  // Coordenadas validas: dentro de rango
  // Coordenadas no validas: fuera de rango


  @Test
  public void testColocarBarcoVerticalAbajo2Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 2 casillas se coloca correctamente
    // Vertical - Esquina inferior derecha (valor frontera)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 0}); // fila: 9; col : 0; direccion: 0 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalArriba2Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 2 casillas se coloca correctamente
    // Vertical - Esquina superior derecha (valor frontera)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 1}); // fila: 0; col : 0; direccion: 1 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda2Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 2 casillas se coloca correctamente
    // Horizontal - Esquina superior derecha (valor frontera)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 9, 2}); // fila: 0; col : 9; direccion: 2 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalDerecha2Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 2 casillas se coloca correctamente
    // Horizontal - Esquina inferior izquierda (valor frontera)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 8, 3}); // fila: 9; col : 8; direccion: 3 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalArriba2Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 2 casillas se coloca correctamente
    // Vertical - Esquina superior derecha (valor frontera)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 0}); // fila: 0; col : 0; direccion: 0 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalAbajo2Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 2 casillas se coloca correctamente
    // Vertical - Esquina inferior izquierda (valor frontera)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 1}); // fila: 9; col : 0; direccion: 1 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda2Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 2 casillas no se coloque mas alla del tablero
    // Horizontal - Esquina superior izquierda (valor limite)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 2}); // fila: 0; col : 0; direccion: 2 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcoHorizontalaDerecha2Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 2 casillas no se coloque mas alla del tablero
    // Horizontal - Esquina inferior derecha (valor limite)
    // Dimension barco: 2

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 9, 3}); // fila: 9; col : 9; direccion: 3 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean resultado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcoVerticalAbajo5Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 5 casillas se coloca correctamente
    // Vertical - Esquina inferior izquierda (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0, 0}); // fila: 9; col : 0; direccion: 0 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalArriba5Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 5 casillas se coloca correctamente
    // Vertical - Esquina superior izquierda (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 0, 1}); // fila: 0; col : 0; direccion: 1 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda5Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 5 casillas se coloca correctamente
    // Vertical - Esquina inferior derecha (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 9, 2}); // fila: 0; col : 9; direccion: 2 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalDerecha5Dimensiones_ExpectedTrue() {
    // Verifica que un barco de 5 casillas se coloca correctamente
    // Vertical - Esquina inferior izquierda (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 5, 3}); // fila: 9; col: 5; direccion: 3 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 2);

    // Assert
    assertTrue(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalArriba5Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 5 casillas no se coloca mas alla del tablero
    // Vertical - Esquina suoerior izquierda (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {3, 0, 0}); // fila: 3; col: 0; direccion: 0 (arriba)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 5);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoVerticalAbajo5Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 5 casillas no se coloca mas alla del tablero
    // Vertical - Esquina inferior izquierda (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {6, 0, 1}); // fila: 6; col: 0; direccion: 1 (abajo)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 5);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalIzquierda5Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 5 casillas no se coloca mas alla del tablero
    // Vertical - Esquina suoperior izquierda (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {0, 3, 2}); // fila: 0; col: 3; direccion: 2 (izquierda)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 5);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testColocarBarcoHorizontalDerecha5Dimensiones_ExpectedFalse() {
    // Verifica que un barco de 5 casillas no se coloca mas alla del tablero
    // Vertical - Esquina inferior derecha (valor frontera)
    // Dimension barco: 5

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 6, 3}); // fila: 9; col: 6; direccion: 3 (derecha)

    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    // Act
    boolean barcoColocado = jugadorIA.colocarBarco(casillasBarco, 5);

    // Assert
    assertFalse(barcoColocado);
  }

  @Test
  public void testRecibirGolpeValorFrontera0_ExpectedTrue() {
    // Verifica que se llama a la funcion recibirGolpe del tablero principal
    // Coordenada (0,0) (valor frontera)

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
  public void testRecibirGolpeValorFrontera9_ExpectedTrue() {
    // Verifica que se llama a la funcion recibirGolpe del tablero principal
    // Coordenada (9,9) (valor frontera)

    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(9, 9);

    //Act
    boolean resultado = jugadorIA.recibirGolpe(coordenadaGolpear);

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testRecibirGolpeValorLimite10_ExpectedFalse() {
    // Verifica que se llama a la funcion recibirGolpe del tablero principal
    // Coordenada (10,10) (valor limite)

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
  public void testRecibirGolpeValorLimiteNegativo_ExpectedFalse() {
    // Verifica que se llama a la funcion recibirGolpe del tablero principal
    // Coordenada (-1,-1) (valor limite)

    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA");
    jugadorIA.asignarTablerosVacios(dimensionTablero);

    Coordenada coordenadaGolpear = new Coordenada(-1, -1);

    //Act
    boolean resultado = jugadorIA.recibirGolpe(coordenadaGolpear);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testGolpearCoordenadaExistenteValorFrontera0_ExpectedTrue() {
    // Verifica que se genera correctamente coordenada a golpear por IA
    // Coordenada a golpear (0,0) (valor frontera)

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
    // Verifica que se genera correctamente coordenada a golpear por IA
    // Coordenada a golpear (9,9) (valor frontera)

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {9, 0}); // fila: 9; col: 0

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertEquals(coordenadaAGolpear.getCol(), 0);
    assertEquals(coordenadaAGolpear.getFila(), 9);
  }

  @Test
  public void testGolpearCoordenadaNoExistenteMenorLimite_ExpectedTrue() {
    // Verifica que se genera correctamente coordenada a golpear por IA
    // Coordenada a golpear (-1,-1) (valor limite)

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {-1, -1, 0, 0}); // fila: -1; col: -1

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertEquals(coordenadaAGolpear.getCol(), 0);
    assertEquals(coordenadaAGolpear.getFila(), 0);
  }

  @Test
  public void testGolpearCoordenadaNoExistenteMayorLimite_ExpectedTrue() {
    // Verifica que se genera correctamente coordenada a golpear por IA
    // Coordenada a golpear (10,10) (valor limite)

    // Arrange
    MockRandom mockRandom = new MockRandom(new int[] {10, 10, 9, 9}); // fila: 10; col: 10

    //Act
    JugadorIA jugadorIA = new JugadorIA("IA", mockRandom);
    jugadorIA.asignarTablerosVacios(dimensionTablero);
    Coordenada coordenadaAGolpear = jugadorIA.golpear();

    //Assert
    assertEquals(coordenadaAGolpear.getCol(), 9);
    assertEquals(coordenadaAGolpear.getFila(), 9);
  }

  @Test
  public void testRegistrarGolpe_casillaBarco_expectedTrue() {
    // Cuando se registra un golpe correcto, la casilla correspondiente en el
    // tablero secundario del jugador debe marcarse como golpeada (versión Barco)

    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Coordenada coordenada = new Coordenada(2, 3);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(coordenada);
    Tablero tableroPrincipalOponente = new Tablero(10);
    tableroPrincipalOponente.colocarBarco(coordenadas, 1);

    // Act
    jugador.registrarGolpe(coordenada, tableroPrincipalOponente);
    Tablero tablero = jugador.obtenerTableroSecundario();
    Casilla casilla = tablero.buscarCasilla(coordenada);

    // Assert
    assertTrue(casilla.esGolpeada());
  }

  @Test
  public void testRegistrarGolpe_casillaAgua_expectedTrue() {
    // Cuando se registra un golpe correcto, la casilla correspondiente en el
    // tablero secundario del jugador debe marcarse como golpeada (versión Agua)

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
    // Cuando se hace un golpe sobre una casilla que contiene un barco
    // en el tablero del oponente, la casilla pasa a ser mostrada

    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Tablero tableroPrincipalOponente = new Tablero(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    tableroPrincipalOponente.colocarBarco(coordenadasBarco, 1);

    // Act
    Coordenada coordenadaGolpeada = new Coordenada(2, 3);
    jugador.adaptarTableroSecundario(coordenadaGolpeada, tableroPrincipalOponente);
    Casilla casillaTableroSecundario = jugador.obtenerTableroSecundario().buscarCasilla(coordenadaGolpeada);

    // Assert
    assertTrue(casillaTableroSecundario instanceof Barco);
  }

  @Test
  public void testAdaptarTableroSecundario_casillaAgua_expectedTrue() {
    // Cuando se hace un golpe sobre una casilla que contiene agua
    // en el tablero del oponente, la casilla pasa a ser mostrada

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
    // Cuando se hacen varios golpes en casillas que contienen agua y barcos
    // en el tablero del oponente, las casillas pasan a ser mostradas

    // Arrange
    Jugador jugador = new JugadorIA("noname");
    jugador.asignarTablerosVacios(10);

    Tablero tableroPrincipalOponente = new Tablero(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    tableroPrincipalOponente.colocarBarco(coordenadasBarco, 2);

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
    // Verificar que encuentra todos los barcos hundidos del tablero
    // Comprueba el que barco este totalmente hundido, no parte de el
    // 1 barco, queda una coordenada sin golpear

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
    // Verificar que encuentra todos los barcos hundidos del tablero
    // Comprueba el que barco este totalmente hundido, no parte de el
    // 1 barco golpeado

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
    // Verificar que encuentra todos los barcos hundidos del tablero
    // Comprueba el que barco este totalmente hundido, no parte de el
    // 5 barco, 1 sin hundir

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
    // Verificar que encuentra todos los barcos hundidos del tablero
    // Comprueba el que barco este totalmente hundido, no parte de el
    // 5 barco, todos golpeados

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