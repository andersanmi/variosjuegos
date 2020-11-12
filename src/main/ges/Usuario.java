package main.ges;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.Main;

public class Usuario {
    public TextField usuario;
    public void onClick(ActionEvent actionEvent){
        //System.out.println(usuario.getText());
        Main.setMenuUsername(usuario.getText());
        Main.cargaMenu();
    }
}
