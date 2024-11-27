package Vista;
import Modelo.*;

public class VistaConsola {
  private Partida partida;

  public VistaConsola(){};

  public int pedirDimensionTablero(){
    return 10;
  }

  public void setPartida(Partida partida){
    this.partida = partida;
  }

  public void mostrarTableros(){
  }
}
