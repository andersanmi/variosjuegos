package main.juegos.raya3;

import java.util.ArrayList;

public class Juego3raya {
    private static boolean[][] ocupados,ocRojos,ocAzul;
    public static boolean partidaSigue = true;


    private static final Juego3raya miJuego3raya = new Juego3raya();
    public static Juego3raya getJuego3raya(){
        return miJuego3raya;
    }

    public void cargarJuego(){
        ocupados = new boolean[3][3];
        ocRojos = new boolean[3][3];
        ocAzul = new boolean[3][3];
        partidaSigue=true;
    }
    public void reiniciarJuego(){
        ocupados = new boolean[3][3];
        ocRojos = new boolean[3][3];
        ocAzul = new boolean[3][3];
        partidaSigue=true;
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

    public int[] iaFacil(){
        IAFacil ia = new IAFacil(ocupados);
        int[] pos = ia.setPos();
        ocupados[pos[0]][pos[1]]=true;
        return pos;
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
    private static Boolean mirarFilas(boolean[][] matriz){
        for (int fila = 0; fila < matriz.length; fila++){
            int contPos=0;
            for (int columna = 0; columna < matriz[0].length; columna++){
                if(matriz[fila][columna]){
                    contPos++;
                    if(contPos==3) return true;
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
                    if(contPos==3) return true;
                }else contPos=0;
            }
        }
        return false;
    }
    private static Boolean mirarDiag(boolean[][] matriz){
        if(matriz[0][0] && matriz[1][1] && matriz[2][2]) return true;
        if(matriz[2][0] && matriz[1][1] && matriz[0][2]) return true;
        return false;
    }
        public static boolean hayRaya3(String color){
        boolean[][] m = new boolean[1][1];
        if(color=="rojo") m=ocRojos;
        if(color=="azul") m=ocAzul;
        if(mirarFilas(m)) return true;
        if(mirarColumnas(m)) return true;
        if(mirarDiag(m)) return true;
        return false;
    }
    public static boolean todasLlenas(){
        for (boolean [] y:ocupados) {
            for (boolean x : y) {
                if (!x) return false;
            }
        }
        return true;
    }
}
