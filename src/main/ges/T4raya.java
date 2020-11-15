package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.Main;
import main.juegos.raya4.Juego4raya;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class T4raya implements Initializable {
    public BorderPane bp;

    public Button b0,b1,b2,b3,b4,b5,b6,b7,b8;
    public ArrayList<Button> listaBotones = new ArrayList<>();

    public Circle k00,k01,k02,k03,k04,k05,k10,k11,k12,k13,k14,k15,k20,k21,k22,k23,k24,k25,k30,k31,k32,k33,k34,k35,k40,k41,k42,k43,k44,k45,k50,k51,k52,k53,k54,k55,k60,k61,k62,k63,k64,k65,k70,k71,k72,k73,k74,k75,k80,k81,k82,k83,k84,k85;
    public ArrayList<ArrayList<Circle>> matrizCirculos = new ArrayList<>();

    private ImageView imagenVacia=new ImageView();
    public ImageView flechaAzul,flechaRoja;

    public Label textModoJuego;

    public String jugadorActual = null;
    public String modoDeJuego ="2 jugadores";

    private Main main;

    private String username = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarJuego();
    }

    public void setMain(Main main) { this.main = main; }

    /**
     * @param name nombre del usuario
     * Establece el nombre del usuario actual.
     */
    public void setUsername(String name){ username = name; }

    /**
     * Carga el juego completo, cargando la matriz y la lista de botones, ye indicando el jugador actual.
     */
    public void cargarJuego(){
        cargaMatriz();
        cargaListaBotones();
        jugadorActual="azul";
        flechaAzul.setVisible(false);
        flechaRoja.setVisible(false);
        textModoJuego.setText(modoDeJuego);
    }

    /**
     * Carga la matriz del jeugo completa, añadiendo todos los circulos en ella.
     */
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

    /**
     * Carga toda la lista de botones añadiendolos a la lista de botones.
     */
    private void cargaListaBotones(){
        listaBotones.add(b0);
        listaBotones.add(b1);
        listaBotones.add(b2);
        listaBotones.add(b3);
        listaBotones.add(b4);
        listaBotones.add(b5);
        listaBotones.add(b6);
        listaBotones.add(b7);
        listaBotones.add(b8);
    }

    /**
     * Resetea el juego a zero, descoloreando los círculos y reiniciando la matriz.
     */
    public void resetearJuego(){
        for (ArrayList<Circle> fila:matrizCirculos){
            for (Circle circulo:fila){
                circulo.setFill(Color.WHITESMOKE);
            }
        }
        textModoJuego.setText(modoDeJuego);
        jugadorActual = "azul";
        Juego4raya.getJuego4raya().reiniciarJuego();
    }

    /**
     * Hace una pausa de tiempo
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
        Juego4raya.getJuego4raya().partidaSigue=false;
    }

    /**
     * Cambia el turno del jugador en el modo 2 jugadores.
     */
    private void cambiaJugador(){
        if(jugadorActual=="azul"){ jugadorActual="rojo"; }
        else if(jugadorActual=="rojo"){ jugadorActual="azul"; }
    }

    /**
     * Cambia el turno del jugador si la partida sigue activa.
     */
    public void cambiarTurno(){
        if (Juego4raya.getJuego4raya().partidaSigue){
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
    }

    /**
     * @param fila fila de la matriz
     * @param columna columna de la matriz
     * Colorea el circulo de la fila y matriz recibida como parámetro.
     */
    public void coloreaCirculo(int fila, int columna){
        Circle cir = matrizCirculos.get(columna).get(fila);
        if(jugadorActual=="rojo") cir.setFill(Color.RED);
        if(jugadorActual=="azul") cir.setFill(Color.BLUE);
    }

    /**
     * @param numeroBoton número del botón, referido a una columna de la matriz
     * Si la partida sigue activa y la columna no está llena, mete la ficha en la columna indicada y
     * colorea la el círculo.
     * Si hay 4 en raya o el panel está completo, termina la partida.
     */
    public void accionBoton(int numeroBoton){
        if(Juego4raya.getJuego4raya().partidaSigue){
            Juego4raya juego = Juego4raya.getJuego4raya();
            int fila = juego.meteFicha(numeroBoton,jugadorActual);
            if(fila!=-1){//es -1 cuando la fila esta completa
                coloreaCirculo(fila,numeroBoton);
                if(juego.hayRaya4(jugadorActual)) finPartida(jugadorActual);
                if(juego.todasLlenas()) finPartida("empate");
                cambiarTurno();
            }
        }
    }

    /**
     * @param actionEvent
     * Metodos para detectar el click del ratón en los botones
     */
    public void clickB0(ActionEvent actionEvent) {accionBoton(0);Exited(0); Entered(0);}
    public void clickB1(ActionEvent actionEvent) {accionBoton(1);Exited(1); Entered(1);}
    public void clickB2(ActionEvent actionEvent) {accionBoton(2);Exited(2); Entered(2);}
    public void clickB3(ActionEvent actionEvent) {accionBoton(3);Exited(3); Entered(3);}
    public void clickB4(ActionEvent actionEvent) {accionBoton(4);Exited(4); Entered(4);}
    public void clickB5(ActionEvent actionEvent) {accionBoton(5);Exited(5); Entered(5);}
    public void clickB6(ActionEvent actionEvent) {accionBoton(6);Exited(6); Entered(6);}
    public void clickB7(ActionEvent actionEvent) {accionBoton(7);Exited(7); Entered(7);}
    public void clickB8(ActionEvent actionEvent) {accionBoton(8);Exited(8); Entered(8);}

    /**
     * @param mouseEvent
     * Métodos para recibir el movimiento del ratón por encima de los botones
     */
    public void b0In(MouseEvent mouseEvent)   { Entered(0); }
    public void b0Exit(MouseEvent mouseEvent) { Exited(0); }
    public void b1In(MouseEvent mouseEvent)   { Entered(1); }
    public void b1Exit(MouseEvent mouseEvent) { Exited(1); }
    public void b2In(MouseEvent mouseEvent)   { Entered(2); }
    public void b2Exit(MouseEvent mouseEvent) { Exited(2); }
    public void b3In(MouseEvent mouseEvent)   { Entered(3); }
    public void b3Exit(MouseEvent mouseEvent) { Exited(3); }
    public void b4In(MouseEvent mouseEvent)   { Entered(4); }
    public void b4Exit(MouseEvent mouseEvent) { Exited(4); }
    public void b5In(MouseEvent mouseEvent)   { Entered(5); }
    public void b5Exit(MouseEvent mouseEvent) { Exited(5); }
    public void b6In(MouseEvent mouseEvent)   { Entered(6); }
    public void b6Exit(MouseEvent mouseEvent) { Exited(6); }
    public void b7In(MouseEvent mouseEvent)   { Entered(7); }
    public void b7Exit(MouseEvent mouseEvent) { Exited(7); }
    public void b8In(MouseEvent mouseEvent)   { Entered(8); }
    public void b8Exit(MouseEvent mouseEvent) { Exited(8); }


    /**
     * @param bId id de la columna
     * Visualiza la flecha del botón que haga referencia la columna recibida como parámetro.
     * Esto lo hará únicamente cuando al partida este activa y no se haya terminado.
     */
    public void Entered(int bId){
        if (Juego4raya.getJuego4raya().partidaSigue){
            Button boton = listaBotones.get(bId);
            if (jugadorActual == "rojo") {
                flechaRoja.setVisible(true);
                boton.setGraphic(flechaRoja);
            }else{
                flechaAzul.setVisible(true);
                boton.setGraphic(flechaAzul);
            }
        }
    }

    /**
     * @param bId id de la columna
     * Dejará de visualizar la flecha en el botón que haga referencia el id de la columna recibida como
     * paámetro.
     */
    public void Exited(int bId){
        Button boton = listaBotones.get(bId);
        boton.setGraphic(imagenVacia);
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
     * Cambia el modo de juego a modo IA difícil.
     */
    public void clickIAdificil() {cambioModoDeJuego("IA dificil");}

    /**
     * Resetea el juego.
     */
    public void clickReiniciar() { resetearJuego(); }

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
