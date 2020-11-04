package main.juegos;

public class Juego4raya {
    public static boolean[][] ocupados,ocRojos,ocAzul;


    private static final Juego4raya miJuego4raya = new Juego4raya();
    public static Juego4raya getJuego4raya(){
        return miJuego4raya;
    }

    public void cargarJuego(){
        ocupados = new boolean[9][6];
        ocRojos = new boolean[9][6];
        ocAzul = new boolean[9][6];
    }


    public static void meteFicha(int colum){
        if(!ocupados[0][colum]){//hay hueco

        }else{//columna completa
            System.out.println("columna completa");
        }
    }



}
