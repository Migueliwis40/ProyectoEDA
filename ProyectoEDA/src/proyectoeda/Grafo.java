package proyectoeda;

public class Grafo {

    private NodoPrisionero primero;
    private NodoPrisionero ultimo;

    public Grafo() {
        primero = null;
        ultimo = null; 
    }
    
    public boolean grafoVacio(){
        return primero == null;
    }
    
    public boolean existeVertice(Object dato){
        boolean existe = false;
        if(!grafoVacio()){
            NodoPrisionero temporal = primero;
            while(temporal!=null && !existe){
                if(temporal.nombrePrisionero.toString().equals(dato.toString())){
                    existe = true;
                }
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }
    
    public void NuevaArista(Object origen, Object destino, float peso){
        if(existeVertice(origen) && existeVertice(destino)){
            NodoPrisionero posicion = primero;
            while(!posicion.nombrePrisionero.equals(origen.toString())){
                posicion = posicion.siguiente;
            }
            posicion.lista.nuevaAdyacencia(destino, peso);
        }
    }
    
    @Override
    public String toString(){ //para imprimir
        String cadena = "";
        NodoPrisionero temporal = primero;
        while (temporal != null){
            cadena = cadena + temporal.nombrePrisionero.toString()+" -> " + temporal.lista.toString()+"\n";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
