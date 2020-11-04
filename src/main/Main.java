package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.ges.Menu;
import main.ges.T4raya;
import main.juegos.Juego4raya;

import java.io.IOException;

public class Main extends Application {

    private static Parent menu;
    private static Parent t3raya;
    private static Parent t4raya;

    private static Stage stage;
    private static Scene sMenu;
    private static Scene s4;
    private static Scene s3;

    private static Juego4raya juego4raya = Juego4raya.getJuego4raya();;

    //private Menu menu;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        cargaPantallas();
        stage.setTitle("Menu  Variosjuegos");
        //si no definimos anchura ni altura se pondran los valores del .fxml
        //stage.setScene(new Scene(menu, anchura, altura));
        cargaMenu();
        //stage.setResizable(true);
        stage.show();
    }

    private void cargaPantallas() throws IOException {
        System.out.println("hola");
        menu = FXMLLoader.load(getClass().getResource("/view/menu.fxml"));
        t3raya = FXMLLoader.load(getClass().getResource("/view/t3raya.fxml"));
        t4raya = FXMLLoader.load(getClass().getResource("/view/t4raya.fxml"));
        sMenu = new Scene(menu);
        s3 = new Scene(t3raya);
        s4 = new Scene(t4raya);
    }

    public static void cargaMenu(){
        stage.setScene(sMenu);
        stage.setResizable(false);
    }

    public static void carga3raya(){
        stage.setScene(s3);
        stage.setResizable(false);
    }

    public static void carga4raya(){
        stage.setTitle("4 en raya");
        juego4raya.cargarJuego();

        stage.setScene(s4);
        stage.setResizable(false);
        stage.setResizable(true);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
