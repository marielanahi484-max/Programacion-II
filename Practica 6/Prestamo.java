package modelo;

public class Prestamo {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo() {}

    public Prestamo(String fechaPrestamo, String fechaDevolucion, Estudiante estudiante, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estudiante = estudiante;
        this.libro = libro;
    }

    public String getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public String getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(String fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }

    public void mostrarInfo() {
        System.out.println("Libro: " + libro.getTitulo() +
                " | Estudiante: " + estudiante.getNombre() +
                " | Prestamo: " + fechaPrestamo +
                " | Devolución: " + fechaDevolucion);
    }
}
