import java.util.Scanner;

public class ComprobarValor {
    public int validarId(Scanner scanner, String mensaje, Persona[] personas){
        int valor=0;
        while (true){
            System.out.print(mensaje);
            if (scanner.hasNextInt()){
                valor=scanner.nextInt();
                if (valor>=0 && valor <20){
                    return valor;
                }else {
                    System.out.println("ingresa id mayor a 0 y menor a 20");
                }
            }else {
                System.out.println("el valor ingresado no es valido");
                scanner.next();
            }
        }
    }
    public String validarNombre(Scanner scanner, String mensaje){
        while (true){
            System.out.print(mensaje);
            String valor=scanner.next();
            if (!valor.isEmpty()){
                return valor;
            }else {
                System.out.print("no puedes ingesar texto vacio");
                scanner.next();
            }
        }
    }
}
