package com.example.demolistview.controllers;

import com.example.demolistview.servises.PersonServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.text.html.ListView;

public class AppControllers {
    @FXML
    private ListView listView;
    @FXML
    private Label lblMsg;

    @FXML
    private final ObservableList data=FXCollections.observableArrayList();

    private PersonServices services=new PersonServices();
}
