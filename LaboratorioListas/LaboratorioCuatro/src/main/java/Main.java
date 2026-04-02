public class Main {
    public static void main(String[] args) {
        Partida partida = new Partida();

        partida.agregarJugador("Alejandro");
        partida.agregarJugador("Juanito");
        partida.agregarJugador("Veronica");
        partida.agregarJugador("Mariana");
        System.out.println();

        partida.jugadorActual();
        partida.jugadorSiguiente();
        partida.jugadorAnterior();
        System.out.println();

        partida.avanzarJugadorAdelante();
        partida.avanzarJugadorAdelante();
        partida.avanzarJugadorAdelante();
        partida.jugadorActual();
        partida.avanzarJugadorAnterior();
        partida.jugadorActual();
        partida.agregarJugador("Carolina");
        partida.jugadorActual();
        partida.jugadorSiguiente();
        partida.jugadorAnterior();
        partida.mostrarJugadores();
        partida.expulsarJugador("Alejandro");
        partida.mostrarJugadores();
        partida.jugadorActual();
        partida.avanzarJugadorAdelante();
        partida.avanzarJugadorAdelante();
        partida.avanzarJugadorAdelante();
        partida.avanzarJugadorAdelante();
        partida.jugadorActual();
    }
}
