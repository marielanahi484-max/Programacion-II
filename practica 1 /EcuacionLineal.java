package practica1;
import java.util.Scanner;
public class EcuacionLineal {
	private double a, b, c, d, e, f;
    public EcuacionLineal(double a, double b, double c, double d, double e, double f)
    {
	    this.a = a;
	    this.b = b;
	    this.c = c;
	    this.d = d;
	    this.e = e;
	    this.f = f;
	}
	public boolean tieneSolucion() {
	   return (a * d - b * c) != 0;
	}
    public double getX() {
	   return (e * d - b * f) / (a * d - b * c);
	}
    public double getY() {
	   return (a * f - e * c) / (a * d - b * c);
	}
	
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		System.out.print("Ingrese a, b, c, d, e, f: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
	
	EcuacionLineal eq = new EcuacionLineal(a, b, c, d, e, f);
		if (eq.tieneSolucion()) {
		    System.out.printf("x = %.1f, y = %.1f\n", eq.getX(), eq.getY());
		} else {
		    System.out.println("La ecuación no tiene solución.");
		}
     }
  }
