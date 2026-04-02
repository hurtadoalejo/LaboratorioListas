public class Main {
    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor();
        reproductor.agregarCancion("GuacaGuaca");
        reproductor.agregarCancion("Además de mi");
        System.out.println(reproductor.getListaCanciones().get(0));
        reproductor.eliminarCancion("Además de mi");
        reproductor.mostrarCanciones();
        System.out.println("//////////////////");
        reproductor.agregarCancion("Amantes");
        reproductor.cancionActual();
        System.out.println(reproductor.getIndice());
        reproductor.agregarCancion("Pierdo la Cabeza");
        reproductor.cancionActual();
        System.out.println(reproductor.getIndice());
        reproductor.agregarCancion("Algo Aparte");
        reproductor.cancionActual();
        System.out.println(reproductor.getIndice());
        reproductor.avanzarCancion();
        reproductor.cancionActual();
        System.out.println(reproductor.getIndice());
        reproductor.avanzarCancion();
        reproductor.cancionActual();
        System.out.println(reproductor.getIndice());
        reproductor.mostrarCanciones();
        reproductor.agregarCancion("Hot");
        reproductor.cancionActual();
        reproductor.mostrarCanciones();
        reproductor.avanzarCancion();
        reproductor.avanzarCancion();
        System.out.println(reproductor.getIndice());
        reproductor.avanzarCancion();
        System.out.println(reproductor.getIndice());
        reproductor.avanzarCancion();
        reproductor.agregarCancion("Cerca mio");
        reproductor.cancionActual();
        System.out.println(reproductor.getIndice());
        reproductor.mostrarCanciones();
    }
}
