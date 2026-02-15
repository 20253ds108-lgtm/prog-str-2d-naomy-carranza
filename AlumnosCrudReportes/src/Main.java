import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Alumno[] alumno=new Alumno[25];
        DedarrolloAlumno dedarrolloAlumno=new DedarrolloAlumno();
        int opcion=0;
        do {
            System.out.println("menu de gestion de alumnos :)");
            System.out.println("1- alta de alumno");
            System.out.println("2- buscar por id activo");
            System.out.println("3- actualizar promedio por id activo");
            System.out.println("4- baja logica por id");
            System.out.println("5- lista activos");
            System.out.println("6- reportes");
            System.out.println("0- salir del programa");
            System.out.println("selecciona una opcion :D");
            opcion=scanner.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("el programa termino");
                    break;
                case 1:
                    dedarrolloAlumno.altaAlumno(alumno);
                    break;
                case 2:
                    dedarrolloAlumno.buscarId(alumno);
                    break;
                case 3:
                    dedarrolloAlumno.actualizarPromedio(alumno);
                    break;
                case 4:
                    dedarrolloAlumno.bajaPorId(alumno);
                    break;
                case 5:
                    dedarrolloAlumno.listaActivos(alumno);
                    break;
                case 6:
                    dedarrolloAlumno.reporte(alumno);
                    break;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        }while (opcion != 0);
    }
}