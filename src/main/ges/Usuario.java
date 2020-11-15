package main.ges;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Usuario {

    public AnchorPane ap;
    public TextField usuario;
    private Main main;

    /**
     * @param actionEvent
     * @throws IOException
     * Este metodo es ejecutado cuando el usuario introduce su nombre en el recuadro indicado para ello clicka
     * en el botón "OK" para continuar con la siguiente pantalla.
     * Llama al metodo cargaMenu() pasandole como parámetro el nombre del usuario y cierra la ventana actual.
     */
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