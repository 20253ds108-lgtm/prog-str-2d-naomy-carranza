import java.util.Scanner;

public class ValorValidar {

    public int validarId(Scanner sc, String msj, Persona[] personas){
        int valor = 0;
        while (true){
            System.out.print(msj);
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                if (valor>=0 && valor <20){
                    for (int i = 0; i < personas.length; i++) {
                        personas[i] = new Persona();
                        if ((personas[i] != null) && (personas[i].getId() == valor)){
                            System.out.println("Este ID ya existe");
                            sc.next();
                            break;
                        }else {
                            return valor;
                        }
                    }
                }else {
                    System.out.println("El id tiene que ser mayor a 0 y menor a 20");
                }
            }else {
                System.out.println("El valor ingresado no es valido");
                sc.next();
            }
        }
    }

    public String validarNombre(Scanner sc, String msj){
        while (true){
            System.out.println(msj);
            String valor = sc.next();
            if (!valor.isEmpty()){
                return valor;
            }else {
                System.out.print("El campo no puede quedar vacio");
                sc.next();
            }
        }
    }
}