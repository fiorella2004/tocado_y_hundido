package org.game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JugadorIATest {

  @Test
  public void testLoopColocarBarco0Iteraciones() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA", Collections.emptyList());
    jugadorIA.colocarBarco(new ArrayList<>());

    //Assert
    verify(jugadorIA, times(0)).colocarBarcoAleatoriamente(anyInt());
  }

  @Test
  public void testLoopColocarBarco1Iteracion() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA", Arrays.asList(2));
    jugadorIA.colocarBarco(new ArrayList<>());

    //Assert
    verify(jugadorIA, times(1)).colocarBarcoAleatoriamente(anyInt());
  }

  @Test
  public void testLoopColocarBarco2Iteraciones() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA", Arrays.asList(2, 3));
    jugadorIA.colocarBarco(new ArrayList<>());

    //Assert
    verify(jugadorIA, times(2)).colocarBarcoAleatoriamente(anyInt());
  }

  @Test
  public void testLoopColocarBarcoMMenorNIteraciones() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA", Arrays.asList(2, 3, 3));
    jugadorIA.colocarBarco(new ArrayList<>());

    //Assert
    verify(jugadorIA, times(3)).colocarBarcoAleatoriamente(anyInt());
  }

  @Test
  public void testLoopColocarBarcoNMenos1Iteraciones() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA", Arrays.asList(2, 3, 3, 4));
    jugadorIA.colocarBarco(new ArrayList<>());

    //Assert
    verify(jugadorIA, times(4)).colocarBarcoAleatoriamente(anyInt());
  }

  @Test
  public void testLoopColocarBarcoNIteraciones() {
    // Arrange
    JugadorIA jugadorIA = new JugadorIA("IA", Arrays.asList(2, 3, 3, 4, 5));
    jugadorIA.colocarBarco(new ArrayList<>());

    //Assert
    verify(jugadorIA, times(5)).colocarBarcoAleatoriamente(anyInt());
  }
}