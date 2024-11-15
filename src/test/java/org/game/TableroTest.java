package org.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {
  Tablero tablero = new Tablero(10,10);

  @Test
  public void testConstructor10Row10Col_expectedTrue() {
    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    // Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructor9Row10Col_expectedTrue() {
    //Arrange
    tablero.setNumFilas(9);
    tablero.setNumCol(10);

    // Act
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
    tablero.setNumFilas(11);
    tablero.setNumCol(10);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(15, filas);
    assertEquals(15, columnas);
  }

  @Test
  public void testConstructorDimension12_expectedTrue() {
    //Arrange
    tablero.setNumFilas(10);
    tablero.setNumCol(11);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructorDimension20_expectedTrue() {
    //Arrange
    tablero.setNumFilas(11);
    tablero.setNumCol(11);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(11, filas);
    assertEquals(11, columnas);
  }

  @Test
  public void testConstructorDimension11_expectedTrue() {
    //Arrange
    tablero.setNumFilas(0);
    tablero.setNumCol(10);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
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
  public void testConstructorDimensionNegative_expectedFalse() {
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
  public void testConstructorDimension0_expectedFalse() {
    //Arrange
    tablero.setDimension(0);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }
}