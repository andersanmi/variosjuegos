package main.ges;


import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Usuario {

    public AnchorPane ap;

    public TextField usuario;
    private Main main;

    public void onClick(ActionEvent actionEvent) throws IOException {
        main = new Main();
        main.cargaMenu(usuario.getText());
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.close();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}