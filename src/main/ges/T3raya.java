package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import main.juegos.raya3.Juego3raya;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class T3raya implements Initializable {

    public BorderPane bp;

    public Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    public ArrayList<ArrayList<Button>> matrizBotones = new ArrayList<>();

    private ImageView imagenVacia=new ImageView();
    public ImageView equis, circulo, circulo00, circulo01, circulo02, circulo10, circulo11, circulo12, circulo20, circulo21, circulo22, equis00, equis01, equis02, equis10, equis11, equis12, equis20, equis21, equis22;
    public ArrayList<ArrayList<ImageView>> matrizCirculos = new ArrayList<>();
    public ArrayList<ArrayList<ImageView>> matrizEquises = new ArrayList<>();

    public Label textModoJuego;

    public String jugadorActual = null;
    public String modoDeJuego ="2 jugadores";

    private Main main;

    private String username = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarJuego();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * @param name nombre del usuario
     * Establece el nombre del usuario actual.
     */
    public void setUsername(String name){ username = name; }

    /**
     * Carga el juego completo, cargando la matriz e indicando el jugador actual.
     */
    public void cargarJuego(){
        cargaMatrices();
        jugadorActual="azul";
        equis.setVisible(false);
        circulo.setVisible(false);
        textModoJuego.setText(modoDeJuego);
    }

    /**
     * Carga la matriz del jeugo completa, añadiendo todos los circulos y las equises en ella.
     */
    private void cargaMatrices() {
        ArrayList<Button> fila0 = new ArrayList<>();
        fila0.add(b00);
        fila0.add(b01);
        fila0.add(b02);
        ArrayList<Button> fila1 = new ArrayList<>();
        fila1.add(b10);
        fila1.add(b11);
        fila1.add(b12);
        ArrayList<Button> fila2 = new ArrayList<>();
        fila2.add(b20);
        fila2.add(b21);
        fila2.add(b22);
        matrizBotones.add(fila0);
        matrizBotones.add(fila1);
        matrizBotones.add(fila2);

        ArrayList<ImageView> c0 = new ArrayList<>();
        c0.add(circulo00);
        c0.add(circulo01);
        c0.add(circulo02);
        ArrayList<ImageView> c1 = new ArrayList<>();
        c1.add(circulo10);
        c1.add(circulo11);
        c1.add(circulo12);
        ArrayList<ImageView> c2 = new ArrayList<>();
        c2.add(circulo20);
        c2.add(circulo21);
        c2.add(circulo22);
        matrizCirculos.add(c0);
        matrizCirculos.add(c1);
        matrizCirculos.add(c2);

        ArrayList<ImageView> e0 = new ArrayList<>();
        e0.add(equis00);
        e0.add(equis01);
        e0.add(equis02);
        ArrayList<ImageView> e1 = new ArrayList<>();
        e1.add(equis10);
        e1.add(equis11);
        e1.add(equis12);
        ArrayList<ImageView> e2 = new ArrayList<>();
        e2.add(equis20);
        e2.add(equis21);
        e2.add(equis22);
        matrizEquises.add(e0);
        matrizEquises.add(e1);
        matrizEquises.add(e2);

    }

    /**
     * Resetea el juego a zero, descoloreando los círculos y las equises.
     */
    public void resetearJuego(){
        textModoJuego.setText(modoDeJuego);
        for (ArrayList<ImageView> fila:matrizCirculos){
            for (ImageView img:fila){
                img.setVisible(false);
            }
        }
        for (ArrayList<ImageView> fila:matrizEquises){
            for (ImageView img:fila){
                img.setVisible(false);
            }
        }
        jugadorActual = "azul";
        Juego3raya.getJuego3raya().reiniciarJuego();
    }

    /**
     * Hace una pausa del juego
     */
    private void delay(){
        try { TimeUnit.MILLISECONDS.sleep(200); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    /**
     * @param ganador ganador de la partida
     * Termina con la partida y dictamina el ganador si lo hubiera, si no sería empate.
     */
    private void finPartida(String ganador){
        if(ganador=="empate") textModoJuego.setText("Empate");
        else textModoJuego.setText("Ha ganado el jugador "+ganador);

        Juego3raya.getJuego3raya().partidaSigue=false;
    }

    /**
     * Cambia el turno del jugador en el modo 2 jugadores.
     */
    private void cambiaJugador(){
        if(jugadorActual.equals("azul")){ jugadorActual="rojo"; }
        else if(jugadorActual.equals("rojo")){ jugadorActual="azul"; }
    }

    /**
     * Cambia el turno del jugador si la partida sigue activa.
     */
    public void cambiarTurno(){
        if (Juego3raya.getJuego3raya().partidaSigue){
            if(modoDeJuego.equals("2 jugadores")){
                cambiaJugador();
            }
            if(modoDeJuego.equals("IA facil")){
                delay();
                cambiaJugador();
                int[] pos = Juego3raya.getJuego3raya().iaFacil();
                marcarCuadrado(pos[0],pos[1]);
                cambiaJugador();
            }
        }
    }

    /**
     * @param fila fila de la matriz
     * @param columna columna de la matriz
     * Si la partida sigue activa y la posición no está llena, mete la ficha en la fila y columna indicada y
     * marca el cuadrado.
     * Si hay 3 en raya o el panel está completo, termina la partida.
     */
    public void accionBoton(int fila, int columna){
        if(Juego3raya.getJuego3raya().partidaSigue){
            Juego3raya juego = Juego3raya.getJuego3raya();
            if(juego.marcar(fila, columna ,jugadorActual)){
                marcarCuadrado(fila, columna);
                if(juego.hayRaya3(jugadorActual)) finPartida(jugadorActual);
                if(juego.todasLlenas()) finPartida("empate");
                cambiarTurno();
            }
        }
    }

    /**
     * @param fila fila de la matriz
     * @param columna columna de la matriz
     * Marca la posición referida a la fila y columna recibidas como parámetro con un círculo o con una equis,
     * dependiendo del jugador actual.
     */
    public void marcarCuadrado(int fila, int columna){
        ImageView circulo = matrizCirculos.get(fila).get(columna);
        ImageView equis = matrizEquises.get(fila).get(columna);
        if(jugadorActual.equals("rojo")) circulo.setVisible(true);
        if(jugadorActual.equals("azul")) equis.setVisible(true);
    }

    public void click00(ActionEvent actionEvent) {accionBoton(0, 0);}
    public void click01(ActionEvent actionEvent) {accionBoton(0, 1);}
    public void click02(ActionEvent actionEvent) {accionBoton(0, 2);}
    public void click10(ActionEvent actionEvent) {accionBoton(1, 0);}
    public void click11(ActionEvent actionEvent) {accionBoton(1, 1);}
    public void click12(ActionEvent actionEvent) {accionBoton(1, 2);}
    public void click20(ActionEvent actionEvent) {accionBoton(2, 0);}
    public void click21(ActionEvent actionEvent) {accionBoton(2, 1);}
    public void click22(ActionEvent actionEvent) {accionBoton(2, 2);}

    public void b00In(MouseEvent mouseEvent)   { Entered(0, 0); }
    public void b00Exit(MouseEvent mouseEvent) { Exited(0, 0); }
    public void b01In(MouseEvent mouseEvent)   { Entered(0, 1); }
    public void b01Exit(MouseEvent mouseEvent) { Exited(0, 1); }
    public void b02In(MouseEvent mouseEvent)   { Entered(0, 2); }
    public void b02Exit(MouseEvent mouseEvent) { Exited(0, 2); }
    public void b10In(MouseEvent mouseEvent)   { Entered(1, 0); }
    public void b10Exit(MouseEvent mouseEvent) { Exited(1, 0); }
    public void b11In(MouseEvent mouseEvent)   { Entered(1, 1); }
    public void b11Exit(MouseEvent mouseEvent) { Exited(1, 1); }
    public void b12In(MouseEvent mouseEvent)   { Entered(1, 2); }
    public void b12Exit(MouseEvent mouseEvent) { Exited(1, 2); }
    public void b20In(MouseEvent mouseEvent)   { Entered(2, 0); }
    public void b20Exit(MouseEvent mouseEvent) { Exited(2, 0); }
    public void b21In(MouseEvent mouseEvent)   { Entered(2, 1); }
    public void b21Exit(MouseEvent mouseEvent) { Exited(2, 1); }
    public void b22In(MouseEvent mouseEvent)   { Entered(2, 2); }
    public void b22Exit(MouseEvent mouseEvent) { Exited(2, 2); }

    /**
     * @param fila fila de la matriz
     * @param columna columna de la matriz
     * Visualiza el círculo o equis, dependiendo del jugador actual, del botón que haga referencia la fila y
     * columna recibida como parámetro.
     * Esto lo hará únicamente cuando al partida este activa y no se haya terminado.
     */
    public void Entered(int fila, int columna){
        if (Juego3raya.getJuego3raya().partidaSigue){
            Button b = matrizBotones.get(fila).get(columna);
            if (jugadorActual.equals("rojo")) {
                circulo.setVisible(true);
                b.setGraphic(circulo);
            }else{
                equis.setVisible(true);
                b.setGraphic(equis);
            }
        }
    }

    /**
     * @param fila fila de la matriz
     * @param columna columna de la matriz
     * Dejará de visualizar el círculo o equis, dependiendo el jugador actual, en la posición que haga
     * referencia a la fila y columna recibida como paámetro.
     */
    public void Exited(int fila, int columna){
        Button b = matrizBotones.get(fila).get(columna);
        b.setGraphic(imagenVacia);
    }

    /**
     * @param modo modo de juego
     * Cambia el modo de juego al indicado por el parámetro recibido y resetea el juego
     * El modo de juego lo indicara el usuario en la interfaz.
     */
    private void cambioModoDeJuego(String modo){
        modoDeJuego=modo;
        textModoJuego.setText(modo);
        resetearJuego();
    }

    /**
     * Cambia el modo de juego a modo 2 jugadores.
     */
    public void click2jugadores() { cambioModoDeJuego("2 jugadores"); }

    /**
     * Cambia el modo de juego a modo IA fácil.
     */
    public void clickIAfacil() {cambioModoDeJuego("IA facil"); }

    /**
     * Resetea el juego.
     */
    public void clickReiniciar() {
        resetearJuego();
    }

    /**
     * @throws IOException
     * Resetea el juego y vuelve a la pantalla del menú, cerrando la ventana actual.
     */
    public void clickMenu() throws IOException {
        resetearJuego();
        main.cargaMenu(username);
        Stage stage = (Stage) bp.getScene().getWindow();
        stage.close();
    }

}
