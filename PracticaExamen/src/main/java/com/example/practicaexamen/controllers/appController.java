package com.example.practicaexamen.controllers;

import com.example.practicaexamen.contactos.Contactos;
import com.example.practicaexamen.service.ContactosService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
public class appController {
    @FXML
    private ListView<Contactos> listView;
    @FXML
    private Label lblmsg;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtcelular;
    @FXML
    private ComboBox parentescofamiliar;
    @FXML
    private TextField txtbusqueda;
    @FXML
    private ContactosService logica=new ContactosService();
    @FXML
    public void initialize() {
        String[] opcionesParentesco = {"padre", "madre", "hermano", "hermana", "abuelo", "abuela", "tío", "tía"};
        parentescofamiliar.getItems().addAll(opcionesParentesco);
        listView.setItems(logica.obtenerLista());
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue != null) {
                        txtname.setText(newValue.getNombrefamiliar());
                        txtcelular.setText(newValue.getCelular());
                        parentescofamiliar.setValue(newValue.getParentescofamiliar());
                    }
                }
        );
        txtbusqueda.textProperty().addListener((obs, old, newValue) -> {
            filterList(newValue);
        });
    }
    private void filterList(String dato) {
        if (dato == null || dato.isEmpty()) {
            listView.setItems(logica.obtenerLista());
            return;
        }

        ObservableList<Contactos> listaFiltrada = FXCollections.observableArrayList();
        String busqueda = dato.toLowerCase();

        for (Contactos item : logica.obtenerLista()) {
            if (item.getNombrefamiliar().toLowerCase().contains(busqueda)) {
                listaFiltrada.add(item);
            }
        }
        listView.setItems(listaFiltrada);
    }
    @FXML
    public void onSearch(){
        txtbusqueda.textProperty().addListener((obs, old, newValue) -> {
            filterList(newValue);
        });
    }
    @FXML
    public void onAddPerson() {
        try {
            String nombre=txtname.getText();
            String telefono=txtcelular.getText();
            String parentescoFamiliar=parentescofamiliar.getValue().toString();
            if (parentescoFamiliar==null) {
                throw new IllegalArgumentException("seleccione el parentezco");
            }else if (logica.duplicarContacto(nombre)){
                throw new IllegalArgumentException("no se puede colocar el nombre igual");
            }else {
                logica.agregarContacto(nombre,telefono, parentescoFamiliar);
                loadFromFile();
                lblmsg.setText("se agrego con exito");
                lblmsg.setStyle("-fx-text-fill: green");
                txtname.clear();
                txtcelular.clear();
                parentescofamiliar.setValue(null);
            }
        }
        catch (IOException e) {
            lblmsg.setText("error datos invalidos");
            lblmsg.setStyle("-fx-text-fill: red");
        }
        catch (IllegalArgumentException e){
            lblmsg.setText("error numero de celular invalido");
            lblmsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onUpdate(){
        int index=listView.getSelectionModel().getSelectedIndex();
        String nombre=txtname.getText();
        String cel=txtcelular.getText();
        String parentescoFamiliar=parentescofamiliar.getSelectionModel().getSelectedItem().toString();
        try{
            logica.actualizarContacto(index, nombre, cel, parentescoFamiliar);
            logica.validarContacto(nombre, cel, parentescoFamiliar);
            loadFromFile();
            lblmsg.setText("persona agregada con exito ");
            lblmsg.setStyle("-fx-text-fill: green");
            txtname.clear();
            txtcelular.clear();
            parentescofamiliar.setValue(null);
        } catch (IllegalArgumentException ex){
            lblmsg.setText(ex.getMessage());
            lblmsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onClean(){
        txtname.clear();
        txtcelular.clear();
        parentescofamiliar.setValue(null);
    }
    @FXML
    public void onDelete(){
        int index=listView.getSelectionModel().getSelectedIndex();
        try{
            logica.eliminsrContacto(index);
            loadFromFile();
            lblmsg.setText("se elimino correctamente");
            lblmsg.setStyle("-fx-text-fill: green");
            txtname.clear();
            txtcelular.clear();
            parentescofamiliar.setValue(null);
        }catch (IllegalArgumentException e){
            lblmsg.setText("error");
            lblmsg.setStyle("-fx-text-fill: red");
        }
    }
    public void onReload(){
        loadFromFile();
    }
    private void loadFromFile(){
        listView.setItems(logica.obtenerLista());
        lblmsg.setText("se actualizo la lista");
        lblmsg.setStyle("-fx-text-fill: green");
    }
}
