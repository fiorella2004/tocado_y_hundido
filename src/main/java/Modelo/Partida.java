package Modelo;

import java.util.ArrayList;

public class Partida {
  private JugadorPersona jugadorPersona;
  private JugadorIA jugadorIA;
  private int turno = 1;
  private int dimensionTablero;
  private boolean finPartida;

  public Partida(){
  }

  public JugadorPersona getJugadorPersona() {
    return jugadorPersona;
  }

  public JugadorIA getjugadorIA() {
    return jugadorIA;
  }

  private void crearTablero(int dimension) {

  }

  public boolean colocarBarcoJugador(ArrayList<Coordenada> coordenadas, int dimensionBarco){
    return true;
  }

  public void colocarBarcosIA(){

  }

  public boolean golpeaJugadorPersona(Coordenada coordenada){
    return true;
  }

  public boolean golpeaJugadorIA(){
    return true;
  }

}
