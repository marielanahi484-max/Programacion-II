public class Prestamo {
    public String fechaPrestamo = "29/11/2025";
    public String fechaDevolucion = "13/12/2025";
    public Estudiante estudiante;
    public Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
    }
}
