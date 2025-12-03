public class Autor {
    public String nombre;
    public String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}

