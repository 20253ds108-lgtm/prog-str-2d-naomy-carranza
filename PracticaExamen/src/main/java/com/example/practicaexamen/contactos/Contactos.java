package com.example.practicaexamen.contactos;
public class Contactos {
    private String nombrefamiliar;
    private String celular;
    private String parentescofamiliar;

    public Contactos(String nombre, String celular, String parentesco) {
        this.nombrefamiliar=nombre;
        this.celular=celular;
        this.parentescofamiliar=parentesco;
    }
    public String getNombrefamiliar() {
        return nombrefamiliar;
    }
    public void setNombrefamiliar(String nombrefamiliar) {
        this.nombrefamiliar=nombrefamiliar;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular=celular;
    }
    public String getParentescofamiliar() {
        return parentescofamiliar;
    }
    public void setParentescofamiliar(String parentescofamiliar) {
        this.parentescofamiliar=parentescofamiliar;
    }
    @Override
    public String toString() {
        return nombrefamiliar+" - " + celular+" - "+parentescofamiliar;
    }
}
