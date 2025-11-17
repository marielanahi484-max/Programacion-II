package exam;

public class MiTeleferico {
    Linea[] lineas;
    float cantidadIngresos;

    public MiTeleferico() {
        lineas = new Linea[3]; 
        cantidadIngresos = 0;
    }

    public void agregarLinea(String linea) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] == null) {
                lineas[i] = new Linea(linea);
                break;
            }
        }
    }

    public boolean agregarPersonaFila(Persona p, String linea) {
        for (Linea l : lineas) {
            if (l != null && l.color.equals(linea)) {
                l.agregarPersona(p);
                return true;
            }
        }
        return false;
    }

    public boolean agregarPersonaACabina(String linea, int nroCabina) {

        for (Linea l : lineas) {
            if (l != null && l.color.equals(linea)) {
            	
                Persona primera = null;
                int index = -1;

                for (int i = 0; i < l.filaPersonas.length; i++) {
                    if (l.filaPersonas[i] != null) {
                        primera = l.filaPersonas[i];
                        index = i;
                        break;
                    }
                }

                if (primera == null) return false;

                for (Cabina c : l.cabinas) {
                    if (c != null && c.nroCabina == nroCabina) {

                        if (c.agregarPersona(primera)) {
                            l.filaPersonas[index] = null; 
                            return true;
                        } else {
                            return false; 
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean verificarCabinas() {
        for (Linea l : lineas) {
            if (l != null) {
                for (Cabina c : l.cabinas) {
                    if (c != null) {

                        int personas = 0;
                        float peso = 0;

                        for (Persona p : c.personasAbordo) {
                            if (p != null) {
                                personas++;
                                peso += p.pesoPersona;
                            }
                        }

                        if (personas > 10 || peso > 850)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public float ingresoTotal() {
        float total = 0;

        for (Linea l : lineas) {
            if (l != null)
                total += l.calcularIngreso();
        }

        cantidadIngresos = total;
        return total;
    }

    public String lineaMayorIngresoRegular() {
        String nombre = "";
        float max = -1;

        for (Linea l : lineas) {
            if (l != null) {
                float ingreso = l.ingresoRegular();
                if (ingreso > max) {
                    max = ingreso;
                    nombre = l.color;
                }
            }
        }

        return nombre;
    }
}
