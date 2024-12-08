package proyectoeda;

public class Puntaje {
    
    public static int CalcPuntaje(String crimen, String conflictividad, String estadoPsicologico) {
        return CalcCrimen(crimen) + CalcConflictividad(conflictividad) + CalcEstadoMental(estadoPsicologico);
    }

    private static int CalcCrimen(String crimen) {
        switch (crimen) {
            case "hurto menor", "vandalismo", "falsificacion leve", "conduccion bajo alcohol", "desobediencia civil" -> {
                return 10;
            }
            case "hurto agravado", "fraude economico", "agresion fisica leve", "conduccion temeraria", "delito informatico" -> {
                return 20;
            }
            case "robo violento", "agresion fisica grave", "trafico de drogas", "extorsion", "corrupcion politica", "secuestro" -> {
                return 30;
            }
            case "homicidio", "trafico de armas", "violacion", "terrorismo" -> {
                return 40;
            }
            case "genocidio", "crimenes de guerra", "asesinato serial" -> {
                return 50;
            }
            default -> {
                return 0;
            }
        }
    }

    private static int CalcConflictividad(String c) {
        if (c.equals("si")) {
            return 25;
        } else {
            return 0;
        }
    }

    private static int CalcEstadoMental(String em) {
        return switch (em) {
            case "regular" -> 15;
            case "malo" -> 25;
            default -> 0;
        };
    }
}
