package ejercicio1;

/**
 * Created by curso mañana on 29/11/2016.
 */
public class SumaDeMatrices {

    public SumaDeMatrices() {
        int[][] matriz1= new int [4][4];
        int[][] matriz2= new int [4][4];

        for (int i = 0; i < matriz1[0].length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matriz1[i][j]=(int)Math.floor(Math.random()*100);
                matriz2[i][j]=(int)Math.floor(Math.random()*100);
            }
        }
        for (int i = 0; i < matriz1[0].length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                System.out.print(matriz1[i][j]+" ");
            }
            System.out.print("  +  ");
            for (int j = 0; j < matriz1[0].length; j++) {
                System.out.print(matriz2[i][j]+" ");
            }
            System.out.print("\n");
        }
        int [][]matrix =new int[4][4];
        for (int i = 0; i < matriz1[0].length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matrix[i][j]=matriz1[i][j]+matriz2[i][j];
            }
        }
        for (int i = 0; i < matriz1[0].length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        new SumaDeMatrices();
    }
}
