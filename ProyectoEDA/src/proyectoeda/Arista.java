/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoeda;

/**
 *
 * @author usuario
 */
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
