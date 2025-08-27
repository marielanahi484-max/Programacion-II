package practica1;
import java.util.Scanner;
public class EstadisticaModular {
	    public static double promedio(double[] datos) {
	        double suma = 0;
	        for (double x : datos) suma += x;
	        return suma / datos.length;
	    }

	    public static double desviacion(double[] datos) {
	        double prom = promedio(datos);
	        double sumaCuadrados = 0;
	        for (double x : datos) sumaCuadrados += Math.pow(x - prom, 2);
	        return Math.sqrt(sumaCuadrados / (datos.length - 1));
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        double[] datos = new double[10];
	        System.out.println("Ingrese 10 números:");
	        for (int i = 0; i < 10; i++) datos[i] = sc.nextDouble();

	        System.out.printf("El promedio es %.2f\n", promedio(datos));
	        System.out.printf("La desviación estándar es %.5f\n", desviacion(datos));
	    }
	}

