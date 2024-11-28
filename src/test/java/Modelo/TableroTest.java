package Modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

  @Test
  public void testObtenerTablero_instanceofArrayList_expectedTrue() {
    // Verifica que el tablero se ha creado correctamente

    // Arrange
    Tablero tablero = new Tablero(10);

    // Act
    ArrayList<Casilla> resultado = tablero.obtenerTablero();

    // Assert
    assertTrue(resultado instanceof ArrayList);
  }

  @Test
  public void testConstructorDimension10_expectedTrue() {
    // Verifica que se crea un tablero 10x10 si se le pasa
    // como dimensión = 10 (valor frontera)

    //Arrange
    Tablero tablero = new Tablero(10);

    //Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructorDimension9_expectedTrue() {
    // Verifica que se crea un tablero 10x10 si se le pasa
    // como dimensión = 9 (valor límite)

    //Arrange
    Tablero tablero = new Tablero(9);

    //Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructorDimension15_expectedTrue() {
    // Verifica que se crea un tablero 15x15 si se le pasa
    // como dimensión = 15 (valor frontera)

    //Arrange
    Tablero tablero = new Tablero(15);

    //Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(15, filas);
    assertEquals(15, columnas);
  }

  @Test
  public void testConstructorDimension16_expectedTrue() {
    // Verifica que se crea un tablero 15x15 si se le pasa
    // como dimensión = 16 (valor límite)

    //Arrange
    Tablero tablero = new Tablero(16);

    //Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(15, filas);
    assertEquals(15, columnas);
  }

  @Test
  public void testConstructorDimension12_expectedTrue() {
    // Verifica que se crea un tablero 12x12 si se le pasa
    // como dimensión = 12 (valor correcto)

    //Arrange
    Tablero tablero = new Tablero(12);

    //Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(12, filas);
    assertEquals(12, columnas);
  }

  @Test
  public void testConstructorDimension20_expectedTrue() {
    // Verifica que se crea un tablero 15x15 si se le pasa
    // como dimensión = 20 (valor incorrecto)

    //Arrange
    Tablero tablero = new Tablero(20);

    //Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(15, filas);
    assertEquals(15, columnas);
  }

  @Test
  public void testConstructorDimension11_expectedTrue() {
    // Verifica que se crea un tablero 11x11 si se le pasa
    // como dimensión = 11 (valor límite)

    //Arrange
    Tablero tablero = new Tablero(11);

    //Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(11, filas);
    assertEquals(11, columnas);
  }

  @Test
  public void testConstructorDimension14_expectedTrue() {
    // Verifica que se crea un tablero 14x14 si se le pasa
    // como dimensión = 14 (valor límite)

    //Arrange
    Tablero tablero = new Tablero(14);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(14, filas);
    assertEquals(14, columnas);
  }

  @Test
  public void testConstructorDimensionNegative_expectedTrue() {
    // Verifica que se crea un tablero 10x10 si se le pasa
    // como dimensión = -1 (valor incorrecto)

    //Arrange
    Tablero tablero = new Tablero(-1);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructorDimension0_expectedTrue() {
    // Verifica que se crea un tablero 10x10 si se le pasa
    // como dimensión = 0 (valor incorrecto)

    //Arrange
    Tablero tablero = new Tablero(0);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse
    // si está dentro de los márgenes del tablero

    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(1, 1));
    coordenadas.add(new Coordenada(1, 2));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaSupIzqHorizontal_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina superior izquierda del tablero en horizontal (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 0));
    coordenadas.add(new Coordenada(0, 1));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaSupIzqVertical_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina superior izquierda del tablero en vertical (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 0));
    coordenadas.add(new Coordenada(1, 0));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }


  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaSupDerHorizontal_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina superior derecha del tablero en horizontal (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 8));
    coordenadas.add(new Coordenada(0, 9));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaSupDerVertical_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina superior derecha del tablero en vertical (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 9));
    coordenadas.add(new Coordenada(1, 9));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaInfDerHorizontal_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina inferior derecha del tablero en horizontal (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(9, 8));
    coordenadas.add(new Coordenada(9, 9));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaInfDerVertical_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina inferior derecha del tablero en vertical (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(8, 9));
    coordenadas.add(new Coordenada(9, 9));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaInfIzqHorizontal_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina inferior izquierda del tablero en horizontal (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(9, 0));
    coordenadas.add(new Coordenada(9, 1));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_esquinaInfIzqVertical_expectedTrue() {
    // Verifica que un barco de 2 casillas pueda colocarse justamente en la
    // esquina inferior izquierda del tablero en vertical (valor frontera)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(8, 0));
    coordenadas.add(new Coordenada(9, 0));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_fueraTablero_esquinaSupIzq_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina superior izquierda del tablero (valor ímite)

    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 0));
    coordenadas.add(new Coordenada(-1, 0));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_fueraTablero_esquinaSupDer_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina superior derecha del tablero (valor ímite)

    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 9));
    coordenadas.add(new Coordenada(0, 10));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_fueraTablero_esquinaInfIzq_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina inferior izquierda del tablero (valor ímite)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(9, 0));
    coordenadas.add(new Coordenada(9, -1));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_fueraTablero_esquinaInfDer_expectedFalse() {
    // Verifica que un barco de 2 casillas no pueda colocarse más allá
    // de la esquina inferior derecha del tablero (valor ímite)

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(9, 9));
    coordenadas.add(new Coordenada(9, 10));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_solaparHorizontal_expectedFalse() {
    // Verifica que al colocar un barco de 2 casillas en horizontal
    // no se pueda colocar otro que solape con las casillas del primero

    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(1, 6));
    coordenadas1.add(new Coordenada(1, 7));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(1, 7));
    coordenadas2.add(new Coordenada(1, 8));

    // Act
    boolean resultado1 = tablero.colocarBarco(coordenadas1, 2);
    boolean resultado2 = tablero.colocarBarco(coordenadas2, 2);

    //Assert
    assertTrue(resultado1);
    assertFalse(resultado2);
  }

  @Test
  public void testColocarBarco2Casillas_solaparVertical_expectedFalse() {
    // Verifica que al colocar un barco de 2 casillas en vertical
    // no se pueda colocar otro que solape con las casillas del primero

    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(6, 1));
    coordenadas1.add(new Coordenada(7, 1));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(7, 1));
    coordenadas2.add(new Coordenada(8, 1));

    // Act
    boolean resultado1 = tablero.colocarBarco(coordenadas1, 2);
    boolean resultado2 = tablero.colocarBarco(coordenadas2, 2);

    //Assert
    assertTrue(resultado1);
    assertFalse(resultado2);
  }

  @Test
  public void testColocarBarco2Casillas_noSolapar_expectedTrue() {
    // Verifica que al colocar un barco de 2 casillas se pueda
    // colocar otro que no solape con las casillas del primero

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(1, 1));
    coordenadas1.add(new Coordenada(1, 2));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(2, 1));
    coordenadas2.add(new Coordenada(2, 2));

    // Act
    boolean resultado1 = tablero.colocarBarco(coordenadas1, 2);
    boolean resultado2 = tablero.colocarBarco(coordenadas2, 2);

    // Assert
    assertTrue(resultado1);
    assertTrue(resultado2);
  }

  @Test
  public void testBuscarCasilla_Agua_expectedNotNullAndEquals() {
    // Comprobar que se busque una casilla correctamente si
    // sus coordenadas están dentro del rango del tablero

    // Arrange
    Tablero tablero = new Tablero(10);
    Coordenada coordenada = new Coordenada(1, 1);
    Casilla casillaABuscar = new Agua(coordenada);

    // Act
    Casilla casillaEncontrada = tablero.buscarCasilla(coordenada);

    // Asssert
    assertNotNull(casillaEncontrada);
    assertEquals(casillaABuscar, casillaEncontrada);
  }

  @Test
  public void testBuscarCasilla_expectedNullAndNotEquals() {
    // Comprobar que al buscar una casilla que no está
    // dentro del rango del tablero se devuelva un null

    // Arrange
    Tablero tablero = new Tablero(10);
    Coordenada coordenada = new Coordenada(16, 20);
    Casilla casillaABuscar = new Agua(coordenada);

    // Act
    Casilla casillaEncontrada = tablero.buscarCasilla(coordenada);

    // Asssert
    assertNull(casillaEncontrada);
    assertNotEquals(casillaABuscar, casillaEncontrada);
  }

  @Test
  public void testRecibirGolpe_CasillaExiste_expectedTrue() {
    // Verificar que se golpee correctamente una casilla si
    // está dentro del rango del tablero

    // Arrange
    Tablero tablero = new Tablero(10);
    Coordenada coordenada = new Coordenada(1, 1);

    //Act
    boolean golpeada = tablero.recibirGolpe(coordenada);

    //Test
    assertTrue(golpeada);
  }

  @Test
  public void testRecibirGolpe_CasillaNoExiste_expectedFalse() {
    // Verificar que no se golpee una casilla si
    // no está dentro del rango del tablero

    // Arrange
    Tablero tablero = new Tablero(10);
    Coordenada coordenada = new Coordenada(20, 20);

    //Act
    boolean golpeada = tablero.recibirGolpe(coordenada);

    //Test
    assertFalse(golpeada);
  }

  @Test
  public void testRecibirGolpe_CasillaNull_expectedFalse() {
    // Verificar que no se golpee una casilla si no existe

    // Arrange
    Tablero tablero = new Tablero(10);
    Coordenada coordenada = null;

    //Act
    boolean golpeada = tablero.recibirGolpe(coordenada);

    //Test
    assertFalse(golpeada);
  }

  @Test
  public void testRecibirGolpe_CasillaYaGolpeada_expectedFalse() {
    // Verificar que no se golpee una casilla si ya está golpeada

    // Arrange
    Tablero tablero = new Tablero(10);
    Coordenada coordenada = new Coordenada(2, 2);

    //Act
    boolean golpeada = tablero.recibirGolpe(coordenada);
    boolean golpeada2 = tablero.recibirGolpe(coordenada);

    //Test
    assertTrue(golpeada);
    assertFalse(golpeada2);
  }

  @Test
  public void testTodosBarcosHundidos1Barco_expectedTrue() {
    // Verifica que se devuelva true si todos los barcos están hundidos

    // Arrange
    Tablero tablero = new Tablero(10);
    // Barco de 2 coordenadas
    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coord1 = new Coordenada(0, 1);
    Coordenada coord2 = new Coordenada(0, 2);
    coords.add(coord1);
    coords.add(coord2);
    tablero.colocarBarco(coords, 2);

    // Act
    tablero.recibirGolpe(coord1); // Golpe 1 de 2
    tablero.recibirGolpe(coord2); // Golpe 2 de 2
    boolean resultado = tablero.comprobarTodosBarcosHundidos();

    // Test
    assertTrue(resultado);
  }

  @Test
  public void testTodosBarcosHundidos5Barcos_expectedTrue() {
    // Verifica que se devuelva true si todos los barcos están hundidos

    // Arrange
    Tablero tablero = new Tablero(10);
    // Barco de 2 coordenadas
    ArrayList<Coordenada> coords1 = new ArrayList<>();
    coords1.add(new Coordenada(0, 1));
    coords1.add(new Coordenada(0, 2));
    tablero.colocarBarco(coords1, 2);
    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords2 = new ArrayList<>();
    coords2.add(new Coordenada(1, 1));
    coords2.add(new Coordenada(1, 2));
    coords2.add(new Coordenada(1, 3));
    tablero.colocarBarco(coords2, 3);
    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords3 = new ArrayList<>();
    coords3.add(new Coordenada(2, 1));
    coords3.add(new Coordenada(2, 2));
    coords3.add(new Coordenada(2, 3));
    tablero.colocarBarco(coords3, 3);
    // Barco de 4 coordenadas
    ArrayList<Coordenada> coords4 = new ArrayList<>();
    coords4.add(new Coordenada(3, 1));
    coords4.add(new Coordenada(3, 2));
    coords4.add(new Coordenada(3, 3));
    coords4.add(new Coordenada(3, 4));
    tablero.colocarBarco(coords4, 4);
    // Barco de 5 coordenadas
    ArrayList<Coordenada> coords5 = new ArrayList<>();
    coords5.add(new Coordenada(4, 1));
    coords5.add(new Coordenada(4, 2));
    coords5.add(new Coordenada(4, 3));
    coords5.add(new Coordenada(4, 4));
    coords5.add(new Coordenada(4, 5));
    tablero.colocarBarco(coords5, 5);

    // Act
    for (Coordenada coord : coords1) {
      tablero.recibirGolpe(coord);
    }
    for (Coordenada coord : coords2) {
      tablero.recibirGolpe(coord);
    }
    for (Coordenada coord : coords3) {
      tablero.recibirGolpe(coord);
    }
    for (Coordenada coord : coords4) {
      tablero.recibirGolpe(coord);
    }
    for (Coordenada coord : coords5) {
      tablero.recibirGolpe(coord);
    }
    boolean resultado = tablero.comprobarTodosBarcosHundidos();

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testTodosBarcosHundidos1Barco_expectedFalse() {
    // Verifica que se devuelva false si todos
    // los barcos no están hundidos

    //Arrange
    Tablero tablero = new Tablero(10);
    // Barco de 2 coordenadas
    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada = new Coordenada(0, 1);
    Coordenada coordenada2 = new Coordenada(0, 2);
    coords.add(coordenada);
    coords.add(coordenada2);
    tablero.colocarBarco(coords, 2);
    tablero.recibirGolpe(coordenada); // Golpe 1 de 2

    // Act
    boolean resultado = tablero.comprobarTodosBarcosHundidos();

    // Test
    assertFalse(resultado);
  }

  @Test
  public void testTodosBarcosHundidos5Barcos_expectedFalse() {
    // Verifica que se devuelva false si todos
    // los barcos no están hundidos

    // Arrange
    Tablero tablero = new Tablero(10);
    // Barco de 2 coordenadas
    ArrayList<Coordenada> coords1 = new ArrayList<>();
    coords1.add(new Coordenada(0, 1));
    coords1.add(new Coordenada(0, 2));
    tablero.colocarBarco(coords1, 2);
    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords2 = new ArrayList<>();
    coords2.add(new Coordenada(1, 1));
    coords2.add(new Coordenada(1, 2));
    coords2.add(new Coordenada(1, 3));
    tablero.colocarBarco(coords2, 3);
    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords3 = new ArrayList<>();
    coords3.add(new Coordenada(2, 1));
    coords3.add(new Coordenada(2, 2));
    coords3.add(new Coordenada(2, 3));
    tablero.colocarBarco(coords3, 3);
    // Barco de 4 coordenadas
    ArrayList<Coordenada> coords4 = new ArrayList<>();
    coords4.add(new Coordenada(3, 1));
    coords4.add(new Coordenada(3, 2));
    coords4.add(new Coordenada(3, 3));
    coords4.add(new Coordenada(3, 4));
    tablero.colocarBarco(coords4, 4);
    // Barco de 5 coordenadas
    ArrayList<Coordenada> coords5 = new ArrayList<>();
    coords5.add(new Coordenada(4, 1));
    coords5.add(new Coordenada(4, 2));
    coords5.add(new Coordenada(4, 3));
    coords5.add(new Coordenada(4, 4));
    coords5.add(new Coordenada(4, 5));
    tablero.colocarBarco(coords5, 5);

    // Act
    for (Coordenada coord : coords1) {
      tablero.recibirGolpe(coord);
    }
    for (Coordenada coord : coords2) {
      tablero.recibirGolpe(coord);
    }
    for (Coordenada coord : coords3) {
      tablero.recibirGolpe(coord);
    }
    for (Coordenada coord : coords4) {
      tablero.recibirGolpe(coord);
    }
    boolean resultado = tablero.comprobarTodosBarcosHundidos();

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarCoordenadasContiguas_filaNoContigua_expectedFalse() {
    // Verifica que no se coloque un barco si sus
    // coordenadas no tiene las filas contiguas

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0, 0);
    Coordenada coordenada2 = new Coordenada(2, 0);
    coords.add(coordenada1);
    coords.add(coordenada2);

    // Act
    boolean resultado = tablero.colocarBarco(coords, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarCoordenadasContiguas_columnaNoContigua_expectedFalse() {
    // Verifica que no se coloque un barco si sus
    // coordenadas no tiene las columnas contiguas

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0, 0);
    Coordenada coordenada2 = new Coordenada(0, 2);
    coords.add(coordenada1);
    coords.add(coordenada2);

    // Act
    boolean resultado = tablero.colocarBarco(coords, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarCoordenadasContiguas_diagonal_expectedFalse() {
    // Verifica que no se coloque un barco si sus
    // coordenadas están en diagonal

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0, 1);
    Coordenada coordenada2 = new Coordenada(1, 0);
    coords.add(coordenada1);
    coords.add(coordenada2);

    // Act
    boolean resultado = tablero.colocarBarco(coords, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarCoordenadasContiguas_tamanoIncorrecto_expectedFalse() {
    // Verifica que no se coloque un barco si el total de sus
    // coordenadas no coincide con el tamaño del barco

    // Arrange
    Tablero tablero = new Tablero(10);
    // Crear un barco de 3 coordenadas
    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0, 0);
    Coordenada coordenada2 = new Coordenada(0, 1);
    Coordenada coordenada3 = new Coordenada(0, 2);
    coords.add(coordenada1);
    coords.add(coordenada2);
    coords.add(coordenada3);

    // Act
    boolean resultado = tablero.colocarBarco(coords, 2);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testComprobarCoordenadasContiguas_expectedTrue() {
    // Verifica que se coloque un barco si sus coordenadas son correctas

    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada1 = new Coordenada(0, 1);
    Coordenada coordenada2 = new Coordenada(0, 0);
    coords.add(coordenada1);
    coords.add(coordenada2);

    // Act
    boolean resultado = tablero.colocarBarco(coords, 2);

    // Assert
    assertTrue(resultado);
  }
}