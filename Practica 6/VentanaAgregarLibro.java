package vista;

import javax.swing.*;
import modelo.Biblioteca;
import modelo.Libro;
import java.awt.*;

public class VentanaAgregarLibro extends JFrame {
    private static final long serialVersionUID = 1L;

    private Biblioteca biblioteca;
    private JTextField txtTitulo;
    private JTextField txtISBN;
    private JTextArea areaLibros;

    public VentanaAgregarLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        initialize();
        cargarLibros();
    }

    private void initialize() {
        setTitle("Agregar Libro");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(30, 20, 80, 25);
        getContentPane().add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 20, 200, 25);
        getContentPane().add(txtTitulo);

        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setBounds(30, 60, 80, 25);
        getContentPane().add(lblISBN);

        txtISBN = new JTextField();
        txtISBN.setBounds(120, 60, 200, 25);
        getContentPane().add(txtISBN);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(350, 40, 100, 30);
        getContentPane().add(btnAgregar);

        areaLibros = new JTextArea();
        areaLibros.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaLibros);
        scroll.setBounds(30, 110, 420, 230);
        getContentPane().add(scroll);

        btnAgregar.addActionListener(e -> {
            String titulo = txtTitulo.getText().trim();
            String isbn = txtISBN.getText().trim();
            if (!titulo.isEmpty() && !isbn.isEmpty()) {
                biblioteca.agregarLibro(new Libro(titulo, isbn));
                JOptionPane.showMessageDialog(this, "Libro agregado correctamente");
                txtTitulo.setText("");
                txtISBN.setText("");
                cargarLibros();
            } else {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void cargarLibros() {
        areaLibros.setText("");
        for (Libro l : biblioteca.getLibros()) {
            areaLibros.append("Título: " + l.getTitulo() + " | ISBN: " + l.getIsbn() + "\n");
        }
    }
}
