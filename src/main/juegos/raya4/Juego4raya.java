package main.juegos.raya4;

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
