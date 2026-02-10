import java.util.Scanner;

public class PersonaService {
    Scanner scanner=new Scanner(System.in);
    ValorValidar valorValidar=new ValorValidar();


    public void alta(Persona[] personas) {

        int id=valorValidar.validarid(scanner, "ingresa el nuevo id", personas);
        String nombre=valorValidar.Validarnombre(scanner, "ingresa el nombre: ");


        for (int i = 0; i < personas.length; i++) {
            if (!(personas[id]==null)) {
                personas[id]=new Persona();
                personas[id].setId(id);
                personas[id].setNombre(nombre);
                personas[id].setActiva(true);

                break;
            }
        }
    }
}