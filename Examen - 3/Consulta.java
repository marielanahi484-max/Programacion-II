public class Consulta {
    public int id;
    public String nombrePaciente;
    public String apellidoPaciente;
    public int idMed;
    public String dia;
    public String mes;
    public int anio;

    public Consulta(int id, String nombrePaciente, String apellidoPaciente, int idMed,
                    String dia, String mes, int anio) {
        this.id = id;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public String getPaciente() {
        return nombrePaciente + " " + apellidoPaciente;
    }
}
