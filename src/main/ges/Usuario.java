package main.ges;

import main.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


public class Usuario {
    public TextField usuario;

    public void onClick(ActionEvent actionEvent){
        System.out.println(usuario.getText());
        // Guardar el nombre para que aparezca en el label dle menu
        Main.cargaMenu();
    }
}
