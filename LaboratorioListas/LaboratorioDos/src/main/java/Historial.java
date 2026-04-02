public class Historial {
    private DoublyList<String> historialBusqueda;
    private boolean retrocedio;
    private int indiceActual;

    public Historial() {
        historialBusqueda = new DoublyList<>();
        retrocedio = false;
        indiceActual = -1;
    }

    public DoublyList<String> getHistorialBusqueda() {
        return historialBusqueda;
    }

    public void setHistorialBusqueda(DoublyList<String> historialBusqueda) {
        this.historialBusqueda = historialBusqueda;
    }

    public boolean isRetrocedio() {
        return retrocedio;
    }

    public void setRetrocedio(boolean retrocedio) {
        this.retrocedio = retrocedio;
    }

    public int getIndiceActual() {
        return indiceActual;
    }

    public void setIndiceActual(int indiceActual) {
        this.indiceActual = indiceActual;
    }

    /*
    Visita una pagina nueva y elimina todas las proximas si se habia retrocedido antes
     */
    public void visitarPagina(String pagina) {
        if (retrocedio) historialBusqueda.removeAfter(indiceActual);
        indiceActual++;
        historialBusqueda.add(pagina, indiceActual);
        System.out.println("Se visitó la página: " + pagina);
        retrocedio = false;
    }

    /*
    Muestra la pagina actual
     */
    public void obtenerPaginaActual() {
        String paginaActual = historialBusqueda.get(indiceActual);
        if (paginaActual != null) {
            System.out.println("La página actual es: " + historialBusqueda.get(indiceActual) + ".");
        } else {
            System.out.println("No se han abierto nuevas páginas.");
        }
    }

    /*
    Retrocede a la pagina anterior y cambia la variable retrocedio
     */
    public void retrocederPaginaActual() {
        retrocedio = true;
        if (indiceActual == 0 || indiceActual == -1) {
            System.out.println("No se puede retroceder más.");
            return;
        }
        indiceActual--;
        System.out.println("Retrocedió a la página: " + historialBusqueda.get(indiceActual) + ".");
    }

    /*
    Avanza a la siguiente pagina si existe
     */
    public void avanzarPaginaActual() {
        retrocedio = false;
        int size = historialBusqueda.size();
        if (size <= indiceActual || indiceActual == -1 || size == indiceActual+1) {
            System.out.println("No se puede avanzar más.");
            return;
        }
        indiceActual++;
        System.out.println("Avanzó a la página: " + historialBusqueda.get(indiceActual) + ".");
    }
}
