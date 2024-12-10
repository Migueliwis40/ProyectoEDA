package proyectoeda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        iniciarNodosPrisioneros();
        System.out.print(""); //Prueba
    }

    public static void iniciarNodosPrisioneros() {
        Grafo grafo = new Grafo(); //Creacion del grafo prisioneros
        try {
            BufferedReader br = new BufferedReader(new FileReader("txtPrisioneros"));
            String line = br.readLine();

            while (line != null) {
                String[] vec = line.split(", ");
                NodoPrisionero nodo = new NodoPrisionero(vec[0], Puntaje.CalcPuntaje(vec[1], vec[2], vec[3]));

                if (!grafo.existeVertice(nodo.nombrePrisionero)) {
                    if (grafo.grafoVacio()) {
                        grafo.primero = nodo;
                        grafo.ultimo = nodo;
                    } else {
                        grafo.ultimo.siguiente = nodo;
                        grafo.ultimo = nodo;
                    }
                    //PRUEBA
                    //System.out.println(nodo.nombrePrisionero + " " + nodo.peligrosidad);
                    line = br.readLine();

                }
                NodoPrisionero nodo1 = grafo.primero;
                while (nodo1 != null) {
                    NodoPrisionero nodo2 = nodo1.siguiente;
                    while (nodo2 != null) {
                        int diferencia = Math.abs(nodo1.peligrosidad - nodo2.peligrosidad);
                        if (diferencia <= 20) {
                            grafo.NuevaArista(nodo1.nombrePrisionero, nodo2.nombrePrisionero, diferencia);
                            grafo.NuevaArista(nodo2.nombrePrisionero, nodo1.nombrePrisionero, diferencia);
                        }
                        nodo2 = nodo2.siguiente;
                    }
                    nodo1 = nodo1.siguiente;
                }
            }
            //imprimir grafo
            NodoPrisionero temp = grafo.primero;
            while (temp != null) {
                System.out.println(temp);
                temp = temp.siguiente;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}
