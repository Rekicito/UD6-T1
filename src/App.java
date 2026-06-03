import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import net.salesianos.Pedido;
import net.salesianos.Participante;
import net.salesianos.Pelicula;

public class App {
    public static void main(String[] args) {

        // EJERCICIO 1 - Pedidos
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

        System.out.println("=== EJERCICIO 1 ===");
        System.out.println("Pedidos pendientes:");
        for (Pedido pedido : colaPedidos)
            System.out.println(pedido);

        System.out.println("Primer pedido: " + colaPedidos.peek());

        Stack<Pedido> pilaPreparados = new Stack<>();
        for (int i = 0; i < 3; i++)
            pilaPreparados.push(colaPedidos.poll());

        System.out.println("Último pedido preparado: " + pilaPreparados.peek());

        Pedido pedidoExtraido = pilaPreparados.pop();
        System.out.println("Pedido extraído del historial: " + pedidoExtraido);

        System.out.println("Pedidos pendientes: " + colaPedidos.size());
        System.out.println("¿Cola vacía?: " + colaPedidos.isEmpty());

        // EJERCICIO 2 - Participantes
        Set<Participante> participantes = new HashSet<>();
        participantes.add(new Participante("J001", "Adrián", "Junior"));
        participantes.add(new Participante("J002", "Paula", "Junior"));
        participantes.add(new Participante("J003", "Samuel", "Senior"));
        participantes.add(new Participante("J001", "Adrián repetido", "Senior"));
        participantes.add(new Participante("J004", "Claudia", "Senior"));
        participantes.add(new Participante("J005", "Diego", "Junior"));
        participantes.add(new Participante("J006", "Alba", "Experto"));

        // No se añaden duplicados porque HashSet usa equals() y hashCode()
        // para comprobar si un participante ya existe.

        System.out.println("\n=== EJERCICIO 2 ===");
        System.out.println("Participantes:");
        for (Participante participante : participantes)
            System.out.println(participante);

        System.out.println("Participantes intentados: 7");
        System.out.println("Participantes reales: " + participantes.size());

        HashMap<String, Integer> categorias = new HashMap<>();
        for (Participante participante : participantes) {
            String cat = participante.getCategoria();

            if (categorias.containsKey(cat)) {
                categorias.put(cat, categorias.get(cat) + 1);
            } else {
                categorias.put(cat, 1);
            }
        }

        System.out.println("Conteo por categoría: " + categorias);

        if (categorias.containsKey("Junior")) {
            System.out.println("Participantes Junior: " + categorias.get("Junior"));
        } else {
            System.out.println("Participantes Junior: 0");
        }

        System.out.println("¿Existe Experto?: " + categorias.containsKey("Experto"));

        if (categorias.containsKey("Experto"))
            categorias.remove("Experto");

        System.out.println("Claves después de eliminar Experto:");
        for (String clave : categorias.keySet())
            System.out.println(clave);

        // EJERCICIO 3 - Películas
        ArrayList<Pelicula> peliculas = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("UD6-T1/peliculas.csv"));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String titulo = partes[0];
                String genero = partes[1];
                int duracion = Integer.parseInt(partes[2]);

                peliculas.add(new Pelicula(titulo, genero, duracion));
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (peliculas.size() > 0) {
            int total = 0;
            Pelicula mayor = peliculas.get(0);

            for (Pelicula p : peliculas) {
                total += p.getDuracionMinutos();

                if (p.getDuracionMinutos() > mayor.getDuracionMinutos())
                    mayor = p;
            }

            double media = (double) total / peliculas.size();

            System.out.println("\n=== EJERCICIO 3 ===");
            System.out.println("Total de películas: " + peliculas.size());
            System.out.println("Duración total: " + total);
            System.out.println("Duración media: " + media);
            System.out.println("Película con mayor duración: " + mayor);

            try {
                FileWriter resumen = new FileWriter("UD6-T1/resumen_peliculas.txt");
                resumen.write("RESUMEN DE PELICULAS\n");
                resumen.write("Total de peliculas: " + peliculas.size() + "\n");
                resumen.write("Duración total: " + total + " minutos\n");
                resumen.write("Duración media: " + media + "\n");
                resumen.write("Película con mayor duración: " + mayor + "\n");
                resumen.close();

                FileWriter log = new FileWriter("UD6-T1/log_peliculas.txt", true);
                log.write("Se ha generado el resumen de peliculas\n");
                log.close();
            } catch (IOException e) {
                System.out.println("Error escribiendo archivos");
            }
        } else {
            System.out.println("No se han cargado películas. Revisa la ruta del CSV.");
        }
    }
}