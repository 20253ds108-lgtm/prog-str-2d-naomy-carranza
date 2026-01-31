import java.util.Scanner;
public class Main {
    public static int celciusaFahrenheit = 0, fahrenheitaCelcius = 0, KmaMillas = 0, millasKm = 0;
    public static void main(String[] arg) {
        int opcion = 0;
        double dato = 0;
        double resultado = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("menu de conversiones");
            System.out.println("1- °C a °F");
            System.out.println("2- °F a °C");
            System.out.println("3- km a millas");
            System.out.println("4- millas a km");
            System.out.println("5- salir");
            opcion = obtenerNumero(scanner, "eliga una opcion :) :");

            switch (opcion) {
                case 1:
                    System.out.println("elegiste la primera opcion");
                    dato = DatoIngresado(scanner, "ingresa los °C:");
                    resultado = conversionC(dato);
                    System.out.println("el resultado es: " + resultado + " °F");
                    celciusaFahrenheit++;
                    break;
                case 2:
                    System.out.println("elegiste la segunda opcion");
                    dato = DatoIngresado(scanner, "ingresa los °F:");
                    resultado = conversionfahrenheit(dato);
                    System.out.println("el resultado es: " + resultado + " °C");
                    fahrenheitaCelcius++;
                    break;
                case 3:
                    System.out.println("elegiste la tercera opcion");
                    dato = DatoIngresado(scanner, "ingresa los kilometros:");
                    resultado = conversionKilometros(dato);
                    System.out.println("el resultado es: " + resultado + " millas");
                    KmaMillas++;
                    break;
                case 4:
                    System.out.println("elegiste la cuarta opcion");
                    dato = DatoIngresado(scanner, "ingresa las millas:");
                    resultado = conversionMillas(dato);
                    System.out.println("el resultado es: " + resultado + " Km");
                    millasKm++;
                    break;
                case 5:
                    System.out.println("salir");
                    break;
            }
        } while (opcion != 5);
        ResumenImprimir();
        scanner.close();
    }
    public static int obtenerNumero(Scanner scanner, String mensaje) {
        int opcion;
        while (true) {
            System.out.print(mensaje + " ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion>=1 && opcion<=5) {
                    return opcion;
                } else {
                    System.out.println("el dato que ingresaste esta fuera del rango, vuelve a elegir");
                }
            } else {
                System.out.println("el dato que ingresaste no es numerico");
                scanner.next();
            }
        }
    }

    public static double DatoIngresado(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje + " ");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("ingresa un valor numérico válido.");
                scanner.next();
            }
        }
    }

    public static double conversionC(double dato) {
        return(dato*(9.0/5.0)+32);
    }

    public static double conversionfahrenheit(double dato) {
        return(dato-32)*5/9;
    }

    public static double conversionKilometros(double dato) {
        return dato*0.621371;
    }

    public static double conversionMillas(double dato) {
        return dato*1.60934;
    }

    public static void ResumenImprimir() {
        System.out.println("las conversiones ingresadas fueron las siguientes: ");
        System.out.println("conversion °C a °F: " + celciusaFahrenheit);
        System.out.println("conversion °F a °C: " + fahrenheitaCelcius);
        System.out.println("conversion km a millas: " + KmaMillas);
        System.out.println("conversion millas a km: " + millasKm);
        System.out.println("total de conversiones realizadas: " + (celciusaFahrenheit + fahrenheitaCelcius + KmaMillas + millasKm));
    }
}