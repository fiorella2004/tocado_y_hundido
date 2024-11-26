package org.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

  @Test
  public void testConstructorDimension10_expectedTrue() {
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
    //Arrange
    Tablero tablero = new Tablero(0);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  // ---- COLOCAR BARCO CON 2 CASILLAS

  @Test
  public void testColocarBarco2Casillas_dentroTablero_expectedTrue() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(1, 1));
    coordenadas.add(new Coordenada(1, 2));

    // Act
    tablero.colocarBarco(coordenadas);
    boolean resultado = tablero.comprobarBarcoDentroTablero(coordenadas);

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_limitePrimeraFila_expectedTrue() {
    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(0, 0));
    coordenadas.add(new Coordenada(0, 1));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_limiteHorizontal_expectedTrue() {
    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(9, 8));
    coordenadas.add(new Coordenada(9, 9));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_dentroTablero_limiteVertical_expectedTrue() {
    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(8, 9));
    coordenadas.add(new Coordenada(9, 9));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas);

    // Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_fueraTableroHorizontal_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(1, 10));
    coordenadas.add(new Coordenada(1, 11));

    // Act
    tablero.colocarBarco(coordenadas);
    boolean resultado = tablero.comprobarBarcoDentroTablero(coordenadas);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_fueraTableroVertical_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(10, 1));
    coordenadas.add(new Coordenada(11, 1));

    // Act
    tablero.colocarBarco(coordenadas);
    boolean resultado = tablero.comprobarBarcoDentroTablero(coordenadas);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_fueraTableroNegativo_expectedFalse() {
    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(-1, -1));
    coordenadas.add(new Coordenada(-1, 0));

    // Act
    boolean resultado = tablero.colocarBarco(coordenadas);

    // Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_solaparHorizontal_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(1, 6));
    coordenadas1.add(new Coordenada(1, 7));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(1, 7));
    coordenadas2.add(new Coordenada(1, 8));

    // Act
    tablero.colocarBarco(coordenadas1);
    boolean resultado = tablero.comprobarSolaparBarco(coordenadas2);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_solaparVertical_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(6, 1));
    coordenadas1.add(new Coordenada(7, 1));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(7, 1));
    coordenadas2.add(new Coordenada(8, 1));

    // Act
    tablero.colocarBarco(coordenadas1);
    boolean resultado = tablero.comprobarSolaparBarco(coordenadas2);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_noSolapar_expectedTrue() {
    // Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(1, 1));
    coordenadas1.add(new Coordenada(1, 2));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(2, 1));
    coordenadas2.add(new Coordenada(2, 2));

    // Act
    tablero.colocarBarco(coordenadas1);
    boolean resultado = tablero.colocarBarco(coordenadas2);

    // Assert
    assertTrue(resultado);
  }

  // ---- COLOCAR BARCO CON 5 CASILLAS

  @Test
  public void testColocarBarco5Casillas_dentroTablero_expectedTrue() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(1, 1));
    coordenadas.add(new Coordenada(1, 2));
    coordenadas.add(new Coordenada(1, 3));
    coordenadas.add(new Coordenada(1, 4));
    coordenadas.add(new Coordenada(1, 5));

    // Act
    tablero.colocarBarco(coordenadas);
    boolean resultado = tablero.comprobarBarcoDentroTablero(coordenadas);

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco5Casillas_fueraTableroHorizontal_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(1, 7));
    coordenadas.add(new Coordenada(1, 8));
    coordenadas.add(new Coordenada(1, 9));
    coordenadas.add(new Coordenada(1, 10));
    coordenadas.add(new Coordenada(1, 11));
    // Act
    tablero.colocarBarco(coordenadas);
    boolean resultado = tablero.comprobarBarcoDentroTablero(coordenadas);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco5Casillas_fueraTableroVertical_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(7, 1));
    coordenadas.add(new Coordenada(8, 1));
    coordenadas.add(new Coordenada(9, 1));
    coordenadas.add(new Coordenada(10, 1));
    coordenadas.add(new Coordenada(11, 1));

    // Act
    tablero.colocarBarco(coordenadas);
    boolean resultado = tablero.comprobarBarcoDentroTablero(coordenadas);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco5Casillas_solaparHorizontal_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(1, 1));
    coordenadas1.add(new Coordenada(1, 2));
    coordenadas1.add(new Coordenada(1, 3));
    coordenadas1.add(new Coordenada(1, 4));
    coordenadas1.add(new Coordenada(1, 5));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(1, 5));
    coordenadas2.add(new Coordenada(1, 6));
    coordenadas2.add(new Coordenada(1, 7));
    coordenadas2.add(new Coordenada(1, 8));
    coordenadas2.add(new Coordenada(1, 9));

    // Act
    tablero.colocarBarco(coordenadas1);
    boolean resultado = tablero.comprobarSolaparBarco(coordenadas2);

    //Assert
    assertFalse(resultado);
  }

  @Test
  public void testColocarBarco5Casillas_solaparVertical_expectedFalse() {
    //Arrange
    Tablero tablero = new Tablero(10);

    ArrayList<Coordenada> coordenadas1 = new ArrayList<>();
    coordenadas1.add(new Coordenada(1, 1));
    coordenadas1.add(new Coordenada(1, 2));
    coordenadas1.add(new Coordenada(1, 3));
    coordenadas1.add(new Coordenada(1, 4));
    coordenadas1.add(new Coordenada(1, 5));

    ArrayList<Coordenada> coordenadas2 = new ArrayList<>();
    coordenadas2.add(new Coordenada(1, 5));
    coordenadas2.add(new Coordenada(1, 6));
    coordenadas2.add(new Coordenada(1, 7));
    coordenadas2.add(new Coordenada(1, 8));
    coordenadas2.add(new Coordenada(1, 9));

    // Act
    tablero.colocarBarco(coordenadas1);
    boolean resultado = tablero.comprobarSolaparBarco(coordenadas2);

    //Assert
    assertFalse(resultado);
  }

  // ---- COMPROVAR QUE BUSQUE CASILLAS CORRECTAMENTE

  @Test
  public void testBuscarCasilla_Agua_expectedNotNullAndEquals() {
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

  // ---- COMPROBAR QUE SE HAYA RECIBIDO UN GOLPE

  @Test
  public void testRecibirGolpe_CasillaExiste_expectedTrue() {
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
    // Arrange
    Tablero tablero = new Tablero(10);
    Coordenada coordenada = new Coordenada(20, 20);

    //Act
    boolean golpeada = tablero.recibirGolpe(coordenada);

    //Test
    assertFalse(golpeada);
  }

  // ---- COMPROBAR QUE TODOS LOS BARCOS SE HAN HUNDIDO

  @Test
  public void testTodosBarcosHundidos1Barco_expectedTrue() {
    //Arrange
    Tablero tablero = new Tablero(10);

    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada = new Coordenada(0, 1);
    coords.add(coordenada);
    tablero.colocarBarco(coords);
    tablero.recibirGolpe(coordenada);

    // Act
    boolean resultado = tablero.comprobarTodosBarcosHundidos();

    // Test
    assertTrue(resultado);
  }

  @Test
  public void testTodosBarcosHundidos5Barcos_expectedTrue() {
    // Arrange
    Tablero tablero = new Tablero(10);

    // Barco de 2 coordenadas
    ArrayList<Coordenada> coords1 = new ArrayList<>();
    coords1.add(new Coordenada(0, 1));
    coords1.add(new Coordenada(0, 2));
    tablero.colocarBarco(coords1);

    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords2 = new ArrayList<>();
    coords2.add(new Coordenada(1, 1));
    coords2.add(new Coordenada(1, 2));
    coords2.add(new Coordenada(1, 3));
    tablero.colocarBarco(coords2);

    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords3 = new ArrayList<>();
    coords3.add(new Coordenada(2, 1));
    coords3.add(new Coordenada(2, 2));
    coords3.add(new Coordenada(2, 3));
    tablero.colocarBarco(coords3);

    // Barco de 4 coordenadas
    ArrayList<Coordenada> coords4 = new ArrayList<>();
    coords4.add(new Coordenada(3, 1));
    coords4.add(new Coordenada(3, 2));
    coords4.add(new Coordenada(3, 3));
    coords4.add(new Coordenada(3, 4));
    tablero.colocarBarco(coords4);

    // Barco de 5 coordenadas
    ArrayList<Coordenada> coords5 = new ArrayList<>();
    coords5.add(new Coordenada(4, 1));
    coords5.add(new Coordenada(4, 2));
    coords5.add(new Coordenada(4, 3));
    coords5.add(new Coordenada(4, 4));
    coords5.add(new Coordenada(4, 5));
    tablero.colocarBarco(coords5);

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
    //Arrange
    Tablero tablero = new Tablero(10);

    ArrayList<Coordenada> coords = new ArrayList<>();
    Coordenada coordenada = new Coordenada(0, 1);
    Coordenada coordenada2 = new Coordenada(0, 2);
    coords.add(coordenada);
    coords.add(coordenada2);
    tablero.colocarBarco(coords);
    tablero.recibirGolpe(coordenada);

    // Act
    boolean resultado = tablero.comprobarTodosBarcosHundidos();

    // Test
    assertFalse(resultado);
  }

  @Test
  public void testTodosBarcosHundidos5Barcos_expectedFalse() {
    // Arrange
    Tablero tablero = new Tablero(10);

    // Barco de 2 coordenadas
    ArrayList<Coordenada> coords1 = new ArrayList<>();
    coords1.add(new Coordenada(0, 1));
    coords1.add(new Coordenada(0, 2));
    tablero.colocarBarco(coords1);

    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords2 = new ArrayList<>();
    coords2.add(new Coordenada(1, 1));
    coords2.add(new Coordenada(1, 2));
    coords2.add(new Coordenada(1, 3));
    tablero.colocarBarco(coords2);

    // Barco de 3 coordenadas
    ArrayList<Coordenada> coords3 = new ArrayList<>();
    coords3.add(new Coordenada(2, 1));
    coords3.add(new Coordenada(2, 2));
    coords3.add(new Coordenada(2, 3));
    tablero.colocarBarco(coords3);

    // Barco de 4 coordenadas
    ArrayList<Coordenada> coords4 = new ArrayList<>();
    coords4.add(new Coordenada(3, 1));
    coords4.add(new Coordenada(3, 2));
    coords4.add(new Coordenada(3, 3));
    coords4.add(new Coordenada(3, 4));
    tablero.colocarBarco(coords4);

    // Barco de 5 coordenadas
    ArrayList<Coordenada> coords5 = new ArrayList<>();
    coords5.add(new Coordenada(4, 1));
    coords5.add(new Coordenada(4, 2));
    coords5.add(new Coordenada(4, 3));
    coords5.add(new Coordenada(4, 4));
    coords5.add(new Coordenada(4, 5));
    tablero.colocarBarco(coords5);

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
}