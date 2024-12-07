/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoeda;

import java.util.HashMap;
import java.util.Map;

public class Puntaje {

    int puntaje;
    boolean conflictividad;
    boolean antecedentes;
    int saludmental;
    int crimen;
    String banda;

    public Puntaje(int puntaje, boolean conflictividad, boolean antecedentes, int saludmental, int crimen, String banda) {
        this.puntaje = puntaje;
        this.conflictividad = conflictividad;
        this.antecedentes = antecedentes;
        this.saludmental = saludmental;
        this.crimen = crimen;
        this.banda = banda;
    }

    public int Crimen(String crimen) {
        Map<String, Integer> lista = new HashMap<String, Integer>();

        lista.put("robo", 10);

        return 0;
    }

    public void Conflictividad() {
        if (conflictividad == true) {
            puntaje += 20;
        }
    }

    public void SaludMental() {
        if (saludmental == 2) {
            puntaje += 10;
        } else if (saludmental == 3) {
            puntaje += 20;
        }
    }

    public void Antecedentes() {
        if (antecedentes == true) {
            puntaje += 10;
        }
    }
    
}
