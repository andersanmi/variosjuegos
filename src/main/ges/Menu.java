package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    public Button bok;
    public Button raya4;
    public Button raya3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }
    public void okclick(ActionEvent actionEvent) {
        System.out.println("ok");
    }

    public void click4(ActionEvent actionEvent) {
        Main.carga4raya();
    }
    public void click3(ActionEvent actionEvent) {
        Main.carga3raya();
    }
}
