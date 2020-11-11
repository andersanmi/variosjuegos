package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;

import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    public ImageView juego3raya, juego4raya;
    public Button b4raya;
    public Button b3raya;
    public Label usuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // this.usuario.setText( 'recoger el nombre guardado para ponerlo en el label' + "!");
        b3raya.setGraphic(juego3raya);
        b4raya.setGraphic(juego4raya);
    }

    public void jugar3raya(ActionEvent actionEvent) { Main.carga3raya(); }
    public void jugar4raya(ActionEvent actionEvent) { Main.carga4raya(); }

}
