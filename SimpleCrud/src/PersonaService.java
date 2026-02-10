import java.util.Scanner;

public class PersonaService {
    Scanner scanner=new Scanner(System.in);
    ComprobarValor comprobarValor=new ComprobarValor();
    private Persona[] personas=new Persona[20];

    public void alta(Persona[] personas) {
        int id=comprobarValor.validarId(scanner, "ingresa el id nuevo: ", personas);
        int idLibre=-1;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                idLibre = i;
                break;
            }
        }
        if (idLibre == -1) {
            System.out.println("arreglo lleno");
            return;
        }
        while (true) {
            boolean duplicado = false;
            for (Persona persona : personas) {
                if (persona != null && persona.getId() == id) {
                    duplicado = true;
                    break;
                }
            }
            if (duplicado) {
                System.out.println("el id ingresado " + id + " existe ya");
                return;
            } else {
                String nombre = comprobarValor.validarNombre(scanner, "ingresa el nombre: ");
                personas[idLibre] = new Persona(id, nombre);
                System.out.println("se registro correctamente");
                break;
            }
        }
    }
    void buscarIndicePorId(Persona[] personas) {
        boolean idEncontrado = false;
        int id = comprobarValor.validarId(scanner, "id ingresado a buscar: ", personas);

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                System.out.println(personas[i]);
                idEncontrado = true;
                break;
            }
        }
        if (!idEncontrado) {
            System.out.println("no se pudo encontar el id :(");
        }
    }
    void BajaPorID(Persona[] personas) {
        boolean idEncontrado = false;
        int id = comprobarValor.validarId(scanner, "ingresa id para poder dar de baja: ", personas);
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                personas[i] = null;
                System.out.println("id se borro");
                idEncontrado = true;
                break;
            }
        }
        if (!idEncontrado) {
            System.out.println("no se encontro id :(");
        }
    }
    void listaDeActivas(Persona[] personas) {
        boolean idEncontrado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                System.out.println(personas[i]);
                idEncontrado = true;
            }
        }
        if (!idEncontrado) {
            System.out.println("no existen id registradas");
        }

    }
    void actualizarNombre(Persona[] personas) {
        int id = comprobarValor.validarId(scanner, "id para actualizar: ", personas);
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id && personas[i].isActiva()) {
                String nombre = comprobarValor.validarNombre(scanner, "ingresa el nuevo nombre: ");
                personas[i].setNombre(nombre);
                System.out.println("nombre  y id se actualizo");
                return;
            }
        }
        System.out.println("id desactivada o no existe");
    }
}

