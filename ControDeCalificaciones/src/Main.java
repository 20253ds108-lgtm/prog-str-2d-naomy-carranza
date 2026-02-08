import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        GradeService gradeService=new GradeService();
        ComprobarRangos comprobarRangos=new ComprobarRangos();

        String NombreAlumno=comprobarRangos.leerTextoNoVacio(scanner, "ingresa nombre del alumno: ");
        double parcial1=comprobarRangos.leerDoubleEnRango(scanner, "ingresa la calificacion del primer parcial: ", 0,100);
        double parcial2=comprobarRangos.leerDoubleEnRango(scanner, "ingresa la calificacion del segundo parcial: ", 0,100);
        double parcial3=comprobarRangos.leerDoubleEnRango(scanner, "ingresa la calificacion del tercer parcial: ", 0,100);
        double promedio= gradeService.PromedioParciales(parcial1, parcial2, parcial3);
        int asistencia= comprobarRangos.leerIntEnRango(scanner, "ingresa las asistencias", 0, 100);
        boolean entregaproyecto= comprobarRangos.leerBoolean(scanner, "¿entrego proyecto? true/false");
        double promediofinal= gradeService.calculofinal(promedio, asistencia);
        System.out.println(gradeService.determinarEstado(asistencia, entregaproyecto, promediofinal));
        gradeService.imprimirReporte(NombreAlumno, parcial1, parcial2, parcial3, promedio, asistencia, entregaproyecto, promediofinal);
    }
}
