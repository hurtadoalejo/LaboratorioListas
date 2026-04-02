public class Main {
    public static void main(String[] args) {
        Historial historial = new Historial();
        historial.obtenerPaginaActual();
        historial.avanzarPaginaActual();
        historial.retrocederPaginaActual();
        historial.visitarPagina("www.google.com");
        historial.visitarPagina("www.amazon.com");
        historial.visitarPagina("www.mercado.com");
        historial.visitarPagina("www.busca.com");
        historial.visitarPagina("www.linkedin.com");
        System.out.println(historial.getIndiceActual());
        historial.obtenerPaginaActual();
        historial.retrocederPaginaActual();
        historial.retrocederPaginaActual();
        historial.obtenerPaginaActual();
        historial.avanzarPaginaActual();
        historial.obtenerPaginaActual();
        historial.visitarPagina("www.sede.com");
        historial.avanzarPaginaActual();
        historial.avanzarPaginaActual();
        historial.avanzarPaginaActual();
        System.out.println(historial.getIndiceActual());
        historial.retrocederPaginaActual();
        historial.retrocederPaginaActual();
        historial.retrocederPaginaActual();
        historial.retrocederPaginaActual();
        historial.visitarPagina("www.visual.com");
        historial.avanzarPaginaActual();
        System.out.println(historial.getHistorialBusqueda().size());
        historial.retrocederPaginaActual();
        historial.retrocederPaginaActual();
        historial.retrocederPaginaActual();
        historial.avanzarPaginaActual();
        historial.avanzarPaginaActual();
        historial.avanzarPaginaActual();
    }
}
