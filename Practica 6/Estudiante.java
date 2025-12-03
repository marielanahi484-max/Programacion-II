public class Estudiante {
    public String codigo;
    public String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " [" + codigo + "]";
    }
}
