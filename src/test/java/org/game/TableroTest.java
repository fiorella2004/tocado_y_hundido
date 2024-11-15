package org.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
  Tablero tablero = new Tablero(10);

  @Test
  public void testConstructorDimension10_expectedTrue() {
    //Arrange
    tablero.setDimension(10);

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
    tablero.setDimension(9);

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
    tablero.setDimension(15);

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
    tablero.setDimension(16);

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
    tablero.setDimension(12);

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
    tablero.setDimension(20);

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
    tablero.setDimension(11);

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
    tablero.setDimension(14);

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
    tablero.setDimension(-1);

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
    tablero.setDimension(0);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testColocarBarco2Casillas_DentroTablero_expectedTrue() {
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
  public void testColocarBarco2Casillas_FueraTableroHorizontal_expectedFalse() {
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
  public void testColocarBarco2Casillas_FueraTableroVertical_expectedFalse() {
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
  public void testColocarBarco5Casillas_DentroTablero_expectedTrue() {
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
  public void testColocarBarco5Casillas_FueraTableroHorizontal_expectedFalse() {
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
  public void testColocarBarco5Casillas_FueraTableroVertical_expectedFalse() {
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
  public void testColocarBarco2Casillas_SinSolapar_expectedTrue() {
    //Arrange
    Tablero tablero = new Tablero(10);
    ArrayList<Coordenada> coordenadas = new ArrayList<>();
    coordenadas.add(new Coordenada(1, 1));
    coordenadas.add(new Coordenada(1, 2));

    // Act
    tablero.colocarBarco(coordenadas);
    boolean resultado = tablero.comprobarSolaparBarco(coordenadas);

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco2Casillas_SolaparHorizontal_expectedFalse() {
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
  public void testColocarBarco2Casillas_SolaparVertical_expectedFalse() {
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
  public void testColocarBarco5Casillas_SinSolaparHorizontal_expectedTrue() {
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
    boolean resultado = tablero.comprobarSolaparBarco(coordenadas);

    //Assert
    assertTrue(resultado);
  }

  @Test
  public void testColocarBarco5Casillas_SolaparHorizontal_expectedFalse() {
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
  public void testColocarBarco5Casillas_SolaparVertical_expectedFalse() {
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

}