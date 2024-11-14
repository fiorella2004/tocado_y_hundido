package org.game;

public class Barco extends Casilla {

  private String dibujo = "⛵";

  public Barco(Coordenada coordenada) {
    super(coordenada);
  }

  @Override
  public String getDibujo() {
    return dibujo;
  }

  @Override
  public void recibirGolpe() {
  }
}