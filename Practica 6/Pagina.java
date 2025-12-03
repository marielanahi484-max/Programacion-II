public class Pagina {
    public int numero;
    public String contenido;

    public Pagina(int numero, String contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Página " + numero + ": " + contenido;
    }
}
