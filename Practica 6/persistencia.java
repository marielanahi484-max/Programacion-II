package persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class persistencia {

    public static <T> void guardarObjetos(String nombreArchivo, ArrayList<T> lista) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> ArrayList<T> leerObjetos(String nombreArchivo, Class<T> clase) {
        ArrayList<T> lista = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get(nombreArchivo))) {
            Type tipoLista = TypeToken.getParameterized(ArrayList.class, clase).getType();
            lista = gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            System.out.println("Archivo no encontrado o vacío: " + nombreArchivo);
        }
        return lista;
    }
}
