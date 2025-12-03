import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Persistencia {

    private static final String RUTA = "libros.txt";

    public static void guardarLibros(ArrayList<Libro> lista) {
       
        try {
            File f = new File(RUTA);
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo: " + e.getMessage());
            e.printStackTrace();
            return;
        }

      
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(RUTA, false), StandardCharsets.UTF_8))) {
            for (Libro l : lista) {
            
                String titulo = l.getTitulo().replace(";", ",");
                String autor = l.getAutor().replace(";", ",");
                String codigo = l.getCodigo().replace(";", ",");
                bw.write(codigo + ";" + titulo + ";" + autor);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar libros: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Libro> cargarLibros() {
        ArrayList<Libro> lista = new ArrayList<>();
        Path path = Path.of(RUTA);

        if (!Files.exists(path)) {
            return lista;
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String linea;
            int lineaNum = 0;
            while ((linea = br.readLine()) != null) {
                lineaNum++;
                linea = linea.trim();
                if (linea.isEmpty()) continue; 

                String[] datos = linea.split(";", -1); 
                if (datos.length < 3) {
                    
                    System.err.println("Línea " + lineaNum + " ignorada (formato incorrecto): " + linea);
                    continue;
                }

                String codigo = datos[0].trim();
                String titulo = datos[1].trim();
                String autor = datos[2].trim();

                lista.add(new Libro(titulo, autor, codigo));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar libros: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }
}
