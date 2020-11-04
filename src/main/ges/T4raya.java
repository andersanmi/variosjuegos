package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import main.Main;
import main.juegos.raya4.Juego4raya;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class T4raya implements Initializable {
    //pruebas
    public Button bok;
    public Button cReturn;


    public Button b0,b1,b2,b3,b4,b5,b6,b7,b8;

    public Circle k00,k01,k02,k03,k04,k05,k10,k11,k12,k13,k14,k15,k20,k21,k22,k23,k24,k25,k30,k31,k32,k33,k34,k35,k40,k41,k42,k43,k44,k45,k50,k51,k52,k53,k54,k55,k60,k61,k62,k63,k64,k65,k70,k71,k72,k73,k74,k75,k80,k81,k82,k83,k84,k85;
    public ArrayList<ArrayList<Circle>> matrizCirculos = new ArrayList<>();

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
        //cambios interfaz
        textModoJuego.setText(modoDeJuego);

    }
    public void resetearJuego(){
        for (ArrayList<Circle> fila:matrizCirculos){
            for (Circle circulo:fila){
                circulo.setFill(Color.WHITESMOKE);
            }
        }
        Juego4raya.getJuego4raya().reiniciarJuego();
    }
    private void delay(){
        try { TimeUnit.MILLISECONDS.sleep(200); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
    private void cambiaJugador(){
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
            int pos = Juego4raya.getJuego4raya().iaFacil();
            int fila = Juego4raya.getJuego4raya().meteFicha(pos,jugadorActual);
            if(fila!=-1) { coloreaCirculo(fila, pos); }
            cambiaJugador();
        }
        if(modoDeJuego=="IA dificil"){
            delay();
            cambiaJugador();
            int pos = Juego4raya.getJuego4raya().iaDificil();
            int fila = Juego4raya.getJuego4raya().meteFicha(pos,jugadorActual);
            if(fila!=-1) { coloreaCirculo(fila, pos); }
            cambiaJugador();
        }
    }

    public void coloreaCirculo(int fila, int columna){
        Circle cir = matrizCirculos.get(columna).get(fila);
        if(jugadorActual=="rojo") cir.setFill(Color.RED);
        if(jugadorActual=="azul") cir.setFill(Color.BLUE);
    }
    public void accionBoton(int numeroBoton){
        int fila = Juego4raya.getJuego4raya().meteFicha(numeroBoton,jugadorActual);
        if(fila!=-1){//es -1 cuando la fila esta completa
            coloreaCirculo(fila,numeroBoton);
            cambiarTurno();
        }
        Juego4raya.getJuego4raya().printMatrix();
    }

    public void clickB0(ActionEvent actionEvent) {accionBoton(0); }
    public void clickB1(ActionEvent actionEvent) {accionBoton(1);}
    public void clickB2(ActionEvent actionEvent) {accionBoton(2);}
    public void clickB3(ActionEvent actionEvent) {accionBoton(3);}
    public void clickB4(ActionEvent actionEvent) {accionBoton(4);}
    public void clickB5(ActionEvent actionEvent) {accionBoton(5);}
    public void clickB6(ActionEvent actionEvent) {accionBoton(6);}
    public void clickB7(ActionEvent actionEvent) {accionBoton(7);}
    public void clickB8(ActionEvent actionEvent) {accionBoton(8);}



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



    //metodos de carga o analisis pesados
    //metodos que son muy largos
    private void cargaMatriz(){
        ArrayList<Circle> fila0 = new ArrayList<>();
        fila0.add(k00);
        fila0.add(k01);
        fila0.add(k02);
        fila0.add(k03);
        fila0.add(k04);
        fila0.add(k05);
        ArrayList<Circle> fila1 = new ArrayList<>();
        fila1.add(k10);
        fila1.add(k11);
        fila1.add(k12);
        fila1.add(k13);
        fila1.add(k14);
        fila1.add(k15);
        ArrayList<Circle> fila2 = new ArrayList<>();
        fila2.add(k20);
        fila2.add(k21);
        fila2.add(k22);
        fila2.add(k23);
        fila2.add(k24);
        fila2.add(k25);
        ArrayList<Circle> fila3 = new ArrayList<>();
        fila3.add(k30);
        fila3.add(k31);
        fila3.add(k32);
        fila3.add(k33);
        fila3.add(k34);
        fila3.add(k35);
        ArrayList<Circle> fila4 = new ArrayList<>();
        fila4.add(k40);
        fila4.add(k41);
        fila4.add(k42);
        fila4.add(k43);
        fila4.add(k44);
        fila4.add(k45);
        ArrayList<Circle> fila5 = new ArrayList<>();
        fila5.add(k50);
        fila5.add(k51);
        fila5.add(k52);
        fila5.add(k53);
        fila5.add(k54);
        fila5.add(k55);
        ArrayList<Circle> fila6 = new ArrayList<>();
        fila6.add(k60);
        fila6.add(k61);
        fila6.add(k62);
        fila6.add(k63);
        fila6.add(k64);
        fila6.add(k65);
        ArrayList<Circle> fila7 = new ArrayList<>();
        fila7.add(k70);
        fila7.add(k71);
        fila7.add(k72);
        fila7.add(k73);
        fila7.add(k74);
        fila7.add(k75);
        ArrayList<Circle> fila8 = new ArrayList<>();
        fila8.add(k80);
        fila8.add(k81);
        fila8.add(k82);
        fila8.add(k83);
        fila8.add(k84);
        fila8.add(k85);

        matrizCirculos.add(fila0);
        matrizCirculos.add(fila1);
        matrizCirculos.add(fila2);
        matrizCirculos.add(fila3);
        matrizCirculos.add(fila4);
        matrizCirculos.add(fila5);
        matrizCirculos.add(fila6);
        matrizCirculos.add(fila7);
        matrizCirculos.add(fila8);
    }

}
