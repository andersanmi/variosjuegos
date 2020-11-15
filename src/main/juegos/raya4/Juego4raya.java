package main.juegos.raya4;

public class Juego4raya {

    private static boolean[][] ocupados,ocRojos,ocAzul;
    public static boolean partidaSigue = true;
    private static final Juego4raya miJuego4raya = new Juego4raya();
    public static Juego4raya getJuego4raya(){
        return miJuego4raya;
    }

    /**
     * Carga el juegp, cargando todas las matrices.
     */
    public void cargarJuego(){
        ocupados = new boolean[6][9];
        ocRojos = new boolean[6][9];
        ocAzul = new boolean[6][9];
        partidaSigue=true;
    }

    /**
     * Reinicia el juego resetando las matrices.
     */
    public void reiniciarJuego(){
        ocupados = new boolean[6][9];
        ocRojos = new boolean[6][9];
        ocAzul = new boolean[6][9];
        partidaSigue=true;
    }

    /**
     * @param colum columna de la matriz
     * @param color color del jugador actual
     * Si la columna indicada no está llena, mete la ficha
     * @return devuelve el numero de la fila si puede meter la ficha, -1 si no puediera
     */
    public static int meteFicha(int colum,String color){
        int fila = -1;
        if(!ocupados[0][colum]){
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

    /**
     * @return devuelve la columna en la que la IA meterá la ficha
     */
    public int iaFacil(){
        IAFacil ia = new IAFacil();
        return ia.selCollum();
    }

    /**
     * @return devuelve la columna en la que la IA meterá la ficha
     */
    public int iaDificil(){
        IADificil ia = new IADificil(ocupados,ocRojos,ocAzul);
        return ia.selCollum();
    }

    /**
     * Imprime todas las matrices, la general, la del jugador azul y la del jugador rojo
     */
    public static void printMatrix(){
        System.out.println("Todo");
        printMatrixSel(ocupados);
        System.out.println("azul");
        printMatrixSel(ocAzul);
        System.out.println("rojo");
        printMatrixSel(ocRojos);
    }

    /**
     * @param mat matriz del juego
     * Imprime la matriz recibida como parámetro
     */
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

    /**
     * @param matriz matriz del jugador actual
     * Comprueba si hay 4 en raya en horizontal
     * @return devuelve true si hay 4 en raya, false si no lo hubiera
     */
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

    /**
     * @param matriz matriz del jugador actual
     * Comprueba si hay 4 en raya en vertical
     * @return devuelve true si hay 4 en raya, false si no lo hubiera
     */
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

    /**
     * @param matriz matriz del jugador actual
     * Comprueba si hay 4 en raya en diagonal ascendente
     * @return devuelve true si hay 4 en raya, false si no lo hubiera
     */
    private static Boolean mirarDiagPos(boolean[][] matriz){
        //mira las diagonales ascendentes
        for (int columna = 8; columna > 0; columna--){
            int fila=5;
            int contPos=0;
            int valCol = columna;
            int valFil = fila;
            while(inIndex(valFil,valCol)){
                if(matriz[valFil][valCol]){
                    contPos++;
                    if(contPos==4) return true;
                }
                else contPos=0;
                valCol++;
                valFil--;
            }
        }

        for (int fila = 5; fila > 0; fila--){
            int columna=0;
            int contPos=0;
            int valCol = columna;
            int valFil = fila;
            while(inIndex(valFil,valCol)){
                if(matriz[valFil][valCol]){
                    contPos++;
                    if(contPos==4) return true;
                }
                else contPos=0;
                valCol++;
                valFil--;
            }
        }
        return false;
    }

    /**
     * @param fila fila de la matriz
     * @param columna columna de la matriz
     * Comprueba si la posición que hace referencia a la fila y columna recibida es correcta
     * @return devuelve true si la posición es correcta, false si no lo fuese
     */
    private static boolean inIndex(int fila,int columna){
        if(columna>8 || columna<0) return false;
        if(fila>5 || fila<0) return false;
        return true;
    }

    /**
     * @param matriz matriz del jugador actual
     * Comprueba si hay 4 en raya en diagonal descendente
     * @return devuelve true si hay 4 en raya, false si no lo hubiera
     */
    private static Boolean mirarDiagNeg(boolean[][] matriz){
        //mira las diagonales descendentes
        for (int columna = 8; columna > 0; columna--){
            int fila=0;
            int contPos=0;
            int valCol = columna;
            int valFil = fila;
            while(inIndex(valFil,valCol)){
                if(matriz[valFil][valCol]){
                    contPos++;
                    if(contPos==4) return true;
                }
                else contPos=0;
                valCol++;
                valFil++;
            }
        }

        for (int fila = 0; fila < 5; fila++){
            int columna=0;
            int contPos=0;
            int valCol = columna;
            int valFil = fila;
            while(inIndex(valFil,valCol)){
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

    /**
     * Comprueba si todas las posiciones de la matriz del juego estas ocupadas
     * @return devuelve true si la matriz esta completa, false si no lo estuviera
     */
    public static boolean todasLlenas(){
        for (boolean [] y:ocupados) {
            for (boolean x : y) {
                if (!x) return false;
            }
        }
        return true;
    }

    /**
     * @param color color del jugador actual
     * Comprueba si el jugador actual ha conseguido hacer 4 en raya
     * @return devuelve true si el jugador actual ha conseguido 4 en raya, false si no lo hubiera conseguido
     */
    public static boolean hayRaya4(String color){
        boolean[][] m = new boolean[1][1];
        if(color=="rojo") m=ocRojos;
        if(color=="azul") m=ocAzul;
        if(mirarFilas(m)) return true;
        if(mirarColumnas(m)) return true;
        if(mirarDiagPos(m)) return true;
        if(mirarDiagNeg(m)) return true;
        return false;
    }
}
