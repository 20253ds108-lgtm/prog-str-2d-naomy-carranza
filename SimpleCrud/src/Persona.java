public class Persona {

    int id;
    String nombre;
    boolean activa;

    public Persona(int id, String nombre) {
        this.id=id;
        this.nombre=nombre;
        this.activa=true;
    }
    public int getId() {
        return id;
    }
    public String Nombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isActiva() {
        return activa;
    }
    public void Activa(boolean activa) {
        this.activa = activa;
    }
    public String toString() {
        return String.format("el id y el nombre fueron", id, nombre);
    }
}
