package progra2;

import java.util.ArrayList;

public class BibliotecaApp {

    public static class Autor {
        private String nombre, nacionalidad;

        public Autor(String nombre, String nacionalidad) {
            this.nombre = nombre;
            this.nacionalidad = nacionalidad;
        }

        public void mostrarInfo() {
            System.out.println("Nombre: " + nombre + " | Nacionalidad: " + nacionalidad);
        }

        public String getNombre() {
            return nombre;
        }
    }

    public static class Estudiante {
        private String codigoEstudiante;
        private String nombre;

        public Estudiante(String codigoEstudiante, String nombre) {
            this.codigoEstudiante = codigoEstudiante;
            this.nombre = nombre;
        }

        public void mostrarInfo() {
            System.out.println("Nombre: " + nombre + " | Codigo: " + codigoEstudiante);
        }

        public String getNombre() {
            return nombre;
        }

        public String getCodigo() {
            return codigoEstudiante;
        }
    }

    public static class Libro {
        private String titulo;
        private String isbn;
        private ArrayList<Pagina> paginas;

        public Libro(String titulo, String isbn, ArrayList<String> contenidosPaginas) {
            this.titulo = titulo;
            this.isbn = isbn;
            this.paginas = new ArrayList<>();
            int num = 1;
            for (String contenido : contenidosPaginas) {
                this.paginas.add(new Pagina(num++, contenido));
            }
        }

        public String getTitulo() {
            return titulo;
        }

        public String getIsbn() {
            return isbn;
        }

        public void leer() {
            System.out.println("Leyendo el libro: " + titulo);
            for (Pagina p : paginas) {
                p.mostrarContenido();
            }
        }

        public void mostrarInfo() {
            System.out.println("Titulo: " + titulo + " | ISBN: " + isbn);
        }

        class Pagina {
            private int numero;
            private String contenido;

            public Pagina(int numero, String contenido) {
                this.numero = numero;
                this.contenido = contenido;
            }

            public void mostrarContenido() {
                System.out.println("Página " + numero + ": " + contenido);
            }
        }
    }

    public static class Prestamo {
        private String fechaPrestamo, fechaDevolucion;
        private Estudiante estudiante;
        private Libro libro;

        public Prestamo(String fechaPrestamo, String fechaDevolucion, Estudiante estudiante, Libro libro) {
            this.fechaPrestamo = fechaPrestamo;
            this.fechaDevolucion = fechaDevolucion;
            this.estudiante = estudiante;
            this.libro = libro;
        }

        public void mostrarInfo() {
            System.out.println("Libro: " + libro.getTitulo() + " | Estudiante: " + estudiante.getNombre()
                    + " | Fecha Préstamo: " + fechaPrestamo + " | Fecha Devolución: " + fechaDevolucion);
        }
    }
    public static class Biblioteca {
        private String nombre;
        private ArrayList<Libro> libros;
        private ArrayList<Autor> autores;
        private ArrayList<Prestamo> prestamos;
        private Horario horarioAtencion;

        public Biblioteca(String nombre, String dias, String horarioApertura, String horaCierre) {
            this.nombre = nombre;
            this.libros = new ArrayList<>();
            this.autores = new ArrayList<>();
            this.prestamos = new ArrayList<>();
            this.horarioAtencion = new Horario(dias, horarioApertura, horaCierre);
        }

        public void agregarLibro(Libro libro) {
            libros.add(libro);
            System.out.println("Libro agregado: " + libro.getTitulo());
        }

        public void agregarAutor(Autor autor) {
            autores.add(autor);
            System.out.println("Autor registrado: " + autor.getNombre());
        }

        public void prestarLibro(Estudiante estudiante, Libro libro, String fechaPrestamo, String fechaDevolucion) {
            Prestamo p = new Prestamo(fechaPrestamo, fechaDevolucion, estudiante, libro);
            prestamos.add(p);
            System.out.println("Libro prestado: " + libro.getTitulo() + " a " + estudiante.getNombre());
        }

        public void mostrarEstado() {
            System.out.println("\n📚 " + nombre + " 📚");
            System.out.println("\nAutores registrados:");
            for (Autor a : autores) {
                a.mostrarInfo();
            }
            System.out.println("\nLibros disponibles:");
            for (Libro l : libros) {
                System.out.println(l.getTitulo());
            }
            System.out.println("\nPréstamos activos:");
            for (Prestamo p : prestamos) {
                p.mostrarInfo();
            }
            System.out.println("\nHorario de atención:");
            horarioAtencion.mostrarHorario();
        }

        public void cerrarBiblioteca() {
            prestamos.clear();
            System.out.println(nombre + " ha cerrado. Todos los préstamos han sido borrados.");
        }

        public class Horario {
            private String diasApertura, horaApertura, horaCierre;

            public Horario(String diasApertura, String horaApertura, String horaCierre) {
                this.diasApertura = diasApertura;
                this.horaApertura = horaApertura;
                this.horaCierre = horaCierre;
            }

            public void mostrarHorario() {
                System.out.println("Días: " + diasApertura + " | Hora de apertura: " + horaApertura
                        + " | Hora de cierre: " + horaCierre);
            }
        }
    }

    public static void main(String[] args) {

        Autor autor1 = new Autor("Mariel Equice Cayetano", "Argentina");
        Autor autor2 = new Autor("Vianca Tintaya", "Boliviana");

        ArrayList<String> contenido1 = new ArrayList<>();
        contenido1.add("En Macondo todo era posible.");
        contenido1.add("La familia Buendía y su destino.");
        contenido1.add("El tiempo circular del realismo mágico.");

        Libro libro1 = new Libro("Cien años de soledad", "978-1234567890", contenido1);

        ArrayList<String> contenido2 = new ArrayList<>();
        contenido2.add("Borges explora los laberintos del pensamiento.");
        contenido2.add("Realidad, sueños y espejos se mezclan.");

        Libro libro2 = new Libro("Ficciones", "978-0987654321", contenido2);

        Biblioteca bibliotecaUMSA = new Biblioteca("Biblioteca Central UMSA",
                "Lunes a Viernes",
                "08:00",
                "18:00");

        bibliotecaUMSA.agregarAutor(autor1);
        bibliotecaUMSA.agregarAutor(autor2);
        bibliotecaUMSA.agregarLibro(libro1);
        bibliotecaUMSA.agregarLibro(libro2);

        System.out.println("\n----- ESTADO INICIAL -----");
        bibliotecaUMSA.mostrarEstado();

        Estudiante estudiante1 = new Estudiante("20251001", "Mariel Equice");
        bibliotecaUMSA.prestarLibro(estudiante1, libro1, "2025-11-09", "2025-11-23");

        System.out.println("\n----- ESTADO TRAS PRÉSTAMO -----");
        bibliotecaUMSA.mostrarEstado();

        System.out.println("\n----- LEYENDO UN LIBRO -----");
        libro1.leer();

        System.out.println("\n----- CERRANDO BIBLIOTECA -----");
        bibliotecaUMSA.cerrarBiblioteca();

        System.out.println("\n----- ESTADO FINAL -----");
        bibliotecaUMSA.mostrarEstado();
    }
}

