package exam;

public class Linea {
    String color;
    Persona[] filaPersonas;
    Cabina[] cabinas;
    int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        this.filaPersonas = new Persona[50]; 
        this.cabinas = new Cabina[10];
        this.cantidadCabinas = 0;
    }

    public void agregarPersona(Persona p) {
        for (int i = 0; i < filaPersonas.length; i++) {
            if (filaPersonas[i] == null) {
                filaPersonas[i] = p;
                break;
            }
        }
    }

    public void agregarCabina(int nroCabina) {
        cabinas[cantidadCabinas] = new Cabina(nroCabina);
        cantidadCabinas++;
    }

    public float calcularIngreso() {
        float total = 0;

        for (Cabina c : cabinas) {
            if (c != null) {
                for (Persona p : c.personasAbordo) {
                    if (p != null) {
                        if (p.edad < 25 || p.edad > 60)
                            total += 1.5; 
                        else
                            total += 3;   
                    }
                }
            }
        }
        return total;
    }

    public float ingresoRegular() {
        float total = 0;

        for (Cabina c : cabinas) {
            if (c != null) {
                for (Persona p : c.personasAbordo) {
                    if (p != null) {
                        if (p.edad >= 25 && p.edad <= 60)
                            total += 3;
                    }
                }
            }
        }
        return total;
    }
}
