package com.example.practicaexamen.service;

import com.example.practicaexamen.contactos.Contactos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
public class ContactosService {
    private ObservableList<Contactos> listaContactos=FXCollections.observableArrayList();

    public void agregarContacto(String nombre, String celular, String parentesco) throws  IOException {
            validarContacto(nombre,celular,parentesco);
            String nombreNoComa=nombre.replace(",", "");
            String telefonoNoComa=celular.replace(",", "");
            Contactos nuevo=new Contactos(nombreNoComa, telefonoNoComa, parentesco);
            listaContactos.add(nuevo);
    }
    public void actualizarContacto(int index, String nombre, String celular, String parentesco) {
        if (index < 0 || index >= listaContactos.size()) {
            throw new IllegalArgumentException("seleccione un contacto para actualizar");
        }
        validarContacto(nombre, celular, parentesco);
        Contactos contactoActualizado=new Contactos(nombre, celular, parentesco);
        listaContactos.set(index, contactoActualizado);
    }
    public void eliminsrContacto(int index) {
        if (index >= 0 && index < listaContactos.size()) {
            listaContactos.remove(index);
        } else {
            throw new IllegalArgumentException("selecciona un contacto para eliminar.");
        }
    }
    public void validarContacto(String nombre, String celular, String parentesco){
        if (nombre.isBlank() || nombre.isEmpty() || nombre.length()<3 ) {
            throw new IllegalArgumentException("no cumple los caracteres necesarios");
        }
        if (parentesco==null) {
            throw new IllegalArgumentException("seleccione un parentesco");
        }
        try {
            if (!(celular==null || celular.trim().length()==10)) {
                throw new IllegalArgumentException("el celular ingresado no es valido");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El celular debe ser numerico");
        }
    }
    public boolean duplicarContacto(String nombreNuevo){
        for (Contactos contacto : listaContactos) {
            if (contacto.getNombrefamiliar().equalsIgnoreCase(nombreNuevo.trim())) {
                return true;
            }
        }
        return false;
    }
    public ObservableList<Contactos> obtenerLista() {
        return listaContactos;
    }
}
