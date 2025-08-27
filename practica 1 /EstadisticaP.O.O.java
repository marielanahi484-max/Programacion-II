package practica1;
import java.util.Scanner;
public class Estadistica {
    private double[] datos;

    public Estadistica(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        double suma = 0;
        for (double x : datos) suma += x;
        return suma / datos.length;
    }

    public double desviacion() {
        double prom = promedio();
        double sumaCuadrados = 0;
        for (double x : datos) sumaCuadrados += Math.pow(x - prom, 2);
        return Math.sqrt(sumaCuadrados / (datos.length - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numeros = new double[10];
        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) numeros[i] = sc.nextDouble();

        Estadistica e = new Estadistica(numeros);
        System.out.printf("El promedio es %.2f\n", e.promedio());
        System.out.printf("La desviación estándar es %.5f\n", e.desviacion());
    }
}

   
