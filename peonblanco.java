import java.util.Scanner;
public class peonblanco {
    public static void main(String[] args) {
        //Algoritmo movimiento del peonblanco
        String[][] tablero = {
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1", " "},
                {" ", "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2", " "},
                {" ", "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3", " "},
                {" ", "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4", " "},
                {" ", "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5", " "},
                {" ", "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6", " "},
                {" ", "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7", " "},
                {" ", "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8", " "},
        };
        for (int i = 1; i < tablero.length; i++) {
            System.out.println(" ");
            for (int j = 1; j < tablero.length; j++) {
                System.out.print(i + "," + j + ": " + tablero[i][j] + " ");
            }
        }
        System.out.println('\n');
        int columna;
        int fila;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la fila:");
        fila = sc.nextInt();
        System.out.println("Dime una columna: ");
        columna = sc.nextInt();
        if (fila == 1 || fila == 8) {
            System.out.println("El peon no puede estar en la primera fila o en la ultima");
        }
        else if (fila >1 && fila < 6){
            System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
            System.out.print("El peon blanco puede moverse a: ");
            System.out.print(tablero[fila+1][columna] + " ");
            System.out.print(tablero[fila+2][columna] + " ");
        }
        else {
            System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
            System.out.print("El peon blanco puede moverse a: ");
            System.out.print(tablero[fila+1][columna] + " ");
        }
    }
}
