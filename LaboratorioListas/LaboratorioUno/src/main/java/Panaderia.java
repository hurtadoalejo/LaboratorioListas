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

    /*
    Agrega un cliente al final de la lista, utilizandolo como cola FIFO
     */
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente agregado: " + cliente.getNombre());
    }

    /*
    Atiende al primer cliente, el cual lo elimina de la lista
     */
    public void atenderCliente() {
        if (clientes.size() == 0) {
            System.out.println("No tiene clientes para atender");
        } else {
            System.out.println("El cliente: " + clientes.getFirst().getNombre() + " fue atendido.");
            clientes.remove();
        }
    }

    /*
    Muestra todos los clientes en orden de llegada
     */
    public void mostrarClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        }
    }

    /*
    Consulta el segundo cliente de la cola
     */
    public void consultarSegundoCliente() {
        if (clientes.size() < 2) {
            System.out.println("No hay suficientes clientes para consultar");
        } else {
            System.out.println("El segundo cliente para atender es: " + clientes.getSecond().getNombre() + ".");
        }
    }
}
