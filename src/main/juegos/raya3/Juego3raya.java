package main.juegos.raya3;

import java.util.ArrayList;

public class Juego3raya {
    private static boolean[][] ocupados,ocRojos,ocAzul;

    private static final Juego3raya miJuego3raya = new Juego3raya();
    public static Juego3raya getJuego3raya(){
        return miJuego3raya;
    }

    public void cargarJuego(){
        ocupados = new boolean[3][3];
        ocRojos = new boolean[3][3];
        ocAzul = new boolean[3][3];
    }
    public void reiniciarJuego(){
        ocupados = new boolean[3][3];
        ocRojos = new boolean[3][3];
        ocAzul = new boolean[3][3];

    }

    public static boolean marcar(int fila, int columna,String color){
        if (!ocupados[fila][columna]){
            ocupados[fila][columna]=true;
            if(color.equals("rojo")) ocRojos[fila][columna]=true;
            if(color.equals("azul")) ocAzul[fila][columna]=true;
            return true;
        } else{
            System.out.println("La casilla ya está marcada!");
            return false;
        }
    }
    public static void edit(int fila, int columna){
        ocupados[fila][columna] = true;
    }

    public static boolean[][] getOcupados() {
        return ocupados;
    }

    public static boolean[][] getOcAzul() {
        return ocAzul;
    }

    public static boolean[][] getOcRojos() {
        return ocRojos;
    }


    public static boolean hay3raya(){
        return false;
    }

    public int[] iaFacil(){
        IAFacil ia = new IAFacil(ocupados);
        int[] pos = ia.setPos();
        ocupados[pos[0]][pos[1]]=true;
        return pos;
    }

    public boolean posOcupada(int fila, int columna){
        return ocupados[fila][columna];
    }

    public boolean estaLleno(){
        boolean lleno = true;
        for (int fila=0; fila<3; fila++){
            for (int columna=0; columna<3; columna++){
                if (!ocupados[fila][columna]){
                    lleno = false;
                    break;
                }
            }
        }
        return lleno;
    }


    //metodos para pruebas
    public static void printMatrix(){
        printMatrixSel(ocupados);
        /*
        System.out.println("azul");
        printMatrixSel(ocAzul);
        System.out.println("rojo");
        printMatrixSel(ocRojos);
        */
    }

    public static void printMatrixSel(boolean[][] mat){
        System.out.println("============");
        for (boolean [] y:mat) {
            System.out.println();
            for (boolean x:y) {
                String val="";
                if(x) {val="T ";}
                if(!x) {val="F ";}
                System.out.print(val);
            }
        }
        System.out.println();
        System.out.println("============");
    }
}
