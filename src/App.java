import java.util.LinkedList;
import java.util.Queue;
import net.salesianos.Pedido;

public class App {
    public static void main(String[] args) {

        Queue<Pedido> colaPedidos = new LinkedList<>();
        Pedido p1 = new Pedido("P001", "Carla", "Café con leche", true);
        Pedido p2 = new Pedido("P002", "Mario", "Bocadillo de pollo", false);
        Pedido p3 = new Pedido("P003", "Nerea", "Zumo natural", true);
        Pedido p4 = new Pedido("P004", "Iván", "Tostada integral", false);
        Pedido p5 = new Pedido("P005", "Laura", "Té verde", true);

        colaPedidos.add(p1);
        colaPedidos.add(p2);
        colaPedidos.add(p3);
        colaPedidos.add(p4);
        colaPedidos.add(p5);

        System.out.println("PEDIDOS PENDIENTES");

        for (Pedido pedido : colaPedidos) {
            System.out.println(pedido);
        }
    }
}