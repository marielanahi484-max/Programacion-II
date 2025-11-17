package exam;

public class Main {
    public static void main(String[] args) {

        MiTeleferico mt = new MiTeleferico();

        mt.agregarLinea("Rojo");
        mt.agregarLinea("Amarillo");
        mt.agregarLinea("Verde");

        for (Linea l : mt.lineas) {
            if (l != null) {
                l.agregarCabina(1);
                l.agregarCabina(2);
            }
        }

        Persona p1 = new Persona("Mariel", 20, 60);
        Persona p2 = new Persona("John", 35, 80);
        Persona p3 = new Persona("Aracely", 70, 65);
        Persona p4 = new Persona("Vianca", 40, 90);

        mt.lineas[0].cabinas[0].agregarPersona(p1); 
        mt.lineas[0].cabinas[0].agregarPersona(p2);
        mt.lineas[1].cabinas[1].agregarPersona(p3); 
        mt.lineas[2].cabinas[0].agregarPersona(p4); 

        System.out.println("¿Cabinas válidas? " + mt.verificarCabinas());
        System.out.println("Ingreso total: " + mt.ingresoTotal());
        System.out.println("Línea con mayor ingreso REGULAR: " + mt.lineaMayorIngresoRegular());
    }
}
