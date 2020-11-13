package main.ges;

import main.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


public class Usuario {
    public TextField usuario;

    public void onClick(ActionEvent actionEvent){
        //System.out.println(usuario.getText());
        Main.setMenuUsername(usuario.getText());
        Main.cargaMenu();
    }
}
