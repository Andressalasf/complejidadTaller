
package com.jmrh.ejerciciojava06;

import java.util.Random;


public class Tablero { //1
    
    public static final int FIL = 4; //1
    public static final int COL = 4; //1
    private final int[][] tablero; //1
    
    public Tablero() { //1 --> (3n**2+25n+32)
        tablero = new int[FIL][COL]; //1
        for(int f=0;f<FIL;f++) { // n+1
            for(int c=0;c<COL;c++) { // (n+1)*n --> n**2+n
                tablero[f][c] = 0; // n**2
            } // n**2
        } // n   
        
        ponerDos(); // 1 + (11n+13) = 11n+14
        ponerDos(); // 1 + (11n+13) = 11n+14
        
               
    }//1
    
    private int vaciasEnFila(int f) { //1  -->  (5n+5) ; n=4 ; 25
        int n=0; //1
        for(int c=0;c<COL;c++) { // n+1
            if(tablero[f][c]==0) { // n
                n++; //n
            } //n
        } //n
        return n; //1
    } //1
    
    private int vaciasEnColumna(int c) { //1  -->  (5n+5) ; n=4 ; 25
        int n=0; //1
        for(int f=0;f<FIL;f++) { // n+1
            if(tablero[f][c]==0) { //n
                n++; //n
            } // n
        } //n
        return n;//1
    } // 1
    
    private int vacias() { //1  --> (5n**2+3n+5) ; n=4 ; 97
        int n=0; //1
        for(int f=0;f<FIL;f++) { //n+1
            for(int c=0;c<COL;c++) { // (n+1)*n --> n**2+n
                if(tablero[f][c]==0) { // n**2
                    n++; // n**2
                } // n**2
            } // n**2
        } // n
        return n; //1
    } //1
    
    
    private void ponerDos() { //1  --> (11n+13) ; n=4 ; 57
        int f; //1
        int c; //1
        
        Random random = new Random(); //1
        
        do { //n
            f = random.nextInt(FIL); // n
        } while(vaciasEnFila(f) == 0); // (n+1)+(5n+5) = 6n+6
        
        do { //n
            c = random.nextInt(COL); //n
        } while(tablero[f][c] != 0); // n+1
        
        tablero[f][c] = 2; //1
        
    }//1
    
    
    public void mostrar() { // 1   -->   (9n**3+29n**2+24n+8); n=4 ; 1144
        for(int f=0;f<FIL;f++) { // n+1
            dibujaLineaHorizontal(); // (3n**2+4n+5)*n = 3n**3+ 4n**2+5n
            dibujaEspacioHorizontal(); // (3n**2+4n+5)*n = 3n**3+ 4n**2+5n
            System.out.print("|"); //n
            for(int c=0;c<COL;c++) { // (n+1)*n --> n**2+n
                System.out.print("    "); // n**2
                if(tablero[f][c]>=1000) // n**2
                    System.out.print(tablero[f][c]); //n**2
                else if(tablero[f][c] >= 100) //n**2
                    System.out.print(" "+tablero[f][c]); //n**2
                else if(tablero[f][c] >= 10) //n**2
                    System.out.print(" "+tablero[f][c]+" "); // n**2
                else if(tablero[f][c] > 0) //n**2
                    System.out.print("  "+tablero[f][c]+" ");// n**2
                else if(tablero[f][c] == 0) //n**2
                    System.out.print("    "); // n**2
                System.out.print("    |"); //n**2
            }// n**2
            System.out.print("\n"); //n
            dibujaEspacioHorizontal(); // (3n**2+4n+5)*n = 3n**3+ 4n**2+5n
        } //n
        dibujaLineaHorizontal(); //(3n**2+4n+5)
    } // 1 
    
    private void dibujaLineaHorizontal() { //1   -->  (3n**2+4n+5) ; n=4 ; 69
        
        System.out.print("|"); // 1
        for(int c=0;c<COL;c++) { // n+1
            for(int i=0;i<12;i++) { // (n+1)*n --> n**2+n
                System.out.print("-"); // n**2
            }// n**2
            System.out.print("|");//n
        } //n
        System.out.print("\n");//1
        
    } //1
    
    private void dibujaEspacioHorizontal() { //1  -->   ( 3n**2+4n+5) ; n=4 ; 69
         System.out.print("|"); //1
        for(int c=0;c<COL;c++) { // n+1
            for(int i=0;i<12;i++) { // (n+1)*n --> n**2+n
                System.out.print(" "); // n**2
            }// n**2
            System.out.print("|");//n
        } //n
        System.out.print("\n"); //1
    }//1
    
    public boolean ganador() { //1 --> (4n**2 +3n + 4)
        for(int f=0;f<FIL;f++) {    //n+1      
            for(int c=0;c<COL;c++) {  // (n+1) * n --> n**2+n
                if(tablero[f][c]==2048) return true; // n**2 + n**2
            } // n**2          
        }  // n
        return false; //1
    } //1
    
    public boolean finPartida() { //1 --> (9n**2+6n+12)
        return (ganador() || vacias()==0); // 1 + (4n**2 +3n + 4) + (5n**2+3n+5) --> 9n**2+6n+10
    } // 1
    
    public void moverArriba() { // 1 --> (12n**3+10n**2+54n+30)
        for(int c=0; c<COL; c++) { //n+1
            moverArribaColumna(c); // n * (12n**2+1n+35) = 12n**3+1n**2+35n
        } // n
        if(!finPartida()) // 1 + (9n**2+6n+12) = 9n**2+6n+13
                ponerDos(); // 1 + (11n+13) = 11n+14
    } // 1
    
    private void moverArribaColumna(int c) { // 1 --> (12n**2+1n+35)
        colocarArriba(c); // 1+ (6n**2-5n+14) = 6n**2-5n+15
        sumarArriba(c); // 1+ (11n+4) = 11n+5
        colocarArriba(c); //  1+ (6n**2-5n+14) = 6n**2-5n+15
    }
    
    private void colocarArriba(int c) { // 1  --> (6n**2-5n+14)
        
        if(vaciasEnColumna(c) < COL) { // (5n+5) + 1+ 1 = 5n+7
            for(int veces = 0;veces < COL-1;veces++) { // n-1
                for(int f=0;f<FIL-1;f++) { // (n-1) * (n-1) = n**2-2n+1
                    if(tablero[f][c]==0) { // (n-1) * (n-1) = n**2-2n+1
                        tablero[f][c] = tablero[f+1][c]; // (n-1) * (n-1) = n**2-2n+1
                        tablero[f+1][c] = 0; // (n-1) * (n-1) = n**2-2n+1
                    } // (n-1) * (n-1) = n**2-2n+1
                } // (n-1) * (n-1) = n**2-2n+1
            } //n-1
        } // 1
        
    } // 1
    
    
    private void sumarArriba(int c) { // 1 (11n+4)
        if(vaciasEnColumna(c)<FIL-1) { // (5n+5) + 1 +1 = 5n+7
            for(int f=0;f<FIL-1;f++) { // n-1
                if(tablero[f][c] == tablero[f+1][c]) { //n-1
                    tablero[f][c] *= 2; //n-1
                    tablero[f+1][c] = 0; // n-1
                } //n-1
            } // n-1
        } // 1
    } // 1
    
    
    
    
    
    public void moverAbajo() { // 1 --> (12n**3+10n**2+54n+30)
        for(int c=0; c<COL; c++) { // n+1
            moverAbajoColumna(c); // n * (12n**2+1n+35) = 12n**3+1n**2+35n
        } //n
        if(!finPartida()) // 1 + (9n**2+6n+12) = 9n**2+6n+13
                ponerDos(); // 1 + (11n+13) = 11n+14
    } // 1
    
    private void moverAbajoColumna(int c) { // 1 --> (12n**2+1n+35)
        colocarAbajo(c); // 1 + (6n**2-5n+14) = 6n**2-5n+15
        sumarAbajo(c); // 1+ (11n+4) = 11n+5
        colocarAbajo(c); //  1 + (6n**2-5n+14) = 6n**2-5n+15
    }
    
    private void colocarAbajo(int c) { // 1 --> (6n**2-5n+14)
        
        if(vaciasEnColumna(c) < COL) { // 1 + (5n+5) + 1 = 5n+7
            for(int veces = 0;veces < COL-1;veces++) { // n-1
                for(int f=FIL-1;f>0;f--) { // (n-1) * (n-1) = n**2-2n+1
                    if(tablero[f][c]==0) { // (n-1) * (n-1) = n**2-2n+1
                        tablero[f][c] = tablero[f-1][c]; // (n-1) * (n-1) = n**2-2n+1
                        tablero[f-1][c] = 0; // (n-1) * (n-1) = n**2-2n+1
                    } // (n-1) * (n-1) = n**2-2n+1
                } // (n-1) * (n-1) = n**2-2n+1
            } // n-1
        } // 1
        
    } //1
    
    
    private void sumarAbajo(int c) { // 1 --> (11n+4)
        if(vaciasEnColumna(c)<FIL-1) { // 1 + 1  + (5n+5) = 5n+7
            for(int f=FIL-1;f>0;f--) { // n-1
                if(tablero[f][c] == tablero[f-1][c]) { // n-1
                    tablero[f][c] *= 2; // n-1
                    tablero[f-1][c] = 0; // n-1
                } // n-1
            } // n-1
        } // 1
    } // 1
    
    
    
    public void moverDerecha() { // 1 --> (12n**3+10n**2+54n+30)
        for(int f=0; f<COL; f++) { // n+1
            moverDerechaFila(f); // n * (12n**2+1n+35) = 12n**3+1n**2+35n
        } //n
        if(!finPartida()) // 1 + (9n**2+6n+12) = 9n**2+6n+13
                ponerDos();  // 1 + (11n+13) = 11n+14
    }
    
    private void moverDerechaFila(int f) { // 1 --> (12n**2+1n+35)
        colocarDerecha(f); // 1 + (6n**2-5n+14) = 6n**2-5n+15
        sumarDerecha(f); // 1 + (11n+4) = 11n+5
        colocarDerecha(f); // 1 + (6n**2-5n+14) = 6n**2-5n+15
    }
    
    private void colocarDerecha(int f) { // 1 --> (6n**2-5n+14)
        
        if(vaciasEnFila(f) < FIL) { // 1 + 1 + (5n+5) = 5n+7
            for(int veces = 0;veces < COL-1;veces++) { // n-1
                for(int c=COL-1;c>0;c--) { //n-1 * (n-1) --> n**2 - 2n + 1
                    if(tablero[f][c]==0) { //n-1 * (n-1) --> n**2 - 2n + 1
                        tablero[f][c] = tablero[f][c-1]; //n-1 * (n-1) --> n**2 - 2n + 1
                        tablero[f][c-1] = 0; //n-1 * (n-1) --> n**2 - 2n + 1
                    } //n-1 * (n-1) --> n**2 - 2n + 1
                } //n-1 * (n-1) --> n**2 - 2n + 1
            }// n-1
        } // 1
        
    } // 1
    
    
    private void sumarDerecha(int f) { // 1 --> (11n+4)
        if(vaciasEnFila(f)<FIL-1) { // 1 + 1 + (5n+5) = 5n+7
            for(int c=COL-1;c>0;c--) { // n-1
                if(tablero[f][c] == tablero[f][c-1]) { // n-1
                    tablero[f][c] *= 2; // n-1
                    tablero[f][c-1] = 0; // n-1
                } // n-1
            } // n-1
        } //1
    } //1
    
    
    public void moverIzquierda() { //1 --> (12n**3+10n**2+54n+30)
        for(int f=0; f<FIL; f++) { // n+1
            moverIzquierdaFila(f); // n * (12n**2+1n+35) = 12n**3+1n**2+35n
        } //n
        if(!finPartida()) // 1 + (9n**2+6n+12) = 9n**2+6n+13
                ponerDos(); // 1 + (11n+13) = 11n+14
    }//1
    
    private void moverIzquierdaFila(int f) { // 1 --> (12n**2+1n+35)
        colocarIzquierda(f); // 1 + (6n**2-5n+14) = 6n**2-5n+15
        sumarIzquierda(f); // 1 + (11n+4) = 11n+5
        colocarIzquierda(f); // 1 + (6n**2-5n+14) = 6n**2-5n+15
    }
    
    private void colocarIzquierda(int f) { //1 (6n**2-5n+14)
        
        if(vaciasEnFila(f) < FIL) { // (comparacion = 1) + (5n+5) + (llamada al metodo = 1) -->5n+7
            for(int veces = 0;veces < COL-1;veces++) { // n-1
                for(int c=0;c<COL-1;c++) { // n-1 * (n-1) --> n**2-2n+1
                    if(tablero[f][c]==0) { // (n-1) * (n-1) --> n**2-2n+1
                        tablero[f][c] = tablero[f][c+1]; //  (n-1) * (n-1) --> n**2-2n+1
                        tablero[f][c+1] = 0; // (n-1) * (n-1) --> n**2-2n+1
                    } // (n-1) * (n-1) --> n**2-2n+1
                } // (n-1) * (n-1) --> n**2-2n+1
            } // n-1 
        } // 1
        
    } // 1
    
    
    private void sumarIzquierda(int f) { //1   (11n+4)
        if(vaciasEnFila(f)<FIL-1) { // (comparacion = 1) + (5n+5) + (llamada al metodo = 1)  -->5n+7
            for(int c=0;c<COL-1;c++) { // n-1
                if(tablero[f][c] == tablero[f][c+1]) { // n -1
                    tablero[f][c] *= 2; //n -1
                    tablero[f][c+1] = 0; //n -1
                } // n-1
            } //n-1
        } //1
    } //1
      
} // 1
