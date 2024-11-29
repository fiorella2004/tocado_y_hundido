package Modelo;

public class Coordenada {
  public int fila;
  public int col;

  public Coordenada(int fila, int col) {
    this.fila = fila;
    this.col = col;
  }

  public int getFila() {
    return fila;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coordenada that = (Coordenada) o;
    return fila == that.fila && col == that.col;
  }
}
