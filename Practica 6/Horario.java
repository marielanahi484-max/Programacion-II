public class Horario {
    public String dias;
    public String horaApertura;
    public String horaCierre;

    public Horario(String dias, String horaApertura, String horaCierre) {
        this.dias = dias;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    @Override
    public String toString() {
        return dias + " de " + horaApertura + " a " + horaCierre;
    }
}
