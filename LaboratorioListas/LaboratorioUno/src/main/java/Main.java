public class Main {
    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();
        panaderia.agregarCliente(new Cliente("Alejandro"));
        panaderia.agregarCliente(new Cliente("Carlos"));
        System.out.println(panaderia.getClientes().size());
        panaderia.agregarCliente(new Cliente("Pedro"));
        panaderia.agregarCliente(new Cliente("Maria"));
        panaderia.atenderCliente();
        panaderia.consultarSegundoCliente();
        panaderia.mostrarClientes();
        System.out.println(panaderia.getClientes().size());
    }
}
