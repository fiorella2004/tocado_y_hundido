package Modelo;

import java.util.Objects;

public abstract class Casilla {

  protected int id;
  protected Coordenada coordenada;
  protected boolean golpeada;

  public Casilla(Coordenada coordenada) {
    // Precondición
    assert coordenada != null : "la coordenada no pueden ser nula";

    this.coordenada = coordenada;
    golpeada = false;
    id = 0;
  }

  public abstract String getDibujo();

  public abstract void recibirGolpe();

  public boolean esGolpeada() {
    return golpeada;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public Coordenada obtenerCoordenada() {
    return coordenada;
  }

  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Casilla other = (Casilla) obj;
    return id == other.id && Objects.equals(coordenada, other.coordenada);
  }
}
