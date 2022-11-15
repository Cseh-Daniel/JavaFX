package com.example.javafx_beadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class HelloController {


    public TableView tabla;




    public void initialize(){

        tabla.setVisible(false);
    }

    public void olvasas() {

        tabla.setVisible(true);
        tabla.getColumns().removeAll(tabla.getColumns());

        TableColumn filmcim = new TableColumn("filmcim");
        TableColumn szarmazas = new TableColumn("szarmazas");
        TableColumn mufaj = new TableColumn("mufaj");
        TableColumn mozinev = new TableColumn("mozinev");
        TableColumn cim = new TableColumn("cim");


        tabla.getColumns().addAll(filmcim,szarmazas,mufaj,mozinev,cim);

       // TableColumn tableColumn=new TableColumn<>("filmcim");
        //filmcim,szarmazas,mufaj,mozinev,cim

         String url="jdbc:mysql://localhost/mozimusor?user=root";


        tabla.getItems().add(new DatabaseDAO(url).getAll());


        filmcim.setCellValueFactory(new PropertyValueFactory<>("filmcim"));
        szarmazas.setCellValueFactory(new PropertyValueFactory<>("szarmazas"));
        mufaj.setCellValueFactory(new PropertyValueFactory<>("mufaj"));
        mozinev.setCellValueFactory(new PropertyValueFactory<>("mozinev"));
        cim.setCellValueFactory(new PropertyValueFactory<>("cim"));
        
        ArrayList<Database> lista = new DatabaseDAO(url).getAll();

        for(int i = 0; i < lista.size()-1; i++ )
        {
            tabla.getItems().add(lista.get(i));
        }


    }

    public void olvasas2(){

        tabla.setVisible(true);


        TableColumn tableColumn=new TableColumn<>("körte");
        tabla.getColumns().removeAll(tabla.getColumns());
        tabla.getColumns().add(tableColumn);


    }

}