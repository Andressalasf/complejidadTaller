
package com.jmrh.ejerciciojava06;

import java.util.Scanner;

// Andres Felipe Salas Niño -192164
// Fabian Acosta - 192168

public class EjercicioJava06 { 

    private static Tablero tablero; //1 + (3n**2+25n+35) = 3n**2+25n+36
    private static Scanner scanner; //1 
    private static boolean partidaEnJuego; //1

    public static void main(String[] args) { //1 --> (114n**4 + 156n**3 + 585**2 + 425n +149) ; o(n**4)

        scanner = new Scanner(System.in); //1
        menuPrincipal(); // 1 + (114n**4 + 156n**3 + 585**2 + 425n +145) = 114n**4 + 156n**3 + 585**2 + 425n +146

    } // 1

    public static void menuPrincipal() { // 1 --> (114n**4 + 156n**3 + 585**2 + 425n +145) ; o(n**4)

        int opcion;//1

        do { //n
            System.out.println("\nMenu Principal\n"); //n
            System.out.println("1. Iniciar Nueva Partida"); //n
            System.out.println("2. Continuar partida actual"); //n
            System.out.println("3. Salir"); //n
            System.out.println("Introduce opción: "); //n

            try { //n
                opcion = Integer.parseInt(scanner.nextLine()); //n
            } catch (Exception e) { //n
                opcion = 0; //n
            } // n

            switch (opcion) {//n
                case 1: //n
                    iniciarPartida(); // 1 + (57n**4+78n**3+294n**2+212n+88) = 57n**4+78n**3+294n**2+212n+89
                    break; //n
                case 2: //n
                    if(partidaEnJuego)// n
                        continuarPartida();// 1 + (57n**4+78n**3+291n**2+187n+51) = 57n**4+78n**3+291n**2+187n+52
                    else //n
                        System.out.println("No hay partida en juego"); //n
                    break;//n
                case 3: //n
                    System.out.println("Fin del juego"); //n
                    break; //n
                default: //n
                    System.out.println("Opción desconocida"); //n
            } // n

        } while (opcion != 3); //n+1

    } // 1

    public static void iniciarPartida() { //1 --> (57n**4+78n**3+294n**2+212n+88) ; o(n**4)
        tablero = new Tablero(); // 1 + (3n**2+25n+35) = 3n**2+25n+36
        partidaEnJuego = true; //1
        juego(); // 1 + (57n**4+78n**3+291n**2+187n+48) = 57n**4+78n**3+291n**2+187n+49
    } // 1
    
    public static void continuarPartida() { // 1 --> 57n**4+78n**3+291n**2+187n+51 ; o(n**4)
        juego(); // 1 + (57n**4+78n**3+291n**2+187n+48) = 57n**4+78n**3+291n**2+187n+49
    } // 1

    public static void juego() { // 1 --> (57n**4+78n**3+291n**2+187n+48) ; o(n**4)
        String direccion; //1

        do { //n
        tablero.mostrar(); // n * (9n**3+29n**2+24n+9) = 9n**4+29n**3+24n**2+9n 
        System.out.println("izq (a) / der (d) / arriba (w) / abajo (s) / menu (m): "); // n
        direccion = scanner.nextLine(); // n

        switch (direccion) { // n
            case "w": // n
                tablero.moverArriba(); // n * (12n**3+10n**2+54n+30) = 12n**4+10n**3+54n**2+30n
                break; // n
            case "s": // n
                tablero.moverAbajo(); // n * (12n**3+10n**2+54n+30)  = 12n**4+10n**3+54n**2+30n
                break; // n
            case "a": // n
                tablero.moverIzquierda(); // n * (12n**3+10n**2+54n+30)  = 12n**4+10n**3+54n**2+30n
                break; // n
            case "d": // n
                tablero.moverDerecha(); // n * (12n**3+10n**2+54n+30)  = 12n**4+10n**3+54n**2+30n
                break; // n
            case "m": // n
                System.out.println("Volviendo al menu..."); // n
                break; // n
            default: // n
                System.out.println("Opción desconocida"); // n
        } // n
        
        } while(!direccion.equals("m") && !tablero.finPartida()); // n+1 + (9n**2+6n+12) = 9n**2+7n+13

        if (tablero.finPartida()) { // 1 + (9n**2+6n+12) = 9n**2+6n+13
            tablero.mostrar(); // 1 + (9n**3+29n**2+24n+9) = 9n**3+29n**2+24n+10
            String mensaje = tablero.ganador() ? "Has Ganado!!!" : "Has perdido"; //  1 + (4n**2 +3n + 4) = 4n**2 +3n + 5
            System.out.println(mensaje); // 1
            partidaEnJuego = false; // 1
        } // 1

    } // 1
} // 1
