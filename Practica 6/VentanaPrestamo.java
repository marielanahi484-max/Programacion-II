package vista;

import javax.swing.*;
import modelo.*;
import java.awt.*;

public class VentanaPrestamo extends JFrame {
    private static final long serialVersionUID = 1L;

    private Biblioteca biblioteca;
    private JTextField txtEstudiante;
    private JTextField txtCodigoEstudiante;
    private JComboBox<Libro> comboLibros;
    private JTextArea areaPrestamos;

    public VentanaPrestamo(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        initialize();
        cargarPrestamos();
        cargarLibrosCombo();
    }

    private void initialize() {
        setTitle("Registrar Préstamo");
        setBounds(100, 100, 550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNombre = new JLabel("Nombre Estudiante:");
        lblNombre.setBounds(30, 20, 120, 25);
        getContentPane().add(lblNombre);

        txtEstudiante = new JTextField();
        txtEstudiante.setBounds(160, 20, 200, 25);
        getContentPane().add(txtEstudiante);

        JLabel lblCodigo = new JLabel("Código Estudiante:");
        lblCodigo.setBounds(30, 60, 120, 25);
        getContentPane().add(lblCodigo);

        txtCodigoEstudiante = new JTextField();
        txtCodigoEstudiante.setBounds(160, 60, 200, 25);
        getContentPane().add(txtCodigoEstudiante);

        JLabel lblLibro = new JLabel("Libro:");
        lblLibro.setBounds(30, 100, 80, 25);
        getContentPane().add(lblLibro);

        comboLibros = new JComboBox<>();
        comboLibros.setBounds(160, 100, 200, 25);
        getContentPane().add(comboLibros);

        JButton btnPrestar = new JButton("Prestar");
        btnPrestar.setBounds(380, 60, 100, 30);
        getContentPane().add(btnPrestar);

        areaPrestamos = new JTextArea();
        areaPrestamos.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaPrestamos);
        scroll.setBounds(30, 150, 460, 230);
        getContentPane().add(scroll);

        btnPrestar.addActionListener(e -> {
            String nombre = txtEstudiante.getText().trim();
            String codigo = txtCodigoEstudiante.getText().trim();
            Libro libro = (Libro) comboLibros.getSelectedItem();
            if (!nombre.isEmpty() && !codigo.isEmpty() && libro != null) {
                Estudiante estudiante = new Estudiante(codigo, nombre);
                biblioteca.prestarLibro(estudiante, libro, "2025-11-24", "2025-12-01");
                JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente");
                txtEstudiante.setText("");
                txtCodigoEstudiante.setText("");
                cargarPrestamos();
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void cargarPrestamos() {
        areaPrestamos.setText("");
        for (Prestamo p : biblioteca.getPrestamos()) {
            areaPrestamos.append("Estudiante: " + p.getEstudiante().getNombre() +
                    " | Libro: " + p.getLibro().getTitulo() + "\n");
        }
    }

    private void cargarLibrosCombo() {
        comboLibros.removeAllItems();
        for (Libro l : biblioteca.getLibros()) {
            comboLibros.addItem(l);
        }
        comboLibros.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Libro) {
                    setText(((Libro) value).getTitulo());
                }
                return this;
            }
        });
    }
}
