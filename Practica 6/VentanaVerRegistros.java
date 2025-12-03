package vista;

import javax.swing.*;
import modelo.*;
import java.awt.*;

public class VentanaVerRegistros extends JFrame {
    private static final long serialVersionUID = 1L;
    private Biblioteca biblioteca;
    private JTextArea textArea;

    public VentanaVerRegistros(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        initialize();
        mostrarRegistros();
    }

    private void initialize() {
        setTitle("Registros Biblioteca");
        setBounds(100, 100, 550, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(textArea);
        getContentPane().add(scroll, BorderLayout.CENTER);
    }

    private void mostrarRegistros() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== AUTORES ===\n");
        for (Autor a : biblioteca.getAutores()) {
            sb.append(a.getNombre()).append("\n");
        }

        sb.append("\n=== LIBROS ===\n");
        for (Libro l : biblioteca.getLibros()) {
            sb.append(l.getTitulo()).append(" | ISBN: ").append(l.getIsbn()).append("\n");
        }

        sb.append("\n=== PRÉSTAMOS ===\n");
        for (Prestamo p : biblioteca.getPrestamos()) {
            sb.append(p.getEstudiante().getNombre())
              .append(" -> ").append(p.getLibro().getTitulo())
              .append(" | Desde: ").append(p.getFechaPrestamo())
              .append(" Hasta: ").append(p.getFechaDevolucion())
              .append("\n");
        }

        sb.append("\n=== HORARIO ===\n");
        sb.append(biblioteca.getHorario());

        textArea.setText(sb.toString());
    }
}
