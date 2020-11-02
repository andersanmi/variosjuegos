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
}
