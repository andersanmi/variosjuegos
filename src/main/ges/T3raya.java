package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import main.Main;
import main.juegos.raya3.Juego3raya;
import main.juegos.raya4.Juego4raya;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class T3raya implements Initializable {
    //pruebas
    public Button bok;
    public Button cReturn;

    public Rectangle k00,k01,k02,k10,k11,k12,k20,k21,k22;
    public ArrayList<ArrayList<Rectangle>> matrizCuadrados = new ArrayList<>();

    public ImageView equis, circulo;
    private ImageView imagenVacia=new ImageView();

   // private Image imgEquis = new Image("@../images/equis.png");
   // private Image imgCirculo = new Image("/resources/images/circulo.png");

    public Pane root = new Pane();

    public StackPane imageContainer = new StackPane();



    public Label textModoJuego;

    //valores estandar del juego
    //los null hay que definirlos en el momento de carga de juego
    public String jugadorActual = null;
    public String modoDeJuego ="2 jugadores";





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarJuego();
    }

    public void cok(ActionEvent actionEvent) {
        System.out.println("ok4");
    }

    public void cReturn(ActionEvent actionEvent) {
        Main.cargaMenu();
    }

    public void cargarJuego(){
        //estructura datos
        cargaMatriz();
        jugadorActual="azul";
        equis.setVisible(false);
        circulo.setVisible(false);
        //cambios interfaz
        textModoJuego.setText(modoDeJuego);

    }

    private void cargaMatriz() {
        ArrayList<Rectangle> fila0 = new ArrayList<>();
        fila0.add(k00);
        fila0.add(k01);
        fila0.add(k02);
        ArrayList<Rectangle> fila1 = new ArrayList<>();
        fila1.add(k10);
        fila1.add(k11);
        fila1.add(k12);
        ArrayList<Rectangle> fila2 = new ArrayList<>();
        fila2.add(k20);
        fila2.add(k21);
        fila2.add(k22);
        matrizCuadrados.add(fila0);
        matrizCuadrados.add(fila1);
        matrizCuadrados.add(fila2);
    }

    public void resetearJuego(){
        for (ArrayList<Rectangle> fila:matrizCuadrados){
            for (Rectangle cuadrado:fila){
                cuadrado.setFill(Color.WHITESMOKE);
            }
        }
        Juego4raya.getJuego4raya().reiniciarJuego();
    }
    private void delay(){
        try { TimeUnit.MILLISECONDS.sleep(200); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    private void cambiaJugador(){
        //antes de hacer un cambio de jugador mirar si este ha ganado la partida
        //o si la partida esta completada, tablero lleno
        if(jugadorActual=="azul"){ jugadorActual="rojo"; }
        else if(jugadorActual=="rojo"){ jugadorActual="azul"; }
    }
    public void cambiarTurno(){
        if(modoDeJuego=="2 jugadores"){
            cambiaJugador();
        }
        if(modoDeJuego=="IA facil"){
            delay();
            cambiaJugador();
            //int pos = Juego3raya.getJuego3raya().iaFacil();
            //int fila = Juego3raya.getJuego3raya().meteFicha(pos,jugadorActual);
            //if(fila!=-1) { coloreaCirculo(fila, pos); }
            cambiaJugador();
        }
        if(modoDeJuego=="IA dificil"){
            delay();
            cambiaJugador();
            //int pos = Juego3raya.getJuego3raya().iaDificil();
            //int fila = Juego3raya.getJuego3raya().meteFicha(pos,jugadorActual);
            //if(fila!=-1) { coloreaCirculo(fila, pos); }
            cambiaJugador();
        }
    }
    public void accionBoton(int fila, int columna){
        Juego3raya.getJuego3raya().meteFicha(fila, columna ,jugadorActual);
        marcarCuadrado(fila, columna);
        cambiarTurno();
        Juego3raya.getJuego3raya().printMatrix();
    }

    public void marcarCuadrado(int fila, int columna){
        Rectangle cir = matrizCuadrados.get(columna).get(fila);
        if(jugadorActual=="rojo") cir.setFill(Color.RED);
        if(jugadorActual=="azul") cir.setFill(Color.BLUE);
    }

    public void click00(ActionEvent actionEvent) {accionBoton(0, 0); }
    public void click01(ActionEvent actionEvent) {accionBoton(0, 1);}
    public void click02(ActionEvent actionEvent) {accionBoton(0, 2);}
    public void click10(ActionEvent actionEvent) {accionBoton(1, 0);}
    public void click11(ActionEvent actionEvent) {accionBoton(1, 1);}
    public void click12(ActionEvent actionEvent) {accionBoton(1, 2);}
    public void click20(ActionEvent actionEvent) {accionBoton(2, 0);}
    public void click21(ActionEvent actionEvent) {accionBoton(2, 1);}
    public void click22(ActionEvent actionEvent) {accionBoton(2, 2);}

    //para animacion de flechas
    public void k00In(MouseEvent mouseEvent)   { Entered(0, 0); }
    public void k00Exit(MouseEvent mouseEvent) { Exited(0, 0); }
    public void k01In(MouseEvent mouseEvent)   { Entered(0, 1); }
    public void k01Exit(MouseEvent mouseEvent) { Exited(0, 1); }
    public void k02In(MouseEvent mouseEvent)   { Entered(0, 2); }
    public void k02Exit(MouseEvent mouseEvent) { Exited(0, 2); }
    public void k10In(MouseEvent mouseEvent)   { Entered(1, 0); }
    public void k10Exit(MouseEvent mouseEvent) { Exited(1, 0); }
    public void k11In(MouseEvent mouseEvent)   { Entered(1, 1); }
    public void k11Exit(MouseEvent mouseEvent) { Exited(1, 1); }
    public void k12In(MouseEvent mouseEvent)   { Entered(1, 2); }
    public void k12Exit(MouseEvent mouseEvent) { Exited(1, 2); }
    public void k20In(MouseEvent mouseEvent)   { Entered(2, 0); }
    public void k20Exit(MouseEvent mouseEvent) { Exited(2, 0); }
    public void k21In(MouseEvent mouseEvent)   { Entered(2, 1); }
    public void k21Exit(MouseEvent mouseEvent) { Exited(2, 1); }
    public void k22In(MouseEvent mouseEvent)   { Entered(2, 2); }
    public void k22Exit(MouseEvent mouseEvent) { Exited(2, 2); }

    public void Entered(int fila, int columnna){
        Rectangle k = matrizCuadrados.get(fila).get(columnna);
        if (jugadorActual == "rojo") {
            //k.setFill(new ImagePattern(imgCirculo));
            imageContainer.getChildren().addAll(k, equis);


            root.getChildren().add(imageContainer);

        }else{
           // k.setFill(new ImagePattern(imgEquis));
        }
        //actualButton=botoia;
    }

    public void Exited(int fila, int columnna){
        Rectangle k = matrizCuadrados.get(fila).get(columnna);
        //k.setFill(null);
        //actualButton=null;
    }



    //menu
    private void cambioModoDeJuego(String modo){
        modoDeJuego=modo;
        textModoJuego.setText(modo);
        resetearJuego();
    }
    public void click2jugadores() { cambioModoDeJuego("2 jugadores"); }
    public void clickIAfacil() {cambioModoDeJuego("IA facil"); }
    public void clickIAdificil() {cambioModoDeJuego("IA dificil");}
    public void clickReiniciar() {
        resetearJuego();
    }


}
