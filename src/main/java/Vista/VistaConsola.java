package Vista;
import Modelo.*;

import java.util.ArrayList;

public class VistaConsola {
  private Partida partida;

  public VistaConsola(){};

  public void mostrarMensajeInicioJuego(){

  }

  public void mostrarMensajeFinJuego(){

  }

  public void mostrarMensajeTurnoIA(){

  }

  public String pedirGolpe(){
    return "0";
  }

  public int pedirDimensionTablero(){
    return 10;
  }

  public void setPartida(Partida partida){
    this.partida = partida;
  }

  public void mostrarTableros(){
  }

  public void mostrarErrorColocarBarco() {

  }

  public String pedirColocarBarco(int dimensionBarco) {
    return null;
  }
}
