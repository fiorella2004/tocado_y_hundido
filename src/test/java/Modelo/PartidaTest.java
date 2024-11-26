package Modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

  @Test
  public void constructorPartida_expectedTrue(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    // Act
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);

    //Assert
    Mockito.verify(mockJugadorPersona).asignarTablerosVacios(10);
    Mockito.verify(mockJugadorIA).asignarTablerosVacios(10);
    assertEquals(mockJugadorIA, partida.getjugadorIA());
    assertEquals(mockJugadorPersona, partida.getJugadorPersona());
  }

  @Test
  public void colocarBarcoJugador_expectedTrue(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0,0);
    Coordenada coordenada2 = new Coordenada(1,0);
    coordenadasBarco.add(coordenada1);
    coordenadasBarco.add(coordenada2);

    // Act
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);
    Mockito.when(mockJugadorPersona.colocarBarco(coordenadasBarco, 2)).thenReturn(true);
    boolean resultado = partida.colocarBarcoJugador(coordenadasBarco, 2);

    //Assert
    assertTrue(resultado);
    Mockito.verify(mockJugadorPersona).colocarBarco(coordenadasBarco, 2);
  }

  @Test
  public void colocarBarcoJugador_expectedFalse(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    ArrayList<Coordenada> coordenadasBarco = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0,0);
    Coordenada coordenada2 = new Coordenada(1,0);
    coordenadasBarco.add(coordenada1);
    coordenadasBarco.add(coordenada2);

    // Act
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);
    Mockito.when(mockJugadorPersona.colocarBarco(coordenadasBarco, 2)).thenReturn(false);
    boolean resultado = partida.colocarBarcoJugador(coordenadasBarco, 2);

    //Assert
    assertFalse(resultado);
    Mockito.verify(mockJugadorPersona).colocarBarco(coordenadasBarco, 2);
  }

  @Test
  public void colocarBarcosIA_verifyMethod() {
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 0));

    // Act
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 2)).thenReturn(true);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 3)).thenReturn(true);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 4)).thenReturn(true);
    Mockito.when(mockJugadorIA.colocarBarco(coordenadas, 5)).thenReturn(true);
    partida.colocarBarcosIA();

    //Assert
    Mockito.verify(mockJugadorIA).colocarBarco(coordenadas, 2);
  }

  @Test
  public void golpeaJugadorPersona_expectedTrue(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);
    Coordenada coordenadaAGolpear = new Coordenada(0,0);

    // Act
    Mockito.when(mockJugadorIA.recibirGolpe(coordenadaAGolpear)).thenReturn(true);
    boolean resultado = partida.golpeaJugadorPersona(coordenadaAGolpear);

    //Assert
    Mockito.verify(mockJugadorIA).recibirGolpe(coordenadaAGolpear);
    Mockito.verify(mockJugadorPersona).registrarGolpe(coordenadaAGolpear, mockJugadorIA.obtenerTableroPrincipal());

    assertTrue(resultado);

  }

  @Test
  public void golpeaJugadorPersona_expectedFalse(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);
    Coordenada coordenadaAGolpear = new Coordenada(0,0);

    // Act
    Mockito.when(mockJugadorIA.recibirGolpe(coordenadaAGolpear)).thenReturn(false);
    boolean resultado = partida.golpeaJugadorPersona(coordenadaAGolpear);

    //Assert
    Mockito.verify(mockJugadorIA).recibirGolpe(coordenadaAGolpear);
    Mockito.verify(mockJugadorPersona).registrarGolpe(coordenadaAGolpear, mockJugadorIA.obtenerTableroPrincipal());

    assertFalse(resultado);
  }

  @Test
  public void golpeaJugadorIA_expectedTrue(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);
    Coordenada coordenadaAGolpear = new Coordenada(0,0);

    // Act
    Mockito.when(mockJugadorPersona.recibirGolpe(coordenadaAGolpear)).thenReturn(true);
    Mockito.when(mockJugadorIA.golpear()).thenReturn(new Coordenada(0,0));
    boolean resultado = partida.golpeaJugadorIA();

    // Assert
    Mockito.verify(mockJugadorPersona).recibirGolpe(coordenadaAGolpear);
    Mockito.verify(mockJugadorIA).registrarGolpe(coordenadaAGolpear, mockJugadorPersona.obtenerTableroPrincipal());
    assertTrue(resultado);
  }

  @Test
  public void golpeaJugadorIA_expectedFalse(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);
    Coordenada coordenadaAGolpear = new Coordenada(0,0);

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
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);

    // Act
    partida.cambiarTurno();
    int resultado = partida.obtenerTurno();

    // Assert
    assertEquals(resultado, 2);
  }

  @Test
  public void cambiarTurno_segundoCambio_turno1_expectedTrue() {
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);

    // Act
    partida.cambiarTurno();
    int resultado = partida.obtenerTurno();

    // Assert
    assertEquals(resultado, 1);
  }

  @Test
  public void comprovarFinPartida1_expectedTrue(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(true);
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(false);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void comprovarFinPartida2_expectedTrue(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(false);
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(true);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void comprovarFinPartida3_expectedTrue(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(true);
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(false);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void comprovarFinPartida2_expectedFalse(){
    // Arrange
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    Partida partida = new Partida(10, mockJugadorPersona, mockJugadorIA);

    // Act
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(false);
    Mockito.when(mockJugadorPersona.comprobarTodosBarcosHundidos()).thenReturn(false);
    boolean resultado = partida.comprovarFinPartida();

    //Assert
    assertFalse(resultado);
  }
}