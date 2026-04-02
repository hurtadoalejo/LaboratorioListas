public class Partida {
    private CircularDoublyList<String> listaJugadores;
    private int indice;

    public Partida() {
        this.listaJugadores = new CircularDoublyList<>();
        this.indice = 0;
    }

    public CircularDoublyList<String> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(CircularDoublyList<String> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void agregarJugador(String jugador) {
        System.out.println("Agregando jugador " + jugador);
        listaJugadores.add(jugador, indice);
    }

    public void avanzarJugadorAdelante() {
        if (listaJugadores.size() == 0) {
            System.out.println("No hay jugadores");
            return;
        }
        String nombre = "";
        if (indice == listaJugadores.size()-1) {
            indice = 0;
            nombre = listaJugadores.get(indice);
        } else {
            indice++;
            nombre = listaJugadores.get(indice);
        }
        System.out.println("Es turno de: " + nombre);
    }

    public void avanzarJugadorAnterior() {
        if (listaJugadores.size() == 0) {
            System.out.println("No hay jugadores");
            return;
        }
        String nombre = "";
        if (indice == 0) {
            indice = listaJugadores.size()-1;
            nombre = listaJugadores.get(indice);
        } else {
            indice--;
            nombre = listaJugadores.get(indice);
        }
        System.out.println("Es turno de: " + nombre);
    }

    public void jugadorActual() {
        if (listaJugadores.size() == 0) {
            System.out.println("No hay jugadores");
            return;
        }
        System.out.println("Jugador actual: " + listaJugadores.get(indice));
    }

    public void jugadorAnterior() {
        if (listaJugadores.size() == 0) {
            System.out.println("No hay jugadores");
            return;
        }
        String jugador = "";
        if (indice == 0) {
            jugador = listaJugadores.get(listaJugadores.size()-1);
        } else {
            jugador = listaJugadores.get(indice-1);
        }
        System.out.println(jugador != null ? "Jugador anterior: " + jugador: "No hay un jugador anterior");
    }

    public void jugadorSiguiente() {
        if (listaJugadores.size() == 0) {
            System.out.println("No hay jugadores");
            return;
        }
        String jugador = "";
        if (indice == listaJugadores.size()-1) {
            jugador = listaJugadores.get(0);
        } else {
            jugador = listaJugadores.get(indice+1);
        }
        System.out.println(jugador != null ? "Jugador siguiente: " + jugador: "No hay un jugador anterior");
    }

    public void expulsarJugador(String nombre) {
        if (listaJugadores.size() == 0) {
            System.out.println("No hay jugadores");
            return;
        }
        if (listaJugadores.remove(nombre)) {
            System.out.println("Jugador expulsado: " + nombre);
            if (indice > listaJugadores.size()) indice--;
        } else {
            System.out.println("Jugador no expulsado, no existe " + nombre);
        }
    }

    public void mostrarJugadores() {
        System.out.println("Jugadores:");
        for (String jugador : listaJugadores) {
            System.out.println("Jugador: " + jugador);
        }
    }
}
