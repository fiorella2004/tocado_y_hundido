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
}