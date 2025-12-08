public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
 
        System.out.println("");
        consultorio.altaMedico(new Medico(201, "Jesus", "Quispe", 10));
        consultorio.altaMedico(new Medico(202, "María", "Torrez", 18));
        consultorio.altaMedico(new Medico(203, "Jose", "Flores", 6)); 
        
        consultorio.altaConsulta(new Consulta(311, "PX1", "AX1", 201, 10, "abril", 2025));
        consultorio.altaConsulta(new Consulta(322, "PX2", "AX2", 202, 24, "noviembre", 2025));  
        consultorio.altaConsulta(new Consulta(333, "PX3", "AX3", 203, 2, "enero", 2026));      
        consultorio.altaConsulta(new Consulta(344, "PX4", "AX4", 201, 9, "mayo", 2025));   
        consultorio.altaConsulta(new Consulta(355, "PX5", "AX5", 203, 16, "abril", 2025));      
        consultorio.altaConsulta(new Consulta(366, "PX6", "AX6", 202, 25, "noviembre", 2025));  
        consultorio.altaConsulta(new Consulta(377, "PX7", "AX7", 201, 3, "enero", 2026));       
        consultorio.altaConsulta(new Consulta(388, "PX8", "AX8", 203, 8, "marzo", 2025));  }
        consultorio.altaConsulta(new Consulta(399, "PX9", "AX9", 202, 21, "febrero", 2025));
        
        System.out.println("");
        
        consultorio.bajaMedicoYConsultas("Jorge", "Flores");
                
        System.out.println("");
        
        consultorio.modificarDiaConsulta(18); 
        
        System.out.println("");
        
        consultorio.mostrarPacientesPorDia(9, "mayo", 2025);
        
    }
}
