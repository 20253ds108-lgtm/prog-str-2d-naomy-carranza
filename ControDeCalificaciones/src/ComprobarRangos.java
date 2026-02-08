import java.util.Scanner;

public class ComprobarRangos {

    public String leerTextoNoVacio(Scanner scanner, String memsaje) {
        String valor = "";
        while (true) {
            System.out.println(memsaje);
            valor=scanner.nextLine();
            if (!valor.isEmpty()) {
                return valor;
            } else {
                System.out.println("no puedes mandar texto vacio");
                scanner.next();
            }
        }
    }

    public double leerDoubleEnRango(Scanner scanner, String memsaje, double minimo, double maximo) {
        double valor = 0;
        while (true) {
            System.out.println(memsaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                } else {
                    System.out.println("el numero ingresado esta fuera del rango");
                }
            } else {
                System.out.println("el valor ingresado no es un numero");
                scanner.next();
            }
        }
    }

    public int leerIntEnRango(Scanner scanner, String memsaje, int minimo, int maximo) {
        int valor = 0;
        while (true) {
            System.out.println(memsaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                } else {
                    System.out.println("el numero ingresado esta fuera del rango");
                }
            } else {
                System.out.println("el valor ingresado no es un numero");
                scanner.next();
            }
        }
    }
    public boolean leerBoolean(Scanner scanner, String mensaje) {
        boolean valor;
        while (true) {
            System.out.println(mensaje);
            if (scanner.hasNextBoolean()) {
                valor = scanner.nextBoolean();
                return valor;
            } else {
                System.out.println("ingresa si es true/false");
                scanner.next();
            }
        }
    }
}
