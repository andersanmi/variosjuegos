package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class T4raya implements Initializable {
    public Button bok;
    public Button cReturn;


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

    public void clickMenuBiJok() {}
    public void clickMenuJOErraza() {}
    public void clickMenuJOZaila() {}
    public void clickReiniciar() {}


}
