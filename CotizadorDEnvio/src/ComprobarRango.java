import java.util.Scanner;
public class ComprobarRango {

    public int leerIntEnRango(Scanner scanner, String mensaje,int minimo,int maximo){
        int value;
        while (true){
            System.out.println(mensaje);
            if (scanner.hasNextInt()){
                value=scanner.nextInt();
                if (value>=minimo && value<=maximo){
                    return value;
                }
                System.out.println("el numero ingresado esta fuera del ranfo de 1 a 2000");
            }else {
                System.out.println("el numero ingresado esta fuera del rango");
                scanner.next();
            }
        }
    }


    public double leerDoubleEnRango(Scanner scanner, String mensaje, double minimo, double maximo){
        double value;
        while (true){
            System.out.println(mensaje);
            if (scanner.hasNextDouble()){
                value=scanner.nextDouble();
                if (value>=minimo && value<=maximo){
                    return value;
                }
                System.out.println("el numero ingresado esta fuera del rango");
            }else {
                System.out.println("el dato que estas ingresando no es un dato numerico");
                scanner.next();
            }
        }
    }


    public boolean leerBoolean(Scanner scanner, String mensaje){
        while (true){
            System.out.println(mensaje);
            if (scanner.hasNextBoolean()){
                return scanner.nextBoolean();
            }else {
                System.out.println("el dato ingresado no es una desicion boleana");
                scanner.next();
            }
        }
    }
}

