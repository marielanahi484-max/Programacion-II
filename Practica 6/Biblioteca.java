package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import persistencia.persistencia;

public class Biblioteca implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String ARCHIVO_LIBROS = "libros.json";
    private static final String ARCHIVO_AUTORES = "autores.json";
    private static final String ARCHIVO_PRESTAMOS = "prestamos.json";

    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;
    private Horario horario;

    // Constructor con nombre
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.horario = new Horario("Lunes a Viernes", "09:00", "17:00");

        this.libros =   persistencia.leerObjetos(ARCHIVO_LIBROS, Libro.class);
        this.autores = persistencia.leerObjetos(ARCHIVO_AUTORES, Autor.class);
        this.prestamos = persistencia.leerObjetos(ARCHIVO_PRESTAMOS, Prestamo.class);

    }

    // Constructor vacío
    public Biblioteca() {
        this("Biblioteca sin nombre");
    }

    // Agregar libro
public void agregarLibro(Libro libro) {
    if (libros == null) {
        libros = new ArrayList<>();
    }
    libros.add(libro);
    persistencia.guardarObjetos(ARCHIVO_LIBROS, libros);
    System.out.println("Libro agregado: " + libro.getTitulo());
}

// Agregar autor
public void agregarAutor(Autor autor) {
    if (autores == null) {
        autores = new ArrayList<>();
    }
    autores.add(autor);
    persistencia.guardarObjetos(ARCHIVO_AUTORES, autores);
    System.out.println("Autor registrado: " + autor.getNombre());
}

// Registrar préstamo
public void prestarLibro(Estudiante e, Libro l, String fechaPrestamo, String fechaDevolucion) {
    if (prestamos == null) {
        prestamos = new ArrayList<>();
    }
    Prestamo p = new Prestamo(fechaPrestamo, fechaDevolucion, e, l);
    prestamos.add(p);
    persistencia.guardarObjetos(ARCHIVO_PRESTAMOS, prestamos);
    System.out.println("Libro prestado: " + l.getTitulo() + " a " + e.getNombre());
}

    
    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public ArrayList<Libro> getLibros() { return libros; }
    public void setLibros(ArrayList<Libro> libros) { this.libros = libros; }

    public ArrayList<Autor> getAutores() { return autores; }
    public void setAutores(ArrayList<Autor> autores) { this.autores = autores; }

    public ArrayList<Prestamo> getPrestamos() { return prestamos; }
    public void setPrestamos(ArrayList<Prestamo> prestamos) { this.prestamos = prestamos; }

    public Horario getHorario() { return horario; }
    public void setHorario(Horario horario) { this.horario = horario; }

    // Clase interna Horario
    public class Horario implements Serializable {
        private static final long serialVersionUID = 1L;

        private String dias;
        private String apertura;
        private String cierre;

        public Horario(String dias, String apertura, String cierre) {
            this.dias = dias;
            this.apertura = apertura;
            this.cierre = cierre;
        }

        public String getDias() { return dias; }
        public void setDias(String dias) { this.dias = dias; }

        public String getApertura() { return apertura; }
        public void setApertura(String apertura) { this.apertura = apertura; }

        public String getCierre() { return cierre; }
        public void setCierre(String cierre) { this.cierre = cierre; }

        public String mostrarHorario() {
            return "Días: " + dias + " | Apertura: " + apertura + " | Cierre: " + cierre;
        }
    }
}
