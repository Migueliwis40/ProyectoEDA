/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoeda;

/**
 *
 * @author usuario
 */
public class Grafo {

    private NodoGrafo primero;
    private NodoGrafo ultimo;

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
            NodoGrafo temporal = primero;
            while(temporal!=null && !existe){
                if(temporal.dato.toString().equals(dato.toString())){
                    existe = true;
                }
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }
    
    public void NuevaArista(Object origen, Object destino, float peso){
        if(existeVertice(origen) && existeVertice(destino)){
            NodoGrafo posicion = primero;
            while(!posicion.dato.equals(origen.toString())){
                posicion = posicion.siguiente;
            }
            posicion.lista.nuevaAdyacencia(destino, peso);
        }
    }
    
    @Override
    public String toString(){ //para imprimir
        String cadena = "";
        NodoGrafo temporal = primero;
        while (temporal != null){
            cadena = cadena + temporal.dato.toString()+" -> " + temporal.lista.toString()+"\n";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
