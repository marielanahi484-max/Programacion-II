import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BibliotecaMain extends JFrame {

    private ArrayList<Libro> listaLibros = new ArrayList<>();

    public BibliotecaMain() {
        setTitle("Sistema de Biblioteca UMSA");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listaLibros = Persistencia.cargarLibros();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnLibros = new JButton("Gestionar Libros");
        JButton btnAutores = new JButton("Gestionar Autores");
        JButton btnPrestamos = new JButton("Gestionar Préstamos");
        JButton btnVer = new JButton("Ver Todos los Registros");

        btnLibros.addActionListener(e -> gestionarLibros());
        btnVer.addActionListener(e -> mostrarRegistros());

        panel.add(btnLibros);
        panel.add(btnAutores);
        panel.add(btnPrestamos);
        panel.add(btnVer);

        add(panel);
    }

    private void gestionarLibros() {
        String titulo = JOptionPane.showInputDialog("Título del libro:");
        String autor = JOptionPane.showInputDialog("Autor:");
        String codigo = JOptionPane.showInputDialog("Código:");

        if (titulo != null && autor != null && codigo != null) {
            listaLibros.add(new Libro(titulo, autor, codigo));
            Persistencia.guardarLibros(listaLibros);
            JOptionPane.showMessageDialog(this, "Libro registrado");
        }
    }

    private void mostrarRegistros() {
        StringBuilder sb = new StringBuilder("LISTA DE LIBROS:\n\n");

        for (Libro l : listaLibros) {
            sb.append(l.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BibliotecaMain().setVisible(true);
        });
    }
}
