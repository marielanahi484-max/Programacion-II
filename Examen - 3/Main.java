import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try { new FileWriter("medicos.txt").close(); } catch (Exception e) {}
        try { new FileWriter("consultas.txt").close(); } catch (Exception e) {}

        Consultorio cons = new Consultorio();

        cons.guardarMedico(new Medico(1, "Sara", "Mamani", 5));
        cons.guardarMedico(new Medico(2, "Lidia", "Condori", 10));
        cons.guardarMedico(new Medico(3, "Anahi", "Ramos", 3));

        cons.guardarConsulta(new Consulta(1, "Julia", "Mamani", 1, "25", "Diciembre", 2024));
        cons.guardarConsulta(new Consulta(2, "Juan", "Quispe", 2, "01", "Enero", 2025));
        cons.guardarConsulta(new Consulta(3, "Nicol", "Choque", 3, "10", "Febrero", 2025));

        cons.guardarConsulta(new Consulta(4, "Maria", "Aliaga", 1, "25", "Diciembre", 2024));
        cons.guardarConsulta(new Consulta(5, "Luis", "Flores", 2, "15", "Marzo", 2025));
        cons.guardarConsulta(new Consulta(6, "Pedro", "Guzman", 3, "01", "Enero", 2025));

        cons.guardarConsulta(new Consulta(7, "Rosa", "Luna", 1, "09", "Abril", 2025));
        cons.guardarConsulta(new Consulta(8, "Ana", "Perez", 2, "12", "Junio", 2025));
        cons.guardarConsulta(new Consulta(9, "Diego", "Mora", 3, "25", "Diciembre", 2024));

        String nombreBaja = "Lidia";
        String apellidoBaja = "Condori";

        ArrayList<Medico> medico = cons.leerMedicos();   
        ArrayList<Medico> nuevosMedico = new ArrayList<>();

        int medicoEliminadoID = -1;

        for (Medico m : medico) {
            if (m.nombreMed.equals(nombreBaja) && m.apellidoMed.equals(apellidoBaja)) {
                medicoEliminadoID = m.idMed;
            } else {
                nuevosMedico.add(m);
            }
        }

        try (FileWriter fw = new FileWriter("medicos.txt")) {
            for (Medico m : nuevosMedico) {
                fw.write(m.idMed + "," + m.nombreMed + "," + m.apellidoMed + "," + m.aniosExperiencia + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar médicos");
        }

        // eliminar consultas del médico eliminado
        ArrayList<Consulta> consulta = cons.leerConsultas();  
        ArrayList<Consulta> nuevasConsultas = new ArrayList<>();

        for (Consulta c : consulta) {
            if (c.idMed != medicoEliminadoID) {
                nuevasConsultas.add(c);
            }
        }

        try (FileWriter fw = new FileWriter("consultas.txt")) {
            for (Consulta c : nuevasConsultas) {
                fw.write(c.id + "," + c.nombrePaciente + "," + c.apellidoPaciente + "," +
                        c.idMed + "," + c.dia + "," + c.mes + "," + c.anio + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar consultas al eliminar médico");
        }

        for (Consulta c : nuevasConsultas) {
            if ((c.dia.equals("25") && c.mes.equals("Diciembre")) ||
                (c.dia.equals("01") && c.mes.equals("Enero"))) {

                c.dia = "05";
            }
        }

        try (FileWriter fw = new FileWriter("consultas.txt")) {
            for (Consulta c : nuevasConsultas) {
                fw.write(c.id + "," + c.nombrePaciente + "," + c.apellidoPaciente + "," +
                        c.idMed + "," + c.dia + "," + c.mes + "," + c.anio + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar días");
        }

        System.out.println();
    }
}

