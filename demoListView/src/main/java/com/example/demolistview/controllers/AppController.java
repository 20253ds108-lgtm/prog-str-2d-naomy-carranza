package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtedad;
    @FXML
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonServices service = new PersonServices();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            loadDataToForm(newValue);
                }
        );
        loadFromFile();
    }

    @FXML
    public void onAddPerson() throws IOException {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtedad.getText();
            service.addPerson(name,email,edad);
            lblMsg.setText("se agrego con exito ");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtedad.clear();
            loadFromFile();
        }catch (IOException e){
            lblMsg.setText("error no se agrego correctamente");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtedad.getText();

        try {
            service.updatePerson(index, name,email,edad);
            loadFromFile();
            lblMsg.setText("se actualizada con exito ");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtEmail.clear();
            txtedad.clear();
        }catch (IOException e){
            lblMsg.setText("error no se agrego correctamente");
            lblMsg.setStyle("-fx-text-fill: red");
        }catch (IllegalArgumentException ex){
            lblMsg.setText("error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForList();
            data.setAll(items);
            lblMsg.setText("datos agregados exitosamente");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    private void loadDataToForm(String item){

        String[] parts=item.split("-");
        txtName.setText(parts[0]);
        txtEmail.setText(parts[1]);
        txtedad.setText(parts[2]);
    }
}
