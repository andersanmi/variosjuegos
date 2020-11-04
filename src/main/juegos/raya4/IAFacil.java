package main.juegos.raya4;

import java.util.Random;

public class IAFacil {
    public IAFacil(){    }
    public int selCollum(){
        Random r = new Random();
        int num = r.nextInt(9);
        return num;
    }
}
