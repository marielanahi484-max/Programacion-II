public class Medico {
    public int idMed;
    public String nombreMed;
    public String apellidoMed;
    public int aniosExperiencia;

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getNombreCompleto() {
        return nombreMed + " " + apellidoMed;
    }
}
