
package VILLAS;


public class main {

    /**
     * @param args the command line arguments
     * 
     * DESARROLLADO POR:
     *      * 
     * STEEVEN SANCHEZ SEPULVEDA
     * johan.sanchez@correounivalle.edu.co
     * 
     * 
     */
    
    
    public static void main(String[] args) {
        
        System.out.println("Matriz Original");
        
        
        Proyecto ingenua = new Proyecto () ;
       
        Leertxt fc = new Leertxt();
        
        int matriz[][] = fc.leerMatriz();
        
        
        //------------------main----------------------------
        
        //DESCOMENTAR LA SOLUCION QUE SE QUIERE OBSERVAR
        // NO EJECUTAR MAS DE UNA SOLUCION A LA VEZ 
        
        System.out.println("\n" + "Solución Ingenua");
       //fc.imprimirMatriz(ingenua.obtenerMatriz(matriz));
        
        
        System.out.println("\n" + "Solución Dinamica");
      fc.imprimirMatriz(ingenua.solutionDinamica(matriz));
        
        
     
       
       System.out.println("\n" + "Solución Voraz");
      //fc.imprimirMatriz(ingenua.solucionVoraz(matriz));
      
       System.out.println("");
        
    }
    
    
    
}
