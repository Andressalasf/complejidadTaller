
package com.jmrh.ejerciciojava06;

import java.util.Scanner;

public class EjercicioJava06 {

    private static Tablero tablero; //1
    private static Scanner scanner; //1 
    private static boolean partidaEnJuego; //1

    public static void main(String[] args) {

        scanner = new Scanner(System.in); //1
        menuPrincipal(); // 26n+2

    }

    public static void menuPrincipal() {

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
            }

            switch (opcion) {//n
                case 1: //n
                    iniciarPartida(); //()
                    break; //n
                case 2: //n
                    if(partidaEnJuego)// n
                        continuarPartida();// ()
                    else //n
                        System.out.println("No hay partida en juego"); //n
                    break;//n
                case 3: //n
                    System.out.println("Fin del juego"); //n
                    break; //n
                default: //n
                    System.out.println("Opción desconocida"); //n
            }

        } while (opcion != 3); //n+1

    }

    public static void iniciarPartida() {
        tablero = new Tablero(); //1
        partidaEnJuego = true; //1
        juego();
    }
    
    public static void continuarPartida() {
        juego();
    }

    public static void juego() {
        String direccion; //1

        do { //n
        tablero.mostrar();
        System.out.println("izq (a) / der (d) / arriba (w) / abajo (s) / menu (m): ");
        direccion = scanner.nextLine();

        switch (direccion) {
            case "w":
                tablero.moverArriba();
                break;
            case "s":
                tablero.moverAbajo();
                break;
            case "a":
                tablero.moverIzquierda();
                break;
            case "d":
                tablero.moverDerecha();
                break;
            case "m":
                System.out.println("Volviendo al menu...");
                break;
            default:
                System.out.println("Opción desconocida");
        }
        
        } while(!direccion.equals("m") && !tablero.finPartida());

        if (tablero.finPartida()) {
            tablero.mostrar();
            String mensaje = tablero.ganador() ? "Has Ganado!!!" : "Has perdido";
            System.out.println(mensaje);
            partidaEnJuego = false;
        }

    }
}
