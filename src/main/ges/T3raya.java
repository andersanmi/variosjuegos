package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import main.Main;
import main.juegos.raya3.Juego3raya;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class T3raya implements Initializable {
    //pruebas
    public Button bok;
    public Button cReturn;

    public Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    public ArrayList<ArrayList<Button>> matrizBotones = new ArrayList<>();

    public ImageView equis, circulo, circulo00, circulo01, circulo02, circulo10, circulo11, circulo12, circulo20, circulo21, circulo22, equis00, equis01, equis02, equis10, equis11, equis12, equis20, equis21, equis22;
    public ArrayList<ArrayList<ImageView>> matrizCirculos = new ArrayList<>();
    public ArrayList<ArrayList<ImageView>> matrizEquises = new ArrayList<>();
    private ImageView imagenVacia=new ImageView();

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
        cargaMatrices();
        jugadorActual="azul";
        equis.setVisible(false);
        circulo.setVisible(false);
        //cambios interfaz
        textModoJuego.setText(modoDeJuego);

    }

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

    public void resetearJuego(){
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


    private void delay(){
        try { TimeUnit.MILLISECONDS.sleep(200); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    private void cambiaJugador(){
        //antes de hacer un cambio de jugador mirar si este ha ganado la partida
        //o si la partida esta completada, tablero lleno
        if(jugadorActual.equals("azul")){ jugadorActual="rojo"; }
        else if(jugadorActual.equals("rojo")){ jugadorActual="azul"; }
    }
    public void cambiarTurno(){
        if (!Juego3raya.getJuego3raya().estaLleno()){
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
            if(modoDeJuego.equals("IA dificil")){
                delay();
                cambiaJugador();
                //int pos = Juego3raya.getJuego3raya().iaDificil();
                //int fila = Juego3raya.getJuego3raya().meteFicha(pos,jugadorActual);
                //if(fila!=-1) { coloreaCirculo(fila, pos); }
                cambiaJugador();
            }
        }
    }
    public void accionBoton(int fila, int columna){
        if(Juego3raya.getJuego3raya().marcar(fila, columna ,jugadorActual)){
            marcarCuadrado(fila, columna);
            cambiarTurno();
        }
        Juego3raya.getJuego3raya().printMatrix();
    }

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

    //para animacion de flechas
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

    public void Entered(int fila, int columna){
        if (!Juego3raya.getJuego3raya().estaLleno()){
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

    public void Exited(int fila, int columna){
        Button b = matrizBotones.get(fila).get(columna);
        b.setGraphic(imagenVacia);
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
    public void clickMenu() { Main.cargaMenu(); }


}
