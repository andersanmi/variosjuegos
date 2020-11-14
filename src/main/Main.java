package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.ges.Menu;
import main.ges.T3raya;
import main.ges.T4raya;
import main.ges.Usuario;
import main.juegos.raya3.Juego3raya;
import main.juegos.raya4.Juego4raya;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main extends Application {

    private Menu menu;
    private T3raya t3raya;
    private T4raya t4raya;
    private Usuario usuario;

    private Parent pMenu;
    private Parent pT3raya;
    private Parent pT4raya;
    private Parent pUsuario;
    private String username;

    private Stage stage;


    private static Juego4raya juego4raya = Juego4raya.getJuego4raya();
    private static Juego3raya juego3raya = Juego3raya.getJuego3raya();


    @Override
    public void start(Stage primaryStage) throws Exception{
        /*stage = primaryStage;
        cargaPantallas();
        stage.setTitle("Menu  Variosjuegos");
        //si no definimos anchura ni altura se pondran los valores del .fxml
        //stage.setScene(new Scene(menu, anchura, altura));
        cargaUsuario();

        //stage.setResizable(true);
        stage.show();*/
        cargaPantallas();
        stage = primaryStage;
        stage.setTitle("Menu usuario");
        stage.setScene(new Scene(pUsuario));
        stage.show();

    }

    private void cargaPantallas() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/usuario.fxml"));
        pUsuario = (Parent) loader.load();
        usuario = loader.getController();
        usuario.setMain(this);
    }

    public void cargaUsuario(){
        stage.setScene(new Scene(pUsuario));
        stage.setResizable(false);
    }

    public void cargaMenu(String username) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
        pMenu = (Parent) loader.load();
        menu = loader.getController();
        /*Properties prop = new Properties();
        InputStream is = Main.class.getClassLoader().getResourceAsStream("setup.properties");
        prop.load(is);
        menu.setUsername(prop.getProperty("username"));*/

        menu.setUsername(username);
        menu.setMain(this);

        stage = new Stage();
        stage.setScene(new Scene(pMenu));
        stage.show();
    }

    public void carga3raya() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/t3raya.fxml"));
        pT3raya = (Parent) loader.load();
        t3raya = loader.getController();
        t4raya.setMain(this);

        juego3raya.cargarJuego();
        stage = new Stage();
        stage.setScene(new Scene(pT3raya));
        stage.setTitle("3 en raya");
        stage.show();
    }

    public void carga4raya() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/t4raya.fxml"));
        pT4raya = (Parent) loader.load();
        t4raya = loader.getController();
        t4raya.setMain(this);
        juego4raya.cargarJuego();
        stage = new Stage();
        stage.setScene(new Scene(pT4raya));
        stage.setTitle("4 en raya");
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
