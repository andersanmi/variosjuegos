package main.juegos.raya4;

import java.util.ArrayList;

public class Juego4raya {
    private static boolean[][] ocupados,ocRojos,ocAzul;

    private static final Juego4raya miJuego4raya = new Juego4raya();
    public static Juego4raya getJuego4raya(){
        return miJuego4raya;
    }

    public void cargarJuego(){
        ocupados = new boolean[6][9];
        ocRojos = new boolean[6][9];
        ocAzul = new boolean[6][9];
    }
    public void reiniciarJuego(){
        ocupados = new boolean[6][9];
        ocRojos = new boolean[6][9];
        ocAzul = new boolean[6][9];
    }

    public static int meteFicha(int colum,String color){
        //color: azul, rojo

        int fila = -1;
        if(!ocupados[0][colum]){//hay hueco
            for (int i=0;i<6;i++){
                if(!ocupados[5-i][colum]){
                    fila = 5-i;
                    ocupados[fila][colum]=true;
                    break;
                }
            }
            if(color=="rojo") ocRojos[fila][colum]=true;
            if(color=="azul") ocAzul[fila][colum]=true;
            if(hayRaya4(color)){
                System.out.println(color+" ha ganado");
                return -1;
            }
        }
        else System.out.println("error columna llena");
        return fila;
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


    public static boolean hay4raya(){
        return false;
    }

    public int iaFacil(){
        IAFacil ia = new IAFacil();
        return ia.selCollum();
    }
    public int iaDificil(){
        IADificil ia = new IADificil(ocupados,ocRojos,ocAzul);
        return ia.selCollum();
    }

    public boolean estaLleno(){
        boolean lleno = true;
        for (int columna=0; columna<9; columna++){
            if (!ocupados[0][columna]){
                lleno = false;
                break;
            }
        }
        return lleno;
    }

    //metodos para pruebas
    public static void printMatrix(){
        /*
        printMatrixSel(ocupados);

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
    private static Boolean mirarFilas(boolean[][] matriz){
        for (int fila = 0; fila < matriz.length; fila++){
            int contPos=0;
            for (int columna = 0; columna < matriz[0].length; columna++){
                if(matriz[fila][columna]){
                    contPos++;
                    if(contPos==4) return true;
                }else contPos=0;
            }
        }
        return false;
    }

    private static Boolean mirarColumnas(boolean[][] matriz){
        for (int columna = 0; columna < matriz[0].length; columna++){
            int contPos=0;
            for (int fila  = 0; fila < matriz.length; fila++){
                if(matriz[fila][columna]){
                    contPos++;
                    if(contPos==4) return true;
                }else contPos=0;
            }
        }
        return false;
    }

    private static Boolean MirarDiagPos(boolean[][] matriz){
        for (int columna = 8; columna > 0; columna--){
            int fila=5;
            int contPos=0;
            int valCol = columna;
            int valFil = fila;
            while(inIndex(valCol,valFil)){
                System.out.println(valCol+"  "+valFil);
                System.out.println(matriz[valCol-1][valFil-1]);
                if(matriz[valFil][valCol]){
                    contPos++;
                    if(contPos==4) return true;
                }
                else contPos=0;
                valCol++;
                valFil++;
            }
        }
        return false;
    }
    private static boolean inIndex(int columna,int fila){
        if(columna>8 || columna<0) return false;
        if(fila>6 || fila<0) return false;
        return true;
    }
    /*
    private static ArrayList<Boolean> getDiagneg(){

    }
    private static boolean get4Trues(){

    }

    */
    public static boolean hayRaya4(String color){
        boolean[][] m = new boolean[1][1];
        if(color=="rojo") m=ocRojos;
        if(color=="azul") m=ocAzul;
        //if(mirarFilas(m)) return true;
        //if(mirarColumnas(m)) return true;
        //if(MirarDiagPos(m)) return true;
        return false;
    }
}
