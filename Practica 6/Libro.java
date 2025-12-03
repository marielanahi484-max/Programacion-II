package modelo;

public class Libro {
    private String titulo;
    private String isbn;

    public Libro() {}

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " | ISBN: " + isbn);
    }

    @Override
    public String toString() {
        return titulo;
    }
}
