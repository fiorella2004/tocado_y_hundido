package Controlador;

import static org.junit.jupiter.api.Assertions.*;

import Modelo.Coordenada;
import Modelo.JugadorIA;
import Modelo.JugadorPersona;
import Modelo.Partida;
import Vista.VistaConsola;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

class ControladorTest {

  @Test
  public void constructorControlador_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);

    // Act
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Mockito.doNothing().when(mockPartida).setDimensionTablero(10);
    Mockito.doNothing().when(mockPartida).colocarBarcosIA();
    Mockito.doNothing().when(mockVista).setPartida(mockPartida);
    Mockito.doNothing().when(mockVista).mostrarTableros();
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);

    // Assert
    assertTrue(controlador instanceof Controlador);
    Mockito.verify(mockPartida).colocarBarcosIA();
    Mockito.verify(mockVista).setPartida(mockPartida);
    Mockito.verify(mockVista).mostrarTableros();
    assertNotNull(controlador.getPartida());
    assertNotNull(controlador.getVistaConsola());
    assertNotNull(controlador.getJugadorPersona());
    assertNotNull(controlador.getJugadorIA());
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero10_barco2casillas_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "0A 0B";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero10_barco5casillas_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "0A 0B 0C 0D 0E";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 5);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero15_barco2casillas_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(15);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "14A 14B";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero15_barco5casillas_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(15);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "14A 14B 14C 14D 14E";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 5);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero10_barco2casillas_numeroFueraDeRango_expectedFalse() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "10A 10B";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero10_barco5casillas_letraFueraDeRango_expectedFalse() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "0P 0Q 0R 0S 0T";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 5);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero15_barco2casillas_cantidadIncorrecta_expectedFalse() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(15);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "14A";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero15_barco5casillas_sinEspacios_expectedFalse() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(15);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "14A14B14C14D14E";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 5);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero15_barco5casillas_coordenadasPequeñas_expectedFalse() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(15);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "0A 0B 0C 0D 0E";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 5);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero10_barco2casillas_letraAntesQueNumero_expectedFalse() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    String input = "A0 B0";

    // Act
    boolean resultado = controlador.comprobarFormatoCoordenadas(input, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  void testParsearCoordenada_2Caracteres_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);

    // Act
    Coordenada coordenada = controlador.parsearCoordenada("0A");

    // Assert
    assertEquals(0, coordenada.getFila());
    assertEquals(0, coordenada.getCol());
  }

  @Test
  void testParsearCoordenada_3Caracteres_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);

    // Act
    Coordenada coordenada = controlador.parsearCoordenada("10A");

    // Assert
    assertEquals(10, coordenada.getFila());
    assertEquals(0, coordenada.getCol());
  }

  @Test
  public void testColocarBarcosJugadorPersona_expectedTrue() {
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);

    Mockito.when(mockVista.pedirColocarBarco(2)).thenReturn("0A 0B");
    ArrayList<Coordenada> coords1 = new ArrayList<>();
    coords1.add(new Coordenada(0,0));
    coords1.add(new Coordenada(0,1));

    Mockito.when(mockVista.pedirColocarBarco(3))
        .thenReturn("1A 1B 1C")
        .thenReturn("2A 2B 2C");

    ArrayList<Coordenada> coords2 = new ArrayList<>();
    coords2.add(new Coordenada(1,0));
    coords2.add(new Coordenada(1,1));
    coords2.add(new Coordenada(1,2));

    ArrayList<Coordenada> coords3 = new ArrayList<>();
    coords3.add(new Coordenada(2,0));
    coords3.add(new Coordenada(2,1));
    coords3.add(new Coordenada(2,2));

    Mockito.when(mockVista.pedirColocarBarco(4)).thenReturn("3A 3B 3C 3D");
    ArrayList<Coordenada> coords4 = new ArrayList<>();
    coords4.add(new Coordenada(3, 0));
    coords4.add(new Coordenada(3, 1));
    coords4.add(new Coordenada(3, 2));
    coords4.add(new Coordenada(3, 3));

    Mockito.when(mockVista.pedirColocarBarco(5)).thenReturn("4A 4B 4C 4D 4E");
    ArrayList<Coordenada> coords5 = new ArrayList<>();
    coords5.add(new Coordenada(4, 0));
    coords5.add(new Coordenada(4, 1));
    coords5.add(new Coordenada(4, 2));
    coords5.add(new Coordenada(4, 3));
    coords5.add(new Coordenada(4, 4));

    Mockito.when(mockPartida.colocarBarcoJugador(coords1, 2)).thenReturn(true);
    Mockito.when(mockPartida.colocarBarcoJugador(coords2, 3)).thenReturn(true);
    Mockito.when(mockPartida.colocarBarcoJugador(coords3, 3)).thenReturn(true);
    Mockito.when(mockPartida.colocarBarcoJugador(coords4, 4)).thenReturn(true);
    Mockito.when(mockPartida.colocarBarcoJugador(coords5, 5)).thenReturn(true);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);

    // Act
    controlador.colocarBarcosJugadorPersona();

    // Assert
    Mockito.verify(mockVista).pedirColocarBarco(2);
    Mockito.verify(mockVista, Mockito.times(2)).pedirColocarBarco(3);
    Mockito.verify(mockVista).pedirColocarBarco(4);
    Mockito.verify(mockVista).pedirColocarBarco(5);

    Mockito.verify(mockPartida).colocarBarcoJugador(coords1,2);
    Mockito.verify(mockPartida).colocarBarcoJugador(coords2,3);
    Mockito.verify(mockPartida).colocarBarcoJugador(coords3,3);
    Mockito.verify(mockPartida).colocarBarcoJugador(coords4,4);
    Mockito.verify(mockPartida).colocarBarcoJugador(coords5,5);

    // El tablero se muestra 5 veces + 1 vez en el constructor
    Mockito.verify(mockVista, Mockito.times(6)).mostrarTableros();
  }

  @Test
  public void comenzarPartida_NoFinPartida_TurnoJugador1(){
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);

    Mockito.when(mockPartida.comprovarFinPartida())
        .thenReturn(false)
        .thenReturn(true);
    Mockito.when(mockPartida.obtenerTurno()).thenReturn(1);
    Mockito.when(mockVista.pedirGolpe()).thenReturn("1A");
    Coordenada coordenadaGolpear = new Coordenada(1, 0);
    Mockito.when(mockPartida.golpeaJugadorPersona(coordenadaGolpear)).thenReturn(true);
    Mockito.doNothing().when(mockVista).mostrarTableros();

    // Act
    controlador.comenzarPartida();

    // Assert
    Mockito.verify(mockVista).mostrarMensajeInicioJuego();
    Mockito.verify(mockPartida, Mockito.times(2)).comprovarFinPartida();
    Mockito.verify(mockVista).pedirGolpe();
    Mockito.verify(mockPartida).golpeaJugadorPersona(coordenadaGolpear);
    Mockito.verify(mockVista).mostrarTableros();
    Mockito.verify(mockPartida).cambiarTurno();
  }

  @Test
  public void comenzarPartida_NoFinPartida_TurnoJugador2(){
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);

    //Act
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    Mockito.doNothing().when(mockVista).mostrarMensajeInicioJuego();
    Mockito.when(mockPartida.comprovarFinPartida())
        .thenReturn(false)
        .thenReturn(true);
    Mockito.when(mockPartida.obtenerTurno()).thenReturn(2);
    Mockito.doNothing().when(mockVista).mostrarMensajeTurnoIA();
    Mockito.when(mockPartida.golpeaJugadorIA()).thenReturn(true);
    Mockito.doNothing().when(mockVista).mostrarTableros();

    controlador.comenzarPartida();

    //Assert
    Mockito.verify(mockPartida).comprovarFinPartida();
    Mockito.verify(mockVista).mostrarMensajeInicioJuego();
    Mockito.verify(mockVista).mostrarTableros();
  }

  @Test
  public void comenzarPartida_FinPartida(){
    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);

    //Act
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);
    Mockito.doNothing().when(mockVista).mostrarMensajeInicioJuego();
    Mockito.when(mockPartida.comprovarFinPartida()).thenReturn(true);
    Mockito.doNothing().when(mockVista).mostrarMensajeFinJuego();
    controlador.comenzarPartida();

    //Assert
    Mockito.verify(mockVista).mostrarMensajeFinJuego();
    Mockito.verify(mockPartida).comprovarFinPartida();
  }
}