package Modelo;

import java.util.Random;

public class MockRandom extends Random {
  private int[] valores;
  private int posicion = 0;

  public MockRandom(int[] valores) {
    this.valores = valores;
  }

  @Override
  public int nextInt(int valorMaximo) {
    int valor = valores[posicion];
    posicion++;
    return valor;
  }
}
