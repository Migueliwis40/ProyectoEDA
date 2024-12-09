package proyectoeda;

public class NodoPrisionero {
    String nombrePrisionero;
    int peligrosidad;
    ListaDeAdyacencia lista;
    NodoPrisionero siguiente;
    
    public NodoPrisionero(String nombre, int p){
        this.nombrePrisionero = nombre;
        this.peligrosidad = p;
        lista = new ListaDeAdyacencia();
        siguiente = null;
    }
}
