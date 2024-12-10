package proyectoeda;

public class ListaDeAdyacencia {

    Arista primero;
    Arista ultimo;

    public ListaDeAdyacencia() {
        primero = null;
        ultimo = null;
    }

    public boolean listaVacia() {
        return primero == null;
    }

    public void nuevaAdyacencia(Object destino, float peso) {
        // Crea una nueva arista si aun no existe
        if (!busqueda(destino)) {
            Arista nodo = new Arista(destino, peso);
            inserta(nodo, destino);
        }
    }

    public boolean busqueda(Object dato) {
        // Verifica ssi existe una arista
        boolean encontrado = false;
        Arista recorre = primero;
        while (recorre != null && !dato.toString().equals(recorre.destino.toString())) {
            recorre = recorre.siguiente;
        }
        if (recorre != null) {
            encontrado = true;
        }
        return encontrado;
    }

    public void inserta(Arista nodo, Object destino) {
        // Inserta la arista a la lista enlazada 
        if (listaVacia()) {
            primero = nodo;
            ultimo = nodo;
        } else {
            if (destino.toString().compareTo(primero.destino.toString()) <= 0) {
                nodo.siguiente = primero;
                primero = nodo;
            } else {
                if (destino.toString().compareTo(ultimo.destino.toString()) >= 0) {
                    ultimo.siguiente = nodo;
                    ultimo = nodo;
                } else {
                    Arista posicion = primero;
                    while (destino.toString().compareTo(posicion.destino.toString()) < 0) {
                        posicion = posicion.siguiente;
                    }
                    nodo.siguiente = posicion.siguiente;
                    posicion.siguiente = nodo;
                }
            }
        }
    }

    public String toString() {
        String cadena = "";
        Arista temporal = primero;
        while (temporal != null) {
            cadena = cadena + temporal.destino.toString() + " ; ";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
