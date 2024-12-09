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
        if (!busqueda(destino)) {
            Arista nodo = new Arista(destino, peso);
            inserta(nodo, destino);
        }
    }

    public void inserta(Arista nodo, Object destino) {
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

    public boolean busqueda(Object dato) {
        Arista actual;
        boolean encontrado;
        encontrado = false;
        actual = primero;
        while (actual != null && !dato.toString().equals(actual.destino.toString())) {
            actual = actual.siguiente;
        }
        if (actual != null) {
            encontrado = true;
        }
        return encontrado;
    }
    
    public String toString(){
        String cadena = "";
        Arista temporal = primero;
        while (temporal != null){
            cadena = cadena + temporal.destino.toString()+ " ; ";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
