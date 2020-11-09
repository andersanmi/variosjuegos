package main.juegos.raya3;

import java.util.Random;

public class IAFacil {
    private boolean [][] ocupados;
    public IAFacil(boolean [][] pocupados){
        ocupados = pocupados;
    }
    public int[] setPos(){
        boolean valido = false;
        Random r = new Random();
        int fila=0;
        int columna=0;

        while (!valido){
            fila = r.nextInt(3);
            columna = r.nextInt(3);
            if (!ocupados[fila][columna]) {
                valido = true;
            }
        }
        int[] array= new int[]{fila, columna};
        return array;
    }
}
