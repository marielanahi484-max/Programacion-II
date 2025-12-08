import java.io.*;
import java.util.ArrayList;

public class Consultorio {

    private String archivoMedicos = "medicos.txt";
    private String archivoConsultas = "consultas.txt";

    public void guardarMedico(Medico m) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoMedicos, true))) {
            bw.write(m.idMed + "," + m.nombreMed + "," + m.apellidoMed + "," + m.aniosExperiencia);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error al guardar médico");
        }
    }

    public void guardarConsulta(Consulta c) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoConsultas, true))) {
            bw.write(c.id + "," + c.nombrePaciente + "," + c.apellidoPaciente + "," +
                     c.idMed + "," + c.dia + "," + c.mes + "," + c.anio);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error al guardar consulta");
        }
    }

    public ArrayList<Medico> leerMedicos() {
        ArrayList<Medico> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoMedicos))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                lista.add(new Medico(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Integer.parseInt(d[3])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al leer médicos");
        }

        return lista;
    }

    public ArrayList<Consulta> leerConsultas() {
        ArrayList<Consulta> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoConsultas))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(",");
                lista.add(new Consulta(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Integer.parseInt(d[3]),
                        d[4],
                        d[5],
                        Integer.parseInt(d[6])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al leer consultas");
        }

        return lista;
    }
}
