public class Panaderia {
    SimplyList<Cliente> clientes;

    public Panaderia() {
        clientes = new SimplyList<>();
    }

    public SimplyList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(SimplyList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void atenderCliente() {
        if (clientes.size() == 0) {
            System.out.println("No tiene clientes para atender");
        } else {
            System.out.println("El cliente: " + clientes.getFirst().getNombre() + " fue atendido.");
            clientes.remove();
        }
    }

    public void mostrarClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        }
    }

    public void consultarSegundoCliente() {
        if (clientes.size() == 0) {
            System.out.println("No hay clientes para consultar");
        } else {
            System.out.println("El segundo cliente para atender es: " + clientes.getSecond().getNombre() + ".");
        }
    }
}
