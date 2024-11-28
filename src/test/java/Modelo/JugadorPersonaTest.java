package Modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JugadorPersonaTest {

  @Test
  public void testAsignarNombre_expectedTrue() {
    // Verifica que se pueda asignar un nombre correctamente

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");

    // Act
    jugador.asignarNombre("Fiorella");

    // Assert
    assertEquals("Fiorella", jugador.getNombre());
  }

  @Test
  public void testRecibirGolpe_expectedTrue() {
    // Verifica que un golpe en una coordenada válida
    // sea recibido correctamente

    // Arrange
    // MockTablero mockTableroPrincipal = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    Coordenada coordenada = new Coordenada(1, 1);

    // Act
    boolean resultado = jugador.recibirGolpe(coordenada);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testRecibirGolpe_expectedFalse() {
    // Verifica que un golpe en una coordenada inválida no sea recibido

    // Arrange
    // MockTablero mockTableroPrincipal = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    Coordenada coordenada = new Coordenada(10, 10);

    // Act
    boolean resultado = jugador.recibirGolpe(coordenada);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testObtenerTableroPrincipal_expectedTrue() {
    // Verifica que el tablero principal sea asignado correctamente

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    // Act
    boolean resultado = jugador.obtenerTableroPrincipal() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testObtenerTableroSecundario_expectedTrue() {
    // Verifica que el tablero secundario sea asignado correctamente

    // Arrange
    // MockTablero mockTableroPrincipal = new MockTablero(10, true);
    // MockTablero mockTableroSecundario = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    // Act
    boolean resultado = jugador.obtenerTableroSecundario() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaSupIzq_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente
    // en la esquina superior izquierda del tablero (valor frontera)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(0, 0));
    coordenadasBarco.add(new Coordenada(0, 1));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaInfIzq_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente
    // en la esquina inferior izquierda del tablero (valor frontera)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(9, 8));
    coordenadasBarco.add(new Coordenada(9, 9));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaSupDer_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente
    // en la esquina superior derecha del tablero (valor frontera)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(0, 9));
    coordenadasBarco.add(new Coordenada(1, 9));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaInfDer_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente
    // en la esquina inferior derecha del tablero (valor frontera)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(8, 9));
    coordenadasBarco.add(new Coordenada(9, 9));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaSupIzq_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina superior izquierda del tablero (valor límite)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(0, -1));
    coordenadasBarco.add(new Coordenada(0, 0));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaInfIzq_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina inferior izquierda del tablero (valor límite)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(9, 9));
    coordenadasBarco.add(new Coordenada(9, 10));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaInfDer_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina inferior derecha del tablero (valor límite)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(-1, 9));
    coordenadasBarco.add(new Coordenada(0, 9));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_fueraTablero_esquinaInfDer_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina inferior derecha del tablero (valor límite)

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(9, 9));
    coordenadasBarco.add(new Coordenada(10, 9));

    // Act
    boolean resultado = jugador.colocarBarco(coordenadasBarco, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarBarcosHundidos_1barco_expectedFalse() {
    // Verifica que un barco no está hundido si no ha sido golpeado completamente

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    // Colocar barco de 3 casillas en tablero
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    coordenadasBarco.add(new Coordenada(2, 5));
    boolean resultadoColocarBarco = jugador.colocarBarco(coordenadasBarco, 3);

    // Act
    jugador.recibirGolpe(new Coordenada(2, 3)); // Golpe 1 de 3
    jugador.recibirGolpe(new Coordenada(2, 4)); // Golpe 2 de 3
    boolean resultadoTodosBarcosHundidos = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultadoColocarBarco);
    assertFalse(resultadoTodosBarcosHundidos);
  }

  @Test
  public void testComprobarBarcosHundidos_1barco_expectedTrue() {
    // Verifica que un barco está hundido si ha sido golpeado completamente

    // Arrange
    // MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    // Colocar barco de 3 casillas en tablero
    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    coordenadasBarco.add(new Coordenada(2, 3));
    coordenadasBarco.add(new Coordenada(2, 4));
    coordenadasBarco.add(new Coordenada(2, 5));
    boolean resultadoColocarBarco = jugador.colocarBarco(coordenadasBarco, 3);

    // Act
    jugador.recibirGolpe(new Coordenada(2, 3)); // Golpe 1 de 3
    jugador.recibirGolpe(new Coordenada(2, 4)); // Golpe 2 de 3
    jugador.recibirGolpe(new Coordenada(2, 5)); // Golpe 3 de 3
    boolean resultadoTodosBarcosHundidos = jugador.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultadoColocarBarco);
    assertTrue(resultadoTodosBarcosHundidos);
  }

  @Test
  public void testComprobarBarcosHundidos_5barcos_expectedFalse() {
    // Verifica que todos los barcos no estén hundidos
    // si no han sido golpeados completamente

    // Arrange
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    // Crear los 5 barcos de dimensiones 5, 4, 3, 3, 2
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
    // Verifica que todos los barcos estén hundidos
    // si han sido golpeados completamente

    // Arrange
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    // Crear los 5 barcos de dimensiones 5, 4, 3, 3, 2
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

  @Test
  public void testRegistrarGolpe_casillaBarco_expectedTrue() {
    // Cuando se registra un golpe correcto, la casilla correspondiente en el
    // tablero secundario del jugador debe marcarse como golpeada (versión Barco)

    // Arrange
    Jugador jugador = new JugadorPersona("noname");
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
    Jugador jugador = new JugadorPersona("noname");
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
    Jugador jugador = new JugadorPersona("noname");
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
    Jugador jugador = new JugadorPersona("noname");
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
    Jugador jugador = new JugadorPersona("noname");
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
}