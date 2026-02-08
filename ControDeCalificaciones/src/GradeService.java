public class GradeService {
    private final int NUMPARCIALES=3;
    private final String NombreAlumno="";
    private final int asistencia=0;
    private final boolean entregaProyecto=false;
    private final double promediofinal=0;

    double PromedioParciales(double parcial1, double parcial2, double parcial3){
        return (parcial1+parcial2+parcial3)/NUMPARCIALES;
    }
    double calculofinal(double promedio, int asistencia){
        return (promedio * 0.7) + (asistencia * 0.3);
    }

    String determinarEstado(int asistencia, boolean entregaProyecto, double calificacionfinal) {
        if (asistencia < 80) {
            return "reprobado por asistencia";
        }
        if (entregaProyecto == false) {
            return "reprobado por proyecto";
        }
        if (calificacionfinal>=70){
            return "aprobado";
        }else{
            return "reprobado por calficacion";
        }

    }
    void imprimirReporte(String nombreAlumno, double parcial1, double parcial2, double parcial3, double promedio, int asistencia, boolean entregaProyecto, double calificacopnfinal){
        if (determinarEstado(asistencia, entregaProyecto, calificacopnfinal).equals("aprobado")){
            System.out.println("nombre del alumno: "+nombreAlumno);
            System.out.println("calificacion del primer parcial: "+parcial1);
            System.out.println("calificacion del segundo parcial: "+parcial2);
            System.out.println("calificacion del tercer parcial: "+parcial3);
            System.out.println("el promedio final es de: "+promedio);
            System.out.println("la asistencia final fue: "+asistencia);
            if (entregaProyecto==true){
                System.out.println("sí entrego el proyecto :D");
            }else{
                System.out.println("no entrego el proyecto D:");
            }
            System.out.println("la calificacion final es: "+calificacopnfinal);
        }

    }
}
