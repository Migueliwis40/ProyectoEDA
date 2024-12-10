package proyectoeda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        iniciarNodosPrisioneros();
    }

    public static void iniciarNodosPrisioneros() {
        Grafo grafo = new Grafo(); // Crear instancia del grafo
        Map<String, NodoPrisionero> prisioneros = new HashMap<>(); // Mapa para los prisioneros

        try {
            BufferedReader br = new BufferedReader(new FileReader("txtPrisioneros"));
            String line = br.readLine();

            // Leer prisioneros y agregarlos al grafo
            while (line != null) {
                String[] vec = line.split(", ");
                NodoPrisionero nodo = new NodoPrisionero(vec[0], Puntaje.CalcPuntaje(vec[1], vec[2], vec[3]));

                // Agregar nodo al grafo y al mapa
                if (!prisioneros.containsKey(nodo.nombrePrisionero)) {
                    prisioneros.put(nodo.nombrePrisionero, nodo);
                    if (grafo.grafoVacio()) {
                        grafo.primero = nodo;
                        grafo.ultimo = nodo;
                    } else {
                        grafo.ultimo.siguiente = nodo;
                        grafo.ultimo = nodo;
                    }
                }

                line = br.readLine();
            }

            // Crear aristas basado en la diferencia de peligrosidad
            for (NodoPrisionero nodo1 : prisioneros.values()) {
                for (NodoPrisionero nodo2 : prisioneros.values()) {
                    if (!nodo1.nombrePrisionero.equals(nodo2.nombrePrisionero)) {
                        int diferencia = Math.abs(nodo1.peligrosidad - nodo2.peligrosidad);
                        if (diferencia <= 20) {
                            nodo1.lista.nuevaAdyacencia(nodo2.nombrePrisionero, diferencia);
                        }
                    }
                }
            }

            // Imprimir el grafo al final
            NodoPrisionero temp = grafo.primero;
            while (temp != null) {
                System.out.println(temp); // Llama a toString() de NodoPrisionero
                temp = temp.siguiente;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

