import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        double variableA = 0;
        double variableB = 0;
        double resultado = 0;

        System.out.println("1- sumar");
        System.out.println("2- restar");
        System.out.println("3- multiplicar");
        System.out.println("4- dividir");

        //almacenamos la opcion elegida del usuario
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                variableA = capturarDatos(scanner, "ingresa tu primer numero: ");
                variableB = capturarDatos(scanner, "ingresa tu segundo numero: ");
                resultado = OpcionSuma(variableA, variableB);
                break;
            case 2:
                variableA = capturarDatos(scanner, "ingresa tu primer numero: ");
                variableB = capturarDatos(scanner, "ingresa tu segundo numero: ");
                resultado = OpcionResta(variableA, variableB);
                break;
            case 3:
                variableA = capturarDatos(scanner, "ingresa tu primer numero: ");
                variableB = capturarDatos(scanner, "ingresa tu segundo numero: ");
                resultado = OpcionMultiplicacion(variableA, variableB);
                break;
            case 4:
                variableA = capturarDatos(scanner, "ingresa tu primer numero: ");
                variableB = capturarDatos(scanner, "ingresa tu segundo numero: ");
                if (variableB == 0) {
                    System.out.println("no se puede dividir entre cero");
                } else {
                    resultado = OpcionDivision(variableA, variableB);
                }
                break;
            default:
                System.out.println("opcion invalida");
                break;
        }
        if (opcion>=1 && opcion <=4){
            String opcionFinal=OpcionSeleccionada(opcion);
            System.out.println("opcion elegida: "+opcionFinal);
            System.out.println("valores ingresados: " +variableA+ " y " +variableB);
            if (opcion==4 && variableB==0){
                return;
            }else {
                System.out.println("el resultado final es de: "+resultado);
            }
        }

    }
    public static double capturarDatos(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextDouble();
    }

    public static double OpcionSuma(double variableA, double variableB){
        return variableA+variableB;
    }

    public static double OpcionResta(double variableA, double variableB){
        return variableA-variableB;
    }

    public static double OpcionMultiplicacion(double variableA, double variableB){
        return variableA*variableB;
    }

    public static double OpcionDivision(double variableA, double variableB){
        return variableA/variableB;
    }

    public static String OpcionSeleccionada(int opcion){
        if (opcion ==1 ){
            return "sumar";
        }else if (opcion==2){
            return "restar";
        }else if (opcion==3){
            return "multiplicacion";
        }else {
            return "dividir";
        }
    }
}