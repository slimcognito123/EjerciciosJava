package Beans;

import java.util.Random;

public abstract class Pescado extends Thread {
    boolean sexo; //0 hembra 1 macho
    //Coordenadas
    int x;
    int y;

    public Pescado(boolean sexo) {
        this.sexo = sexo;
        this.x = new Random().nextInt((19 - 0) + 1) + 0;
        this.y = new Random().nextInt((19 - 0) + 1) + 0;
    }

    @Override
    public void run() {
        movimiento();
    }

    public void movimiento() {//direccion 1:arriba 2:drch 3:abajo 4:izq
        int direccion = new Random().nextInt((5 - 1) + 1) + 1;
        switch (direccion) {
            case 1:
                y++;
                if (y > 19) y = 0;
                break;
            case 2:
                x++;
                if (x > 19) x = 0;
                break;
            case 3:
                y--;
                if (y < 0) y = 19;
                break;
            case 4:
                x--;
                if (x < 0) x = 19;
                break;
        }
        try {
            this.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void reproduccion();

    public int[] nacimiento() {
        Random random = new Random();
        int x = random.nextInt((19) + 1);
        int y = random.nextInt((19) + 1);
        return new int[]{x, y};
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
