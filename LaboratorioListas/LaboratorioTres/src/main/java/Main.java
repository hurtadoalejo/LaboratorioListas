public class Main {
    public static void main(String[] args) {
        /*
        Los metodos agregar cancion y eliminar cancion la agrega o quita en la posicion que se este en la playlist
        Ej: Si hay 5 canciones y estoy en la posicion 2, al agregar una esta quedara en la cancion 3
         */
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
