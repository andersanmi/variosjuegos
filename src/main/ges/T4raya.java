package main.ges;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import main.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class T4raya implements Initializable {
    //pruebas
    public Button bok;
    public Button cReturn;


    public Button b0,b1,b2,b3,b4,b5,b6,b7,b8;

    public Circle k00,k01,k02,k03,k04,k05,k10,k11,k12,k13,k14,k15,k20,k21,k22,k23,k24,k25,k30,k31,k32,k33,k34,k35,k40,k41,k42,k43,k44,k45,k50,k51,k52,k53,k54,k55,k60,k61,k62,k63,k64,k65,k70,k71,k72,k73,k74,k75,k80,k81,k82,k83,k84,k85;
    public ArrayList<Circle> matrizCirculos;

    private static boolean[][] ocupados,ocRojos,ocAzul;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    }

    public void cok(ActionEvent actionEvent) {
        System.out.println("ok4");
    }

    public void cReturn(ActionEvent actionEvent) {
        Main.cargaMenu();
    }

    public void cargarJuego(){
        //tableroak hasieratu
        ocupados = new boolean[9][6]; ocRojos = new boolean[9][6]; ocAzul = new boolean[9][6];

    }

    public void clickB0(ActionEvent actionEvent) {if(!columnaCompleta(0)) { meteFicha(0); }}
    public void clickB1() {}
    public void clickB2() {}
    public void clickB3() {}
    public void clickB4() {}
    public void clickB5() {}
    public void clickB6() {}
    public void clickB7() {}
    public void clickB8() {}

    public Boolean columnaCompleta(int colum){
        return ocupados[0][colum];
    }
    public void meteFicha(int col){

    }

    //menu
    public void click2jugadores() {}
    public void clickIAfacil() {}
    public void clickIAdificil() {}
    public void clickReiniciar() {}




}
