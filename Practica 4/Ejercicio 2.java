package practica4;

import java.util.Random;

interface Coloreado {
    String comoColorear();
}

abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "Color: " + color;
    }

    public abstract double area();
    public abstract double perimetro();
}

class Cuadrado extends Figura implements Coloreado {
    private double lado;

    public Cuadrado(double lado, String color) {
        super(color);
        this.lado = lado;
    }

    public double area() {
        return lado * lado;
    }

    public double perimetro() {
        return 4 * lado;
    }

    public String comoColorear() {
        return "Colorear los cuatro lados";
    }

    public String toString() {
        return "Cuadrado [lado=" + lado + ", " + super.toString() + "]";
    }
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio, String color) {
        super(color);
        this.radio = radio;
    }

    public double area() {
        return Math.PI * radio * radio;
    }

    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Círculo [radio=" + radio + ", " + super.toString() + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Figura[] figuras = new Figura[5];

        for (int i = 0; i < figuras.length; i++) {
            int tipo = rand.nextInt(2) + 1; // 1 = Cuadrado, 2 = Circulo
            String color = (tipo == 1) ? "Rojo" : "Azul";

            if (tipo == 1) {
                double lado = 1 + rand.nextInt(10);
                figuras[i] = new Cuadrado(lado, color);
            } else {
                double radio = 1 + rand.nextInt(10);
                figuras[i] = new Circulo(radio, color);
            }
        }

        for (Figura f : figuras) {
            System.out.println(f.toString());
            System.out.println("Área: " + f.area());
            System.out.println("Perímetro: " + f.perimetro());

            if (f instanceof Coloreado) {
                Coloreado c = (Coloreado) f;
                System.out.println("Método Coloreado: " + c.comoColorear());
            }

            System.out.println("-------------------------");
        }
    }
}
