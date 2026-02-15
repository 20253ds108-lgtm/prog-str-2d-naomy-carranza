import java.util.Scanner;

public class DedarrolloAlumno {
    Scanner scanner=new Scanner(System.in);
    private Alumno[] alumno=new Alumno[25];
    DatosValidados datosValidados=new DatosValidados();

    public void altaAlumno(Alumno[] alumnos){
        int id=datosValidados.comprobarId(scanner, "ingresa el id: ");

        while (true) {
            boolean idduplicado=false;
            for (Alumno alumno : alumnos) {
                if (alumno!=null && alumno.getId()==id) {
                    idduplicado=true;
                    break;
                }
            }
            if (idduplicado) {
                System.out.println("este id "+id+" ya esta existiendo");
                return;
            } else {
                String nombre = datosValidados.comprobarNombre(scanner, "ingresa el nombre del alumno: ");
                double promedio = datosValidados.comprobarPromedio(scanner, "ingresa el promedio del alumno: ");
                alumnos[id]=new Alumno(id, nombre, promedio);
                System.out.println("se registro correctamente");
                break;
            }
        }
    }

    void buscarId(Alumno[] alumnos){
        boolean encontrarPosicion=false;
        int id = datosValidados.comprobarId(scanner, "ingresa el id que quieres buscar");
        for (int i = 0; i <= alumnos.length; i++) {
            if (alumnos[i].getId()==id){
                System.out.println(alumnos[i]);
                encontrarPosicion=true;
                break;
            }
        }
        if (encontrarPosicion==false){
            System.out.println("no se encontro al alumno");
        }
    }

    void actualizarPromedio(Alumno[] alumno){
        boolean idEncontrado=false;
        int id = datosValidados.comprobarId(scanner, "id del alumno para actualizar promedio: ");
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i]!=null && alumno[i].getId()==id){
                double promedio=datosValidados.comprobarPromedio(scanner, "ingresa el nuevo promedio: ");
                alumno[i].setPromedio(promedio);
                System.out.println("promedio actualizado");
                idEncontrado=true;
            }
        }
        if (!idEncontrado){
            System.out.println("no se pudo encontrar al alumno");
        }
    }

    void bajaPorId(Alumno[] alumno){
        boolean idEncontrado=false;
        int id = datosValidados.comprobarId(scanner, "ingresa el id para dar de baja ");
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] !=null && alumno[i].getId() ==id){
                alumno[i].setActivo(false);
                System.out.println("baja logica realizada");
                idEncontrado=true;
            }
        }
        if (!(idEncontrado)){
            System.out.println("no se encontro el id");
        }
    }

    void listaActivos(Alumno[] alumno){
        boolean hayAlumnos=false;
        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i] !=null  && alumno[i].isActivo()){
                System.out.println(alumno [i]);
                hayAlumnos=true;
            }
        }
        if (!hayAlumnos){
            System.out.println("no se encontraron registros");
        }
    }

    void reporte(Alumno[] alumno){
        int alumnosPromedio=0;
        double promedioGeneral=0;
        double promedioMayor=0;
        double promedioMenor=10;
        int cantidadAlumnos=0;
        Alumno mayor=null;
        Alumno menor=null;

        for (int i = 0; i < alumno.length; i++) {
            if (alumno[i]!= null && alumno[i].isActivo() ){
                promedioGeneral+=alumno[i].getPromedio();
                cantidadAlumnos++;
                if (promedioMayor<alumno[i].getPromedio()){
                    promedioMayor=alumno[i].getPromedio();
                    mayor=alumno[i];
                }
                if(promedioMenor>alumno[i].getPromedio()){
                    promedioMenor=alumno[i].getPromedio();
                    menor=alumno[i];
                }
                if (alumno[i].getPromedio()>=8.0){
                    alumnosPromedio++;
                }
            }
        }
        double promedioFinal=promedioGeneral/cantidadAlumnos;
        System.out.println("el promedio final fue de: "+promedioFinal);
        System.out.println("el mayor promedio fue de: "+mayor);
        System.out.println("el promedio menor fue de: "+menor);
        System.out.println("alumnos con promedio de 8.0: "+alumnosPromedio);
    }
}