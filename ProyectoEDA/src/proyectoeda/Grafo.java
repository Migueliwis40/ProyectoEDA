package proyectoeda;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    public NodoPrisionero primero;
    public NodoPrisionero ultimo;

    public Grafo() {
        primero = null;
        ultimo = null;
    }

    public boolean grafoVacio() {
        return primero == null;
    }

    // Verifica si existe un nodo
    public boolean existeVertice(Object dato) {
        boolean existe = false;
        if (!grafoVacio()) {
            NodoPrisionero recorre = primero;
            while (recorre != null && !existe) {
                if (recorre.nombrePrisionero.toString().equals(dato.toString())) {
                    existe = true;
                }
                recorre = recorre.siguiente;
            }
        }
        return existe;
    }

    // Busca un nodo por el nombre
    private NodoPrisionero buscarNodo(String nombre) {
        NodoPrisionero actual = primero;
        while (actual != null) {
            if (actual.nombrePrisionero.equals(nombre)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Genera una nueva arista entre prisioneros
    public void NuevaArista(Object origen, Object destino, float peso) {
        if (existeVertice(origen) && existeVertice(destino)) {
            NodoPrisionero recorre = primero;
            while (!recorre.nombrePrisionero.equals(origen.toString())) {
                recorre = recorre.siguiente;
            }
            recorre.lista.nuevaAdyacencia(destino, peso);
        }
    }

    public List<List<NodoPrisionero>> realizarClustering() {
        // Crea una lista de listas de nodos (clusters)
        List<List<NodoPrisionero>> clusters = new ArrayList<>();
        NodoPrisionero recorre = primero;

        // Reinicia el booleano de visitado de todos los nodos
        while (recorre != null) {
            recorre.visitado = false;
            recorre = recorre.siguiente;
        }

        recorre = primero;
        while (recorre != null) {
            if (!recorre.visitado) {
                // Inicia un nuevo cluster y le o agrega a la lista de clusters
                List<NodoPrisionero> cluster = new ArrayList<>();
                dfs(recorre, cluster);
                clusters.add(cluster);
            }
            recorre = recorre.siguiente;
        }
        return clusters;
    }

    // Recorrido por profundidad
    private void dfs(NodoPrisionero nodo, List<NodoPrisionero> cluster) {
        // Limita el tamaño de cada cluster a 5
        if (cluster.size() <= 5) {
            nodo.visitado = true;
            cluster.add(nodo);

            Arista recorre = nodo.lista.primero;
            while (recorre != null) {
                NodoPrisionero vecino = buscarNodo(recorre.destino.toString());
                // Hace un llamado a si misma con todos los nodos vecinos no visitados
                if (vecino != null && !vecino.visitado) {
                    dfs(vecino, cluster);
                }
                recorre = recorre.siguiente;
            }
        }
    }

    @Override
    public String toString() { //para imprimir
        String cadena = "";
        NodoPrisionero temporal = primero;
        while (temporal != null) {
            cadena = cadena + temporal.nombrePrisionero.toString() + " -> " + temporal.lista.toString() + "\n";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
