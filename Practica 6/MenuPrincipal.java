package vista;

import modelo.Biblioteca;
import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private Biblioteca biblioteca;

    public MenuPrincipal(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        initialize();
    }

    private void initialize() {
        setTitle("Menú Principal - Biblioteca UMSA");
        setBounds(100, 100, 450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Sistema de Biblioteca UMSA");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(50, 20, 340, 30);
        getContentPane().add(lblTitulo);

        JButton btnLibros = new JButton("Gestionar Libros");
        btnLibros.setBounds(120, 70, 200, 30);
        getContentPane().add(btnLibros);

        JButton btnAutores = new JButton("Gestionar Autores");
        btnAutores.setBounds(120, 110, 200, 30);
        getContentPane().add(btnAutores);

        JButton btnPrestamos = new JButton("Gestionar Préstamos");
        btnPrestamos.setBounds(120, 150, 200, 30);
        getContentPane().add(btnPrestamos);

        JButton btnVerTodos = new JButton("Ver Todos los Registros");
        btnVerTodos.setBounds(120, 200, 200, 30);
        getContentPane().add(btnVerTodos);

        btnLibros.addActionListener(e -> new VentanaAgregarLibro(biblioteca).setVisible(true));
        btnAutores.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de autores aún no implementada"));
        btnPrestamos.addActionListener(e -> new VentanaPrestamo(biblioteca).setVisible(true));
        btnVerTodos.addActionListener(e -> new VentanaVerRegistros(biblioteca).setVisible(true));
    }

}
