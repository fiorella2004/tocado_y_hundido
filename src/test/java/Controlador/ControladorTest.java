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
    // Verificamos que se construye correctamente un objeto de Controlador
    // Utilizamos mockito para los objetos de las clases que recibe el constructor
    // Comprobamos que se realizan las llamadas que aparecen dentro del constructor

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce bien las coordendas
    // Dimension tablero: 10; Dimension barco: 2; Esquina superior derecha (valor limite)

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce bien las coordendas
    // Dimension tablero: 10; Dimension barco: 5; Esquina superior derecha (valor limite)

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce bien las coordendas
    // Dimension tablero: 15; Dimension barco: 2; Esquina superior izquierda (valor limite)

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce bien las coordendas
    // Dimension tablero: 15; Dimension barco: 5; Esquina superior izquierda (valor limite)

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce fila coordenada fuera de rango
    // Dimension tablero: 10; Dimension barco: 2; (valor frontera)

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce columna coordenada fuera de rango
    // Dimension tablero: 10; Dimension barco: 2; (valor frontera)

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce numero de coordenadas incorrecto
    // Dimension tablero: 15; Dimension barco: 2;

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
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce coordenadas sin espacios
    // Dimension tablero: 15; Dimension barco: 5;

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
  public void testComprobarFormatoCoordenadas_dimTablero15_barco5casillas_coordenadasPequeñas_expectedTrue() {
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce numero de coordenadas de forma correcta
    // Dimension tablero: 15; Dimension barco: 2; esquina superior izquierda (valor frontera)

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
    assertTrue(resultado);
  }

  @Test
  public void testComprobarFormatoCoordenadas_dimTablero10_barco2casillas_letraAntesQueNumero_expectedFalse() {
    // Verifica que las coordenadas introducidas por el usuario se introducen correctamente
    // Usuario introduce la columna antes que la letra
    // Dimension tablero: 10; Dimension barco: 2;

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
  public void testParsearCoordenada_2Caracteres_expectedTrue() {
    // Verifica que las coordenadas introducidas por el usuario (String) se convierten correctamente a un objeto de la clase Coordenada
    // Coordenada de 2 caracteres (ejemplo 0A)

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
  public void testParsearCoordenada_3Caracteres_expectedTrue() {
    // Verifica que las coordenadas introducidas por el usuario (String) se convierten correctamente a un objeto de la clase Coordenada
    // Coordenada de 3 caracteres (ejemplo 10A)

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
    // Verifica que se realizan las correspondientes llamadas dentro del metodo colocarBarcosJugador
    // Simulamos las coordenadas introducidas por el usuario

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
  public void testColocarBarcosJugadorPersonaIncFilaIntento1_expectedTrue() {
    // Verifica que se realizan las correspondientes llamadas dentro del metodo colocarBarcosJugador
    // Usuario introduce mal la primera coordenada

    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(11);

    Mockito.when(mockVista.pedirColocarBarco(2))
        .thenReturn("AA AA")
        .thenReturn("0A 0B");
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
    Mockito.verify(mockVista, Mockito.times(2)).pedirColocarBarco(2);
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
  public void testColocarBarcosJugadorPersonaFilaFueraRango3CaracteresIntento1_expectedTrue() {
    // Verifica que se realizan las correspondientes llamadas dentro del metodo colocarBarcosJugador
    // Usuario introduce mal la primera coordenada, fuera de rango

    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(12);

    Mockito.when(mockVista.pedirColocarBarco(2))
        .thenReturn("13A 13B")
        .thenReturn("0A 0B");
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
    Mockito.verify(mockVista, Mockito.times(2)).pedirColocarBarco(2);
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
  public void testColocarBarcosJugadorPersonaInc3caracteresIntento1_expectedTrue() {
    // Verifica que se realizan las correspondientes llamadas dentro del metodo colocarBarcosJugador
    // Usuario introduce mal una coordenada

    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(15);

    Mockito.when(mockVista.pedirColocarBarco(2))
        .thenReturn("12A 1AA")
        .thenReturn("0A 0B");
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
    Mockito.verify(mockVista, Mockito.times(2)).pedirColocarBarco(2);
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
  public void testColocarBarcosJugadorPersonaSolapaBarco1Intento_expectedTrue() {
    // Verifica que se realizan las correspondientes llamadas dentro del metodo colocarBarcosJugador
    // Usuario introduce correctamente coordenadas pero alguna de ellas se solapa con un barco ya colocado

    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(11);

    Mockito.when(mockVista.pedirColocarBarco(2)).thenReturn("0A 0B");
    ArrayList<Coordenada> coords1 = new ArrayList<>();
    coords1.add(new Coordenada(0,0));
    coords1.add(new Coordenada(0,1));

    Mockito.when(mockVista.pedirColocarBarco(3))
        .thenReturn("0B 0C 0D")
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
    Mockito.verify(mockVista, Mockito.times(3)).pedirColocarBarco(3);
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
    //Comprobamos que el metodo comenzarPartida llama al metodo turnoJudador1 cuando es su turno

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
    Mockito.verify(mockVista, Mockito.times(2)).mostrarTableros();
    Mockito.verify(mockPartida).cambiarTurno();
  }

  @Test
  public void comenzarPartida_NoFinPartida_TurnoJugador1_GolpeRepetido(){
    // Comprobamos que el metodo comenzarPartida llama al metodo turnoJudador1 cuando es su turno
    // Jugador1 introduce una coordenada que ya ha golpeada, se le vuelve a pedir que introduza una coordenada

    // Arrange
    Partida mockPartida = Mockito.mock(Partida.class);
    JugadorIA mockJugadorIA = Mockito.mock(JugadorIA.class);
    JugadorPersona mockJugadorPersona = Mockito.mock(JugadorPersona.class);
    VistaConsola mockVista = Mockito.mock(VistaConsola.class);
    Mockito.when(mockVista.pedirDimensionTablero()).thenReturn(10);
    Controlador controlador = new Controlador(mockVista, mockPartida, mockJugadorPersona, mockJugadorIA);

    Mockito.when(mockPartida.comprovarFinPartida())
        .thenReturn(false)
        .thenReturn(false)
        .thenReturn(false)
        .thenReturn(true);
    Mockito.when(mockPartida.obtenerTurno()).thenReturn(1);

    Mockito.when(mockVista.pedirGolpe())
        .thenReturn("1A")
        .thenReturn("1A")
        .thenReturn("1B");
    Coordenada coordenadaGolpear = new Coordenada(1, 0);
    Mockito.when(mockPartida.golpeaJugadorPersona(coordenadaGolpear))
        .thenReturn(true)
        .thenReturn(false);

    Coordenada coordenadaGolpear2 = new Coordenada(1, 1);
    Mockito.when(mockPartida.golpeaJugadorPersona(coordenadaGolpear2)).thenReturn(true);

    Mockito.doNothing().when(mockVista).mostrarTableros();

    Mockito.doNothing().when(mockVista).mostrarTableros();

    // Act
    controlador.comenzarPartida();

    // Assert
    Mockito.verify(mockVista).mostrarMensajeInicioJuego();
    Mockito.verify(mockPartida, Mockito.times(4)).comprovarFinPartida();
    Mockito.verify(mockVista, Mockito.times(4)).pedirGolpe();
    Mockito.verify(mockPartida, Mockito.times(2)).golpeaJugadorPersona(coordenadaGolpear);
    Mockito.verify(mockVista, Mockito.times(4)).mostrarTableros();
    Mockito.verify(mockPartida, Mockito.times(3)).cambiarTurno();
  }

  @Test
  public void comenzarPartida_NoFinPartida_TurnoJugador1_GolpeFormatoIncorrecto(){
    // Comprobamos que el metodo comenzarPartida llama al metodo turnoJudador1 cuando es su turno
    // Jugador1 introduce una coordenada con un formato incorrecto

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

    Mockito.when(mockVista.pedirGolpe())
        .thenReturn("AA")
        .thenReturn("1A");
    Coordenada coordenadaGolpear = new Coordenada(1, 0);
    Mockito.when(mockPartida.golpeaJugadorPersona(coordenadaGolpear)).thenReturn(true);
    Mockito.doNothing().when(mockVista).mostrarTableros();

    // Act
    controlador.comenzarPartida();

    // Assert
    Mockito.verify(mockVista).mostrarMensajeInicioJuego();
    Mockito.verify(mockPartida, Mockito.times(2)).comprovarFinPartida();
    Mockito.verify(mockVista, Mockito.times(2)).pedirGolpe();
    Mockito.verify(mockPartida).golpeaJugadorPersona(coordenadaGolpear);
    Mockito.verify(mockVista, Mockito.times(2)).mostrarTableros();
    Mockito.verify(mockPartida).cambiarTurno();
  }

  @Test
  public void comenzarPartida_NoFinPartida_TurnoJugador2(){
    // Comprobamos que el metodo comenzarPartida llama al metodo turnoJudador2 cuando es su turno

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
    Mockito.verify(mockPartida, Mockito.times(2)).comprovarFinPartida();
    Mockito.verify(mockVista).mostrarMensajeInicioJuego();
    Mockito.verify(mockVista, Mockito.times(2)).mostrarTableros();
  }

  @Test
  public void comenzarPartida_FinPartida(){
    // Comprobamos finPartida

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