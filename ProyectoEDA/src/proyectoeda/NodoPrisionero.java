package proyectoeda;

public class NodoPrisionero {

    String nombrePrisionero;
    int peligrosidad;
    ListaDeAdyacencia lista;
    NodoPrisionero siguiente;
    boolean visitado;

    public NodoPrisionero(String nombre, int p) {
        this.nombrePrisionero = nombre;
        this.peligrosidad = p;
        this.lista = new ListaDeAdyacencia();
        this.siguiente = null;
        this.visitado = false;
    }

    @Override
    public String toString() {
        return "("  + peligrosidad + ") " +nombrePrisionero + " -> " + lista.toString();
    }
}
