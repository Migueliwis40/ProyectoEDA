/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoeda;

/**
 *
 * @author usuario
 */
public class NodoGrafo {
    Object dato;
    ListaDeAdyacencia lista;
    NodoGrafo siguiente;
    
    public NodoGrafo(Object x){
        dato = x;
        lista = new ListaDeAdyacencia();
        siguiente = null;
    }
}
