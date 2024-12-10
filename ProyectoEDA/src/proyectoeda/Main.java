package proyectoeda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        iniciarNodosPrisioneros(grafo);
        List<List<NodoPrisionero>> clusters = grafo.realizarClustering();

        // Imprimir resultados
        int grupo = 1;
        for (List<NodoPrisionero> cluster : clusters) {
            System.out.print("Celda " + grupo + ": ");
            int peligrosidadCelda = 0, numPris = 0;
            for (NodoPrisionero nodo : cluster) {
                peligrosidadCelda += nodo.peligrosidad;
                System.out.print(nodo.nombrePrisionero + " ");
                numPris++;
            }
            System.out.println("(Peso " + peligrosidadCelda / numPris + ")");
            grupo++;
        }
    }

    public static void iniciarNodosPrisioneros(Grafo grafo) {
        Map<String, NodoPrisionero> prisioneros = new HashMap<>(); // Mapa con todos los prisioneros

        // Lee los datos del archivo de texto
        try {
            BufferedReader br = new BufferedReader(new FileReader("txtPrisioneros"));
            String line = br.readLine();

            while (line != null) {
                String[] vec = line.split(", ");
                // Crea un nodo por cada prisionero
                NodoPrisionero nodo = new NodoPrisionero(vec[0], Puntaje.CalcPuntaje(vec[1], vec[2], vec[3]));

                // Agrega el nodo al grafo y al mapa
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

            for (NodoPrisionero nodo1 : prisioneros.values()) {
                for (NodoPrisionero nodo2 : prisioneros.values()) {
                    if (!nodo1.nombrePrisionero.equals(nodo2.nombrePrisionero)) {
                        
                        // Crea aristas entre prisioneros basado en la diferencia de peligrosidad
                        int diferencia = Math.abs(nodo1.peligrosidad - nodo2.peligrosidad);
                        if (diferencia <= 5) {
                            nodo1.lista.nuevaAdyacencia(nodo2.nombrePrisionero, diferencia);
                            nodo2.lista.nuevaAdyacencia(nodo1.nombrePrisionero, diferencia);
                        }
                    }
                }
            }

            // Imprime la lista de adyacencia de cada nodo
            NodoPrisionero temp = grafo.primero;
            while (temp != null) {
//                System.out.println(temp);
                temp = temp.siguiente;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
