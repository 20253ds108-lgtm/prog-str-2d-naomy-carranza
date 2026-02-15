import java.util.Scanner;

public class DatosValidados {
    public int comprobarId(Scanner scanner, String mensaje){
        int valor=0;
        while (true){
            System.out.print(mensaje);
            if (scanner.hasNextInt()){
                valor=scanner.nextInt();
                if (valor>=0 && valor<25){
                    return valor;
                }else {
                    System.out.println("el valor no esta dentro del rango");
                }
            }else {
                System.out.println("valor invalido");
                scanner.next();
            }
        }
    }

    public String comprobarNombre(Scanner scanner, String mensaje){
        String valor ="";
        while (true){
            System.out.print(mensaje);
            valor=scanner.next();
            if (!(valor.isEmpty())){
                return valor;
            }else {
                System.out.println("el nombre no puede estar vacio");
                scanner.next();
            }
        }
    }

    public double comprobarPromedio(Scanner scanner, String mensaje){
        double valor=0;
        while (true){
            System.out.print(mensaje);
            if (scanner.hasNextDouble()){
                valor=scanner.nextDouble();
                if (valor>= 0 && valor<=10){
                    return valor;
                }else {
                    System.out.println("el valor esta fuera del rango");
                }
            }else {
                System.out.println("valor invalido");
                scanner.next();
            }
        }
    }
}