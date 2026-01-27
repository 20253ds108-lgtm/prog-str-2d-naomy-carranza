import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int edad=0;
        int opcion=0;
        boolean esEstudiante=false;
        int tarifa=0;


        System.out.println("ingresa tu edad: ");
        edad = scanner.nextInt();
        System.out.println("¿eres estudiante?: ");
        System.out.println("1-si, 2-no");
        opcion = scanner.nextInt();
        esEstudiante = VerificarSiesEstudiante(opcion);

        //comprobar si puede o no entrar al programa
        if (edad<0 || edad>120 ){
            System.out.println("edad invalida");
            return;
        }

        //imprimir los datos finales
        tarifa=CalcularTarifa(edad, esEstudiante);
        System.out.println("tu edad ingrersada es: "+edad);
        if (esEstudiante==true){
            System.out.println("eres estudiante");
        }else {
            System.out.println("no eres es un estudiante");
        }
        System.out.println("la tarifa final es de: "+tarifa);
    }

    //calcular la tarifa final
      public static int CalcularTarifa(int edad, boolean esEstudiante){
        if (edad<12){
            return 50;
        }else if(edad>=12 && edad<=17){
            if (esEstudiante==true){
                return 60;
            }else{
                return 80;
            }
        }else{
            if (esEstudiante==true){
                return 90;
            }else {
                return 120;
            }
        }
    }

    /**
     * comprobar si es estudiante
     * @param opcion
     * @return
     */
    public static boolean VerificarSiesEstudiante(int opcion){
        if (opcion == 1){
            return true;
        }else {
            return false;
    }
    }
}
