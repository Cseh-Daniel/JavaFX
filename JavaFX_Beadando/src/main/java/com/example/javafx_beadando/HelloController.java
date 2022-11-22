package com.example.javafx_beadando;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class HelloController {


    @FXML public VBox OlvasasMenu;
    @FXML public TableView<Database> tOlvas;
    //Lapok:
    public VBox vbOlvas;
    public VBox vbInsert;
    public VBox vbUpdate;
    public VBox vbShowUpdate;
    public VBox vbDelete;
    public VBox vbRest1Get;
    public VBox vbRest1;
    public HBox mainCucc;
    public VBox vbEgyeb;
    public VBox vbParhuzamos;
    public VBox vbRest1Post;

    public TableView tRest1Get;
    //Gombok mütyürkék:
    public ComboBox cbOlvasas;
    public TextField tfOlvas;
    public CheckBox cbSzines;
    public ToggleGroup group;
    public TextField tfInsertPizzaNev;
    public ComboBox cbInsertMufaj;
    public CheckBox tfInsertVega;
    public ComboBox cbShowKateg;
    public TextField tfUpdateKategNev;
    public TextField tfupdateKategAr;
    public ComboBox cbShowPizza;
    //POST
    public TextField tfRest1PostId;
    public ComboBox tfRest1PostStatus;
    public ComboBox tfRest1PostGender;
    public TextField tfRest1PostEmail;
    public TextField tfRest1PostName;
    public Label lResponseRest1Post;
    public TextField tfRest1Delete;
    public VBox vbRest1Delete;
    public Label lDeleted;
    public VBox vbRest1Update;
    public Label lUpdated;
    public TextField tfRest1UpdateId;
    public TextField tfRest1UpdateName;
    public TextField tfRest1UpdateEmail;
    public ComboBox cbRest1UpdateGender;
    public ComboBox cbRest1UpdateStatus;
    public TextField tfRest2PostId;
    public ComboBox tfRest2PostStatus;
    public ComboBox tfRest2PostGender;
    public TextField tfRest2PostEmail;
    public TextField tfRest2PostName;
    public Label lResponseRest2Post;
    public TextField tfRest2Delete;
    public VBox vbRest2Delete;
    public Label lDeleted2;
    public VBox vbRest2Update;
    public Label lUpdated2;
    public TextField tfRest2UpdateId;
    public TextField tfRest2UpdateName;
    public TextField tfRest2UpdateEmail;
    public ComboBox cbRest2UpdateGender;
    public ComboBox cbRest2UpdateStatus;
    public Button bParhuzamos;
    public Label lParhuzamos1;
    public Label lParhuzamos2;
    public TextField tfStreamId;
    public ComboBox cbStreamkateg;
    public VBox vbStream;
    public CheckBox cbStreamVega;
    public TableView tStream;
    public ToggleGroup group1;
    public VBox vbRest2Post;
    public TableView tRest2Get;
    public VBox vbRest2Get;
    public VBox vbRest2;
    public ComboBox cbInsertSzines;
    public ComboBox cbInsertSzinkron;
    public TextField tfInsertSzarmazas;
    public TextField tfInsertHossz;
    public TextField tfInsertFilmcim;
    String url="jdbc:mysql://localhost/mozimusor?user=root";
    DatabaseDAO database=new DatabaseDAO(url);

    public void Clear()
    {
        mainCucc.getChildren().removeAll(mainCucc.getChildren());
        cbShowKateg.setDisable(false);
    }

    public void Mutat(String a){
    Clear();

    switch(a){

        case "OlvasMenu":
            mainCucc.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
            OlvasasMenu.getChildren().add(tOlvas);
            break;
        case "Olvas2Menu":
            mainCucc.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());
            OlvasasMenu.getChildren().addAll(vbOlvas,tOlvas);
            break;
        case "Insert":
            mainCucc.getChildren().add(OlvasasMenu);
            OlvasasMenu.getChildren().removeAll(OlvasasMenu.getChildren());

            cbInsertMufaj.getItems().removeAll(cbInsertMufaj.getItems());
            cbInsertMufaj.getItems().addAll(database.Mufajok());

            cbInsertSzinkron.getItems().removeAll(cbInsertSzinkron.getItems());
            cbInsertSzinkron.getItems().addAll("fel","mb");

            cbInsertSzines.getItems().removeAll(cbInsertSzines.getItems());
            cbInsertSzines.getItems().addAll("0","-1");

            OlvasasMenu.getChildren().addAll(vbInsert);
            break;
    }


    }

    public  void Tabla(String a)
    {
        ArrayList<Database> filmek = database.getAll(a);

        if(filmek == null || filmek.isEmpty())
        {
            tOlvas.getItems().removeAll(tOlvas.getItems());
            tOlvas.getColumns().removeAll(tOlvas.getColumns());
            TableColumn filmnev = new TableColumn("Nincs adat");
            tOlvas.getColumns().addAll(filmnev);
            filmnev.setCellValueFactory(new PropertyValueFactory<>("filmcim"));

            tOlvas.getItems().add(new Database("Nincs ilyen adat!","Nincs","Nincs","Nincs","Nincs","nincs",false));
        }
        else
        {
            tOlvas.getItems().removeAll(tOlvas.getItems());
            tOlvas.getColumns().removeAll(tOlvas.getColumns());

            TableColumn filmcim = new TableColumn("filmcim");
            TableColumn szarmazas = new TableColumn("származás");
            TableColumn mufaj = new TableColumn("műfaj");
            TableColumn mozinev = new TableColumn("Mozinév");
            TableColumn cim = new TableColumn("cim");
            TableColumn szinkron = new TableColumn("szinkron");
            TableColumn szines = new TableColumn("szines");

            tOlvas.getColumns().addAll(filmcim,szarmazas,mufaj,mozinev,cim,szinkron,szines);

            filmcim.setCellValueFactory(new PropertyValueFactory<>("filmcim"));
            szarmazas.setCellValueFactory(new PropertyValueFactory<>("szarmazas"));
            mufaj.setCellValueFactory(new PropertyValueFactory<>("mufaj"));
            mozinev.setCellValueFactory(new PropertyValueFactory<>("mozinev"));
            cim.setCellValueFactory(new PropertyValueFactory<>("cim"));
            szinkron.setCellValueFactory(new PropertyValueFactory<>("szinkron"));
            szines.setCellValueFactory(new PropertyValueFactory<>("szines"));

            for(int i = 0; i < filmek.size(); i++ )
            {
                tOlvas.getItems().add(filmek.get(i));
            }
        }
    }

    @FXML
    private void initialize()
    {
        Clear();
    }

    public void Olvasas(ActionEvent actionEvent) {

        Mutat("OlvasMenu");
        Tabla("");
    }

    public void Olvasas2(ActionEvent actionEvent) {
        Mutat("Olvas2Menu");
        Tabla("");
        cbOlvasas.getItems().add(null);
        cbOlvasas.getItems().addAll(database.Mufajok());
    }

    @FXML
    protected void Insert(ActionEvent actionEvent){
        Mutat("Insert");
    }
    public void Update(ActionEvent actionEvent) {
    }

    public void Delete(ActionEvent actionEvent) {
    }

    public void Rest1Get(ActionEvent actionEvent) {
    }

    public void Rest1Post(ActionEvent actionEvent) {
    }

    public void Rest1Delete(ActionEvent actionEvent) {
    }

    public void Rest1Update(ActionEvent actionEvent) {
    }

    public void Rest2Get(ActionEvent actionEvent) {
    }

    public void Rest2Post(ActionEvent actionEvent) {
    }

    public void Rest2Delete(ActionEvent actionEvent) {
    }

    public void Rest2Update(ActionEvent actionEvent) {
    }

    public void Parhuzamos(ActionEvent actionEvent) {
    }

    public void Stream(ActionEvent actionEvent) {
    }


    public void Filter(ActionEvent actionEvent) {
        //boolean helper = false;
        String le ="";
        if(!tfOlvas.getText().isEmpty())
        {

            le +=" and filmcim = '" + tfOlvas.getText()+"'";
            //helper = true;
        }
        if(cbOlvasas.getSelectionModel().getSelectedItem() != null)
        {
            le += " and film.mufaj = '" + cbOlvasas.getSelectionModel().getSelectedItem()+"'";
            }
        if(group.getSelectedToggle() != null)
        {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            le += " and film.szinkron = '" + toogleGroupValue + "'";
        }
        if(cbSzines.isSelected())
        {

            le+= " and film.szines = 0" ;

        }

        Tabla(le);
        Mutat("Olvas2Menu");
    }

    public void InsertToTable(ActionEvent actionEvent) {

        String filmcim = tfInsertFilmcim.getText();
        String mufaj = cbInsertMufaj.getSelectionModel().getSelectedItem().toString();
        String szinkron=cbInsertSzinkron.getSelectionModel().getSelectedItem().toString();
        String szines=cbInsertSzines.getSelectionModel().getSelectedItem().toString();
        String szarmazas=tfInsertSzarmazas.getText();
        int hossz=0;
        try {
           hossz= Integer.parseInt(tfInsertHossz.getText());
        }catch (NumberFormatException e) {
            hossz=0;
        }



        database.InsertFilm(filmcim,mufaj,szinkron,szines,szarmazas,hossz);
       // cbShowKateg.getItems().removeAll(cbShowKateg.getItems());
        Mutat("");
    }
    public void ShowUpdate(ActionEvent actionEvent) {
    }

    public void UpdateKateg(ActionEvent actionEvent) {
    }

    public void DeletePizza(ActionEvent actionEvent) {
    }

    public void Rest1PostDo(ActionEvent actionEvent) {
    }

    public void DoRest1Delete(ActionEvent actionEvent) {
    }

    public void DoRest1Update(ActionEvent actionEvent) {
    }

    public void Rest2PostDo(ActionEvent actionEvent) {
    }

    public void DoRest2Delete(ActionEvent actionEvent) {
    }

    public void DoAThing(ActionEvent actionEvent) {
    }

    public void FilterStream(ActionEvent actionEvent) {
    }
}