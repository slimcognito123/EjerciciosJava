package ejercicio3;

/**
 * Created by curso mañana on 29/11/2016.
 */
public class Matrix6x8 {

    public Matrix6x8() {
        int[][] matrix = new int[6][8];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = (int) Math.floor(Math.random() * 100);
            }
        }
        int maximo = 0;
        int minimo = 100;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matrix[i][j]+" ");
                if (matrix[i][j] > maximo) {
                    maximo = matrix[i][j];
                }
                if (matrix[i][j]<minimo){
                    minimo= matrix[i][j];
                }
            }
            System.out.println("");
        }
        System.out.println("el numero mayor es el "+maximo+" y el menor el "+minimo);
    }

    public static void main(String[] args) {
        new Matrix6x8();
    }
}
