package proyectoeda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        iniciarNodosPrisioneros();
    }
    
    
    public static void iniciarNodosPrisioneros(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("txtPrisioneros"));
            String line = br.readLine();
            while (line != null) {
                String[] vec = line.split(", ");
                NodoPrisionero nodo = new NodoPrisionero(vec[0], Puntaje.CalcPuntaje(vec[1], vec[2], vec[3]));
                
                //PRUEBA
                System.out.println(nodo.nombrePrisionero + " " + nodo.peligrosidad);
                line = br.readLine();
                
                //AQUI SE DEBE GUARDAR CADA NODO EN EL GRAFO
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
}
