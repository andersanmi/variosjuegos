package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;

import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    public BorderPane bp;
    public Label usuario;
    public ImageView juego3raya, juego4raya;
    public Button b4raya;
    public Button b3raya;

    private static Menu instantzia = new Menu();
    public static Menu getInstantzia(){
        return instantzia;
    }

    private Main main;
    private String username = null;

    /**
     * @param url
     * @param resourceBundle
     * Establece los iconos de los juegos en la interfaz
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        b3raya.setGraphic(juego3raya);
        b4raya.setGraphic(juego4raya);
    }

    /**
     * @param name nombre del usuario
     * Establece el nombre de usuario y el label con el parámetro recibido
     */
    public void setUsername(String name){
        usuario.setText(name + "!");
        username = name;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * @param actionEvent
     * @throws IOException
     * Llama al método de la clase main para cargar el juego 3 en raya y cierro la ventana actual
     */
    public void jugar3raya(ActionEvent actionEvent) throws IOException {
        main.carga3raya(username);
        Stage stage = (Stage) bp.getScene().getWindow();
        stage.close();
    }

    /**
     * @param actionEvent
     * @throws IOException
     * Llama al método de la clase main para cargar el juego 4 en raya y cierro la ventana actual
     */
    public void jugar4raya(ActionEvent actionEvent) throws IOException {
        main.carga4raya(username);
        Stage stage = (Stage) bp.getScene().getWindow();
        stage.close();
    }

}
