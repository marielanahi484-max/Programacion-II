package exam;

public class Cabina {
    int nroCabina;
    Persona[] personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new Persona[10]; 
    }

    public boolean agregarPersona(Persona p) {
        int contador = 0;
        float pesoTotal = 0;

        for (Persona per : personasAbordo) {
            if (per != null) {
                contador++;
                pesoTotal += per.pesoPersona;
            }
        }

        if (contador >= 10) return false;
        if (pesoTotal + p.pesoPersona > 850) return false;

        personasAbordo[contador] = p;
        return true;
    }
}
