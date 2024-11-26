package Modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JugadorPersonaTest {

  @Test
  public void testAsignarNombre_expectedTrue() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");

    // Act
    jugador.asignarNombre("Fiorella");

    // Assert
    assertEquals("Fiorella", jugador.getNombre());
  }

  @Test
  public void recibirGolpe_expectedTrue() {
    // Arrange
    //MockTablero mockTableroPrincipal = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);
    Coordenada coordenada = new Coordenada(1, 1);

    // Act
    boolean resultado = jugador.recibirGolpe(coordenada);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void recibirGolpe_expectedFalse() {
    // Arrange
    //MockTablero mockTableroPrincipal = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    // Act
    boolean resultado = jugador.obtenerTableroPrincipal() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testObtenerTableroSecundario_expectedTrue() {
    // Arrange
    //MockTablero mockTableroPrincipal = new MockTablero(10, true);
    //MockTablero mockTableroSecundario = new MockTablero(10, true);
    Jugador jugador = new JugadorPersona("noname");
    jugador.asignarTablerosVacios(10);

    // Act
    boolean resultado = jugador.obtenerTableroSecundario() != null;

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarcos_2casillas_dentroTablero_esquinaSupIzq_expectedTrue() {
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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
    // Arrange
    //MockTablero mockTablero = new MockTablero(10, true);
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

  @Test
  public void testRegistrarGolpe_casillaBarco_expectedTrue() {
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