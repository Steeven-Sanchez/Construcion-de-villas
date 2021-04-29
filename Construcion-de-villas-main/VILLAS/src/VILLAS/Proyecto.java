
package VILLAS;

import java.util.ArrayList;


public class Proyecto {


      
    public int[][] MatrizFinal(int[][] matriz, int[][] n, int villas) {
        int matrizFinal[][] = new int[villas][matriz.length];
        for (int s = 0; s < matriz.length; s++) {
            for (int d = 0; d < villas; d++) {
                if (n[d][s] == 1) {
                    matrizFinal[d][s] = 1;
                }
            }
        }
        return matrizFinal;
    }

    public int[][] solutionDinamica(int[][] matriz) {

        //creacion de matriz N la cual nos arrojara al final la solucion 
        int n[][] = new int[matriz.length][matriz.length];
        //posiciones 0,0 (seleccion 0 , villa 0) se le inserta la primera seleccion
        n[0][0] = 1;

        //la "a" controla los punteros para las diagonales 
        int a = 1;

        //estos whiles aplicados a matriz m nos diran cuando
        //un pais es enemigo de otro 
        int villa = 0;
        int x = 0;

        while (a != matriz.length) {

            //apuntador de fila
            int i = 0;
            //apuntador de columna 
            int j = 0;

            int gj = 0;

            while ((i != a)) {

                // si hay una seleccion asignada
                if (n[villa][j] == 1) {

                    //if pregunta si tiene enemigos 
                    if ((matriz[i][a] == 0
                            && matriz[a][j] == 0)) {

                        gj = villa;
                    } else {

                        villa = villa + 1;
                        gj = villa;
                        if (gj > x) {
                            x = gj;
                        }
                    }
                }
                i++;
                j++;

            }
            n[gj][a] = 1;
            villa = 0;
            a++;   }
        
        x = x + 1;
        int matrizFinal[][] = new int[x][matriz.length];
        //se genera la matriz final en base a la asignada de forma provicional
     //se hace para que no imprima las villas necesarias
        for (int s = 0; s < matriz.length; s++) {
            for (int d = 0; d < x; d++) {
                if (n[d][s] == 1) {
                    matrizFinal[d][s] = 1;
                }
            }
        }
        return MatrizFinal(matriz, n, x);

    }

    public int AsignarVilla(int matriz[][]) {
        int n = matriz.length;
        int numeroAmigos = 0;
        int filaSeleccionada = 0;
        int numeroSeleccion = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == 0) {
                    numeroAmigos++;
                }
            }
            if (numeroAmigos > filaSeleccionada) {
                filaSeleccionada = numeroAmigos;
                numeroSeleccion = i;
            }

            numeroAmigos = 0;
        }
        return numeroSeleccion;

    }

    public int[][] obtenerMatriz(int matriz[][]) {

        boolean validar = true;
        int x = 0;
        int n = matriz.length;
        int matrizSolucion[][] = new int[n][n];
        int matrizTemperoal[][] = matriz;
        int numeroVilla = 0;
        while (validar) {
            // Seleccion es el pais con mayor relaciones amistosas en la mtriz actual
            int seleccion = AsignarVilla(matrizTemperoal);
            //arreglo para almacenar los paises que se hospedan en la misma villa
            ArrayList fila1 = new ArrayList();
            for (int i = 0; i < matriz.length; i++) {
                //se verifica si los paises tiene relacion con el pais con mas amigos
                if (matriz[seleccion][i] == 0 && matriz[i][seleccion] == 0) {
                    fila1.add(i);
                    for (int k = 0; k <= (fila1.size() - 1); k++) {
                        //se verifica si los paises no tienen problemas entre si
                        if (matriz[(int) fila1.get(k)][i] == 1 || matriz[i][(int) fila1.get(k)] == 1) {
                            fila1.remove(fila1.size() - 1);
                        }
                    }
                }
            }
            // se llena la matriz provicional con el numero de villa seleccionado
            for (int m = 0; m < fila1.size(); m++) {
                matrizSolucion[numeroVilla][(int) fila1.get(m)] = 1;
                x++;
                //se elimina los paises a los cuales ya se les asigno una villa
                for (int l = 0; l < n; l++) {
                    matrizTemperoal[(int) fila1.get(m)][l] = 1;
                }
            }
            numeroVilla++;
            //se valida si todos los paises ya tienen una villa asignada
            if (x == n) {
                validar = false;
            }
        }
        return MatrizFinal(matriz, matrizSolucion, numeroVilla);
    }

    public int[][] solucionVoraz(int matriz[][]) {

        
        
        
        
        //inicializar
        int temp[][] = new int[matriz.length][matriz.length];
        int n[][] = new int[matriz.length][matriz.length];

        
        //generar matriz transpuesta
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 1) {
                    temp[i][j] = 1;
                    temp[j][i] = 1;
                }
            }
        }
        //________________________________________________________
        
        int [] insertadas = new int [matriz.length];
       
         
        
        int verifica = 0;
        boolean b= true ;
        
        for (int i = 0; verifica < matriz.length; i++) {
          
            for (int j = i; j < matriz.length; j++) {
               
                
                //ignore las que inserto 
            if (insertadas[j]==0 ) {    
                //encuentre un cero en Matriz 
                if (temp[i][j]==0){
                    
                //apuntador de columnas en N   
                int cont = i ;
                           //pare cuando se encuentre con ella 
                            while(cont!=j){
                     
                    //esta alguien en la villa ?
                              if (n[i][cont]==1 )
                              {
                                  //pueden ir juntos?
                                if (temp[cont][j]==0) 
                                    { } 
                                    else {b=false;}
                                   }
                              cont++;  
                            }   
                            
                   //si es amiga de todas         
               if (b) {
                   //insertar en n 
                   n[i][cont]=1 ;
                   //insertar en insertadas (lista)
                        insertadas [cont] =1 ;
                        
                        
               //para que no siga iterando en m 
               if (verifica==matriz.length){
                   //y aqui rompa el bucle apenas todas esten insertadas
                   break ;}
                   else {verifica ++ ;}
               }
               b=true ;
                
                }     
            }
            }
         
        }
       //imprime matriz n
     
       return n ;
        

    }

}
