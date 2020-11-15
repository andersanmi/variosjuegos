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

public class Main extends Application {

    private Menu menu;
    private T3raya t3raya;
    private T4raya t4raya;
    private Usuario usuario;

    private Parent pMenu;
    private Parent pT3raya;
    private Parent pT4raya;
    private Parent pUsuario;

    private Stage stage;

    private static Juego4raya juego4raya = Juego4raya.getJuego4raya();
    private static Juego3raya juego3raya = Juego3raya.getJuego3raya();

    /**
     * @param primaryStage
     * @throws Exception
     * Llama al método para cargar la pantalla inicial
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        cargaPantallaInicio();
        stage = primaryStage;
        stage.setTitle("VariosJuegos");
        stage.setScene(new Scene(pUsuario));
        stage.show();
    }

    /**
     * @throws IOException
     * Carga la pantalla inicial
     */
    private void cargaPantallaInicio() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/usuario.fxml"));
        pUsuario = (Parent) loader.load();
        usuario = loader.getController();
        usuario.setMain(this);
    }

    /**
     * @param username nombre del usuario
     * @throws IOException
     * Carga la pantalla del menú
     */
    public void cargaMenu(String username) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
        pMenu = (Parent) loader.load();
        menu = loader.getController();
        menu.setMain(this);
        menu.setUsername(username);

        stage = new Stage();
        stage.setScene(new Scene(pMenu));
        stage.setTitle("VariosJuegos");
        stage.show();
    }

    /**
     * @param username nombre del usuario
     * @throws IOException
     * Carga la pantalla del juego 3 en raya y carga el mismo juego
     */
    public void carga3raya(String username) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/t3raya.fxml"));
        pT3raya = (Parent) loader.load();
        t3raya = loader.getController();
        t3raya.setMain(this);
        t3raya.setUsername(username);

        juego3raya.cargarJuego();
        stage = new Stage();
        stage.setScene(new Scene(pT3raya));
        stage.setTitle("3 en raya");
        stage.show();
    }

    /**
     * @param username nombre del usuario
     * @throws IOException
     * Carga la pantalla del juego 4 en raya y carga el mismo juego
     */
    public void carga4raya(String username) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/t4raya.fxml"));
        pT4raya = (Parent) loader.load();
        t4raya = loader.getController();
        t4raya.setMain(this);
        t4raya.setUsername(username);

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
