import modelo.Biblioteca;
import vista.MenuPrincipal;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca UMSA");

        SwingUtilities.invokeLater(() -> {
            MenuPrincipal menu = new MenuPrincipal(biblioteca);
            menu.setVisible(true);
        });
    }
}
