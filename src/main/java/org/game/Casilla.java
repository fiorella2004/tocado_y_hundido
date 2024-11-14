package org.game;

public abstract class Casilla {

  protected int id;
  protected Coordenada coordenada;
  protected boolean golpeada;

  public Casilla(Coordenada coordenada)
  {
    this.coordenada = coordenada;
    golpeada = false;
    id = 0;
  }

  public abstract String getDibujo();
  public boolean esGolpeada() {return golpeada; }
  public abstract void recibirGolpe();

  public void setId(int id) {this.id = id;}
  public int getId() {return id;}

  public Coordenada obtenerCoordenada() {return coordenada;}

}
