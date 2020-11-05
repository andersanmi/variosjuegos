package main.juegos.raya3;

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

    public static void meteFicha(int fila, int columna,String color){

        if(color.equals("rojo")) ocRojos[fila][columna]=true;
        if(color.equals("azul")) ocAzul[fila][columna]=true;

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
