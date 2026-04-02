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

    public void agregarCancion(String cancion) {
        listaCanciones.add(cancion, indice);
        System.out.println("Cancion agregada: " + cancion);
    }

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

    public void eliminarCancion() {
        System.out.println("Cancion eliminada: " + listaCanciones.get(indice));
        listaCanciones.remove(indice);
    }

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
