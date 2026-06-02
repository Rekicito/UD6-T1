import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import net.salesianos.Participante;
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

        System.out.println("\nPRIMER PEDIDO");
        System.out.println(colaPedidos.peek());

        Stack<Pedido> pilaPreparados = new Stack<>();

        for (int i = 0; i < 3; i++) {
            Pedido preparado = colaPedidos.poll();
            pilaPreparados.push(preparado);
        }

        System.out.println("\nULTIMO PEDIDO PREPARADO");
        System.out.println(pilaPreparados.peek());

        Pedido pedidoExtraido = pilaPreparados.pop();

        System.out.println("\nPEDIDO EXTRAIDO");
        System.out.println(pedidoExtraido);

        System.out.println("\nPEDIDOS PENDIENTES");
        System.out.println(colaPedidos.size());

        System.out.println("\n¿COLA VACIA?");
        System.out.println(colaPedidos.isEmpty());

        Set<Participante> participantes = new HashSet<>();

        participantes.add(new Participante("J001", "Adrián", "Junior"));
        participantes.add(new Participante("J002", "Paula", "Junior"));
        participantes.add(new Participante("J003", "Samuel", "Senior"));
        participantes.add(new Participante("J001", "Adrián repetido", "Senior"));
        participantes.add(new Participante("J004", "Claudia", "Senior"));
        participantes.add(new Participante("J005", "Diego", "Junior"));
        participantes.add(new Participante("J006", "Alba", "Experto"));

        System.out.println("\nPARTICIPANTES");

        for (Participante participante : participantes) {
            System.out.println(participante);
        }

        System.out.println("\nParticipantes intentados: 7");
        System.out.println("Participantes reales: " + participantes.size());

        HashMap<String, Integer> categorias = new HashMap<>();

        for (Participante participante : participantes) {

            String categoria = participante.getCategoria();

            if (categorias.containsKey(categoria)) {
                categorias.put(categoria, categorias.get(categoria) + 1);
            } else {
                categorias.put(categoria, 1);
            }
        }

        System.out.println("\nMAPA DE CATEGORIAS");
        System.out.println(categorias);

        System.out.println("\nParticipantes Junior:");
        System.out.println(categorias.get("Junior"));

        System.out.println("\n¿Existe Experto?");
        System.out.println(categorias.containsKey("Experto"));

        if (categorias.containsKey("Experto")) {
            categorias.remove("Experto");
        }

        System.out.println("\nCLAVES DEL MAPA");

        for (String clave : categorias.keySet()) {
            System.out.println(clave);
        }

    }
}