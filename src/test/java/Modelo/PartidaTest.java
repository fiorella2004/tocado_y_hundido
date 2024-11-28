package Modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

  // Para estos test se ha utilizado mockito para simular la colocacion aleatoria de barcos y coordenadas de golpe
  // en el jugadorIA y simular la introduccion de coordenadas por parte del usuario

  @Test
  public void constructorPartida_expectedTrue() {
    // Verificamos que se construye correctamente un objeto de Partida

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    // Act
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    //Assert
    Mockito.verify(mockJugadorPersona).asignarTablerosVacios(10);
    Mockito.verify(mockJugadorIA).asignarTablerosVacios(10);
    assertEquals(mockJugadorIA, partida.getjugadorIA());
    assertEquals(mockJugadorPersona, partida.getJugadorPersona());
  }

  @Test
  public void testGetDimensionTablero_expectedTrue() {
    // Verificar que se introduce la dimension del barco correctamente

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    // Act
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    //Assert
    assertEquals(10, partida.getDimensionTablero());
  }

  @Test
  public void colocarBarcoJugador_expectedTrue() {
    // Verificar que la función colocarBarcoJugador llama correctamente a las funciones correspondientes
    // Usuario introduce bien las coordenadas

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0, 0);
    Coordenada coordenada2 = new Coordenada(1, 0);
    coordenadasBarco.add(coordenada1);
    coordenadasBarco.add(coordenada2);

    // Act
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);
    Mockito.when(mockJugadorPersona.colocarBarco(coordenadasBarco, 2)).thenReturn(true);
    boolean resultado = partida.colocarBarcoJugador(coordenadasBarco, 2);

    //Assert
    assertTrue(resultado);
    Mockito.verify(mockJugadorPersona).colocarBarco(coordenadasBarco, 2);
  }

  @Test
  public void colocarBarcoJugador_expectedFalse() {
    // Verificar que la función colocarBarcoJugador llama correctamente a las funciones correspondientes
    // Usuario introduce mal las coordendas, barco en diagonal

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0, 0);
    Coordenada coordenada2 = new Coordenada(1, 0);
    coordenadasBarco.add(coordenada1);
    coordenadasBarco.add(coordenada2);

    // Act
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);
    Mockito.when(mockJugadorPersona.colocarBarco(coordenadasBarco, 2)).thenReturn(false);
    boolean resultado = partida.colocarBarcoJugador(coordenadasBarco, 2);

    //Assert
    assertFalse(resultado);
    Mockito.verify(mockJugadorPersona).colocarBarco(coordenadasBarco, 2);
  }

  @Test
  public void colocarBarcosIA_verifyMethod() {
    // Verificar que la función colocarBarcosIA llama correctamente a las funciones correspondientes

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 0));

    // Act
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 2)).thenReturn(true);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 3)).thenReturn(true);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 4)).thenReturn(true);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 5)).thenReturn(true);
    partida.colocarBarcosIA();

    //Assert
    Mockito.verify(mockJugadorIA).colocarBarco(coordenadas, 2);
  }

  @Test
  public void golpeaJugadorPersona_expectedTrue() {
    // Verificar que la función golpeaJugadorPersona llama correctamente a las funciones correspondientes
    // Usuario introduce bien la coordenada

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);
    Coordenada coordenadaAGolpear = new Coordenada(0, 0);

    // Act
    Mockito.when(mockJugadorIA.recibirGolpe(coordenadaAGolpear)).thenReturn(true);
    boolean resultado = partida.golpeaJugadorPersona(coordenadaAGolpear);

    //Assert
    Mockito.verify(mockJugadorIA).recibirGolpe(coordenadaAGolpear);
    Mockito.verify(mockJugadorPersona).registrarGolpe(coordenadaAGolpear, mockJugadorIA.obtenerTableroPrincipal());

    assertTrue(resultado);

  }

  @Test
  public void golpeaJugadorPersona_expectedFalse() {
    // Verificar que la función golpeaJugadorPersona llama correctamente a las funciones correspondientes
    // Simulamos que usuario introduce una coordenada que ya ha golpeado

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);
    Coordenada coordenadaAGolpear = new Coordenada(0, 0);

    // Act
    Mockito.when(mockJugadorIA.recibirGolpe(coordenadaAGolpear)).thenReturn(false);
    boolean resultado = partida.golpeaJugadorPersona(coordenadaAGolpear);

    //Assert
    Mockito.verify(mockJugadorIA).recibirGolpe(coordenadaAGolpear);
    Mockito.verify(mockJugadorPersona).registrarGolpe(coordenadaAGolpear, mockJugadorIA.obtenerTableroPrincipal());

    assertFalse(resultado);
  }

  @Test
  public void golpeaJugadorIA_expectedTrue() {
    // Verificar que la función golpeaJugadorIA llama correctamente a las funciones correspondientes
    // Simulamos que la funcion de golpear de jugadorIA devuelve true

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);
    Coordenada coordenadaAGolpear = new Coordenada(0, 0);

    // Act
    Mockito.when(mockJugadorPersona.recibirGolpe(coordenadaAGolpear)).thenReturn(true);
    Mockito.when(mockJugadorIA.golpear()).thenReturn(new Coordenada(0, 0));
    boolean resultado = partida.golpeaJugadorIA();

    // Assert
    Mockito.verify(mockJugadorPersona).recibirGolpe(coordenadaAGolpear);
    Mockito.verify(mockJugadorIA).registrarGolpe(coordenadaAGolpear, mockJugadorPersona.obtenerTableroPrincipal());
    assertTrue(resultado);
  }

  @Test
  public void golpeaJugadorIA_expectedFalse() {
    // Verificar que la función golpeaJugadorIA llama correctamente a las funciones correspondientes
    // Simulamos que la funcion de golpear de jugadorIA devuelve false

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);
    Coordenada coordenadaAGolpear = new Coordenada(0, 0);

    // Act
    Mockito.when(mockJugadorPersona.recibirGolpe(coordenadaAGolpear)).thenReturn(false);
    Mockito.when(mockJugadorIA.golpear()).thenReturn(coordenadaAGolpear);
    boolean resultado = partida.golpeaJugadorIA();

    // Assert
    Mockito.verify(mockJugadorPersona).recibirGolpe(coordenadaAGolpear);
    Mockito.verify(mockJugadorIA).registrarGolpe(coordenadaAGolpear, mockJugadorPersona.obtenerTableroPrincipal());
    assertFalse(resultado);
  }

  @Test
  public void cambiarTurno_primerCambio_turno2_expectedTrue() {
    // Verificar que se hace correctamente los cambios de turno de los jugadores
    // Cambiamos de turno1 a turno2

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    // Act
    partida.cambiarTurno();
    int resultado = partida.obtenerTurno();

    // Assert
    assertEquals(resultado, 2);
  }

  @Test
  public void cambiarTurno_segundoCambio_turno1_expectedTrue() {
    // Verificar que se hace correctamente los cambios de turno de los jugadores
    // Cambiamos de turno1 a turno2 y de turno2 a turno1

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    // Act
    partida.cambiarTurno();
    partida.cambiarTurno();
    int resultado = partida.obtenerTurno();

    // Assert
    assertEquals(resultado, 1);
  }

  @Test
  public void comprovarFinPartida1_expectedTrue() {
    // Verificar el fin de partida llamando a las funciones de comprobarTodosBarcosHundidos
    // comprobarBarcosHundidos devuelve true en jugadorPersona, es el ganador

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(true);
    Mockito.when(mockJugadorIA.comprobarTodosBarcosHundidos()).thenReturn(false);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void comprovarFinPartida2_expectedTrue() {
    // Verificar el fin de partida llamando a las funciones de comprobarTodosBarcosHundidos
    // comprobarBarcosHundidos devuelve true en jugadorIA, es el ganador

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(false);
    Mockito.when(mockJugadorIA.comprobarTodosBarcosHundidos()).thenReturn(true);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void comprovarFinPartida3_expectedTrue() {
    // Verificar el fin de partida llamando a las funciones de comprobarTodosBarcosHundidos
    // comprobarBarcosHundidos devuelve true en jugadorPersona y jugadorIA

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(true);
    Mockito.when(mockJugadorIA.comprobarTodosBarcosHundidos()).thenReturn(true);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void comprovarFinPartida4_expectedFalse() {
    // Verificar el fin de partida llamando a las funciones de comprobarTodosBarcosHundidos
    // comprobarBarcosHundidos devuelve false en jugadorPersona

    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(mockJugadorPersona, mockJugadorIA);
    partida.setDimensionTablero(10);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(false);
    Mockito.when(mockJugadorIA.comprobarTodosBarcosHundidos()).thenReturn(false);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertFalse(resultado);
  }
}