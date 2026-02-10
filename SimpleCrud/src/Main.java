import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        PersonaService personaService=new PersonaService();
        Persona[] personas=new Persona[20];

        int opcion = 0;
        do {
            System.out.println("menu");
            System.out.println("1- alta");
            System.out.println("2- buscar por id");
            System.out.println("3- baja logica por id");
            System.out.println("4- lista activas");
            System.out.println("5- actualizar nombre por id activas");
            System.out.println("0- salir del programa");
            System.out.print("Ingresa una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    personaService.alta(personas);
                    break;
                case 2:
                    personaService.buscarIndicePorId(personas);
                    break;
                case 3:
                    personaService.BajaPorID(personas);
                    break;
                case 4:
                    personaService.listaDeActivas(personas);
                    break;
                case 5:
                    personaService.actualizarNombre(personas);
                    break;
                case 0:
                    System.out.println("saliste del prorama");
                    break;
                default:
                    System.out.println("valor fuera de rango");
                    break;
            }
        }while (opcion !=0);
    }
}