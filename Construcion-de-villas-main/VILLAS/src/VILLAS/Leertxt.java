
package VILLAS;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Leertxt {
    // Arreglo para el almacenamiento de los valores
    ArrayList valores;
    // Arreglo para el almacenamiento de los valores de las filas
    ArrayList filas;
    // Arreglo para el almacenamiento de los valores de las  columnas
    ArrayList columnas;
    // Se lee  e imprime la matriz del .txt
   public int[][] leerMatriz(){

        int matriz[][]=null;
        try{
            FileReader fr = new FileReader("matriz2.txt");
            FileReader fr1 = new FileReader("matriz2.txt");
            BufferedReader br = new BufferedReader(fr);
            String tamaño[] = br.readLine().split(" ");
            BufferedReader BR = new BufferedReader(fr1);
            int n = tamaño.length;
            matriz= new int[n][n];
            String temp="";
            int i=0;
            while(temp!=null){
                temp = BR.readLine();
                String  p;
                p = temp;
                if(p!=null){
                    String []arreglo=p.split(" ");
                    for(int j=0;j<n;j++)
                    {
                        matriz[i][j]=Integer.parseInt(arreglo[j]);
                        System.out.print(matriz[i][j]+" ");
                    }
                }
                i+=1;
                System.out.print("\n");
            }
            br.close();
        }catch(IOException e){
            System.out.println(e.getCause());
        }
        return matriz;
    }

    // metodo para imprimir la matriz
    public void imprimirMatriz(int matriz[][]){
        // Variable para almacenar el tamaño de filas
        int fil = matriz.length;
        // Variable para almacenar el tamaño de las columnas (es igual al de las filas)
        int col = matriz[0].length;
        // se recorre la matriz y se imprime lo valores por pantalla
        for(int i=0;i<fil;i++){
            for(int j=0;j<col;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}