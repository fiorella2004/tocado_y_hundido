import Controlador.Controlador;
import Modelo.JugadorIA;
import Modelo.JugadorPersona;
import Modelo.Partida;
import Vista.VistaConsola;

public class Main {

  public static void main(String[] args) {
    VistaConsola vista = new VistaConsola();
    JugadorPersona jugadorPersona = new JugadorPersona("Persona");
    JugadorIA jugadorIA = new JugadorIA("IA");
    Partida partida = new Partida(jugadorPersona, jugadorIA);
    Controlador controlador = new Controlador(vista, partida, jugadorPersona, jugadorIA);
    controlador.colocarBarcosJugadorPersona();
    controlador.comenzarPartida();
  }
}
