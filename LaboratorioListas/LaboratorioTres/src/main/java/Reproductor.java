public class Reproductor {
    private CircularSimplyList<String> listaCanciones;
    private int indice;

    public Reproductor() {
        listaCanciones = new CircularSimplyList<>();
        indice = 0;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public CircularSimplyList<String> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(CircularSimplyList<String> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    /*
    Agrega una canción a la playlist
     */
    public void agregarCancion(String cancion) {
        listaCanciones.add(cancion, indice);
        System.out.println("Cancion agregada: " + cancion);
    }

    /*
    Avanza de canción o reinicio el indice si llega al máximo para tener la forma circular infinita
     */
    public void avanzarCancion() {
        String cancion = "";
        if (indice == listaCanciones.size()-1) {
            indice = 0;
            cancion = listaCanciones.get(indice);
        } else {
            indice++;
            cancion = listaCanciones.get(indice);
        }
        System.out.println("Cancion avanzada: " + cancion);
    }

    /*
    Elimina una canción de la playlist dado el nombre de ella
     */
    public void eliminarCancion(String cancion) {
        if (listaCanciones.remove(cancion)) {
            System.out.println("Cancion eliminada: " + cancion);
        } else {
            System.out.println("Cancion no eliminada, no existe: " + cancion);
        }
    }

    /*
    Muestra todas las canciones desde el head hasta el ultimo elemento
     */
    public void mostrarCanciones() {
        System.out.println("Canciones:");
        for (String cancion : listaCanciones) {
            System.out.println(cancion);
        }
    }

    public void cancionActual() {
        System.out.println("La cancion actual: " + listaCanciones.get(indice));
    }
}
