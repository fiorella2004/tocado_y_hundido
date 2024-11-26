package Modelo;

public class Agua extends Casilla {

  private String aguaDibujo = "🌊";

  Agua(Coordenada coordenada) {
    super(coordenada);
  }

  @Override
  public String getDibujo() {
    return aguaDibujo;
  }

  @Override
  public void recibirGolpe() {
    golpeada = true;
    aguaDibujo = "⬜";
  }
}