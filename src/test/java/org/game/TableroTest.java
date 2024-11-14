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
  public void testConstructor10Row9Col_expectedTrue() {
    //Arrange
    tablero.setNumFilas(10);
    tablero.setNumCol(9);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructor11Row10Col_expectedFalse() {
    //Arrange
    tablero.setNumFilas(11);
    tablero.setNumCol(10);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(11, filas);
    assertEquals(11, columnas);
  }

  @Test
  public void testConstructor10Row11Col_expectedFalse() {
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
  public void testConstructor11Row11Col_expectedFalse() {
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
  public void testConstructor0Row10Col_expectedFalse() {
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
  public void testConstructor10Row0Col_expectedFalse() {
    //Arrange
    tablero.setNumFilas(10);
    tablero.setNumCol(0);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructor15Row15Col_expectedFalse() {
    //Arrange
    tablero.setNumFilas(15);
    tablero.setNumCol(15);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(15, filas);
    assertEquals(15, columnas);
  }

  @Test
  public void testConstructor16Row10Col_expectedFalse() {
    //Arrange
    tablero.setNumFilas(16);
    tablero.setNumCol(10);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructor10Row16Col_expectedFalse() {
    //Arrange
    tablero.setNumFilas(10);
    tablero.setNumCol(16);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructor12Row12Col_expectedFalse() {
    //Arrange
    tablero.setNumFilas(12);
    tablero.setNumCol(12);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(12, filas);
    assertEquals(12, columnas);
  }

  @Test
  public void testConstructorNegativeRow10Col_expectedFalse() {
    //Arrange
    tablero.setNumFilas(10);
    tablero.setNumCol(-1);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructor10RowNegativeCol_expectedFalse() {
    //Arrange
    tablero.setNumFilas(10);
    tablero.setNumCol(-1);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

  @Test
  public void testConstructorNegativeRowNegativeCol_expectedFalse() {
    //Arrange
    tablero.setNumFilas(-1);
    tablero.setNumCol(-1);

    // Act
    int filas = tablero.getNumFilas();
    int columnas = tablero.getNumCol();

    //Assert
    assertEquals(10, filas);
    assertEquals(10, columnas);
  }

}