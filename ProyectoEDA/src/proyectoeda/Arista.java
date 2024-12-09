package proyectoeda;

public class Arista {

    Object destino;
    float peso;
    Arista siguiente;

    public Arista(Object d, float p) {
        destino = d;
        peso = p;
        siguiente = null;
    }
}
