package com.example.javafx_beadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class HelloController {

    public Button btn1;
    public Button btn2;
    public TableView tabla;


    public void initialize(){
        btn1.setVisible(false);
        btn2.setVisible(false);
        tabla.setVisible(false);
    }

    public void olvasas() {

        btn1.setVisible(true);
        btn2.setVisible(false);
        tabla.setVisible(true);

        TableColumn tableColumn=new TableColumn<>("alma");

        tabla.getColumns().removeAll(tabla.getColumns());
        tabla.getColumns().add(tableColumn);

    }

    public void olvasas2(){
        btn1.setVisible(false);
        btn2.setVisible(true);
        tabla.setVisible(true);


        TableColumn tableColumn=new TableColumn<>("körte");
        tabla.getColumns().removeAll(tabla.getColumns());
        tabla.getColumns().add(tableColumn);


    }

}