package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class T4raya implements Initializable {
    //pruebas
    public Button bok;
    public Button cReturn;


    public Button b0,b01,b02,b03,b04,b05,b06,b07,b08;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    }

    public void cok(ActionEvent actionEvent) {
        System.out.println("ok4");
    }

    public void cReturn(ActionEvent actionEvent) {
        Main.cargaMenu();
    }

    public void clickB0() {}
    public void clickB1() {}
    public void clickB2() {}
    public void clickB3() {}
    public void clickB4() {}
    public void clickB5() {}
    public void clickB6() {}
    public void clickB7() {}
    public void clickB8() {}

    public void click2jugadores() {}
    public void clickIAfacil() {}
    public void clickIAdificil() {}
    public void clickReiniciar() {}




}
