import java.util.Scanner;
public class ajedrez1 {
    public static String[][] tablero = {
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
    public static String pieza;
    private static int fila;
    private static int columna;
    public static String respuesta;
    public static String planilla;
    public static void tableroblancas() {
        System.out.println("Este es tu tablero de ajedrez para blancas.");
        for (int i = tablero.length - 1; i >= 1; i--) {
            System.out.println(" ");
            for (int j = 1; j < tablero.length; j++) {
                System.out.print(i + "," + j + ": " + tablero[i][j] + " ");
            }
        }
        System.out.println('\n');
    }
    public static void eleccionpiezasblancas() {
        System.out.println("Elige que pieza quieres usar: P=peon, C=caballo, A=alfil, T=torre, D=dama, R=rey ");
        Scanner piezas = new Scanner(System.in);
        pieza = piezas.nextLine();
        if (pieza.matches("P|p")) {
            System.out.println("Has elegido el peon.");
            peonblanco();
        } else if (pieza.matches("C|c")) {
            System.out.println("Has elegido el caballo.");
        } else if (pieza.matches("A|a")) {
            System.out.println("Has elegido el Alfil.");
        } else if (pieza.matches("T|t")) {
            System.out.println("Has elegido la torre.");
            torre();
        } else if (pieza.matches("D|d")) {
            System.out.println("Has elegido la dama.");
        } else if (pieza.matches("R|r")) {
            System.out.println("Has elegido el rey.");
        } else {
            System.out.println("No has puesto una pieza valida.");
        }
    }
    public static String peonblanco() {
        char inicial = 'P';
        do {
            Scanner sc = new Scanner(System.in);
            Scanner ajedrez = new Scanner(System.in);
            System.out.println("Dime la fila:");
            fila = ajedrez.nextInt();
            if (fila <= 1 || fila >= 8) {
                System.out.println("Error has puesto una fila incorrecta.");
            }
            else {
                System.out.println("Dime la columna: ");
                columna = ajedrez.nextInt();
                planilla = inicial + tablero[fila][columna];
                if (columna < 1 || columna > 8) {
                    System.out.println("Error has puesto una columna incorrecta.");
                } else if (fila < 7) {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.print("El peon blanco puede moverse a: ");
                    System.out.print(tablero[fila + 1][columna] + " ");
                    System.out.print(tablero[fila + 2][columna] + " ");
                    System.out.print('\n');
                    System.out.println("La planilla actual es: " + planilla);
                }
                if (fila == 7) {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.print("El peon blanco puede moverse a: ");
                    System.out.print(tablero[fila + 1][columna] + " ");
                    System.out.print('\n');
                    System.out.println("La planilla actual es: " + planilla);
                }
            }
            System.out.print("¿Quieres volver a mover el peon? si/no: ");
            respuesta = sc.next();
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            ajedrez1.main(null);
        }
        return "";
    }
    public static void tableronegras() {
        for (int i = 1; i < tablero.length; i++) {
            System.out.println(" ");
            for (int j = tablero.length - 1; j >= 1; j--) {
                System.out.print(i + "," + j + ": " + tablero[i][j] + " ");
            }
        }
        System.out.println('\n');
    }
    public static void eleccionpiezasnegras() {
        System.out.println("Elige que pieza quieres usar: P=peon, C=caballo, A=alfil, T=torre, D=dama, R=rey ");
        Scanner piezas = new Scanner(System.in);
        pieza = piezas.nextLine();
        if (pieza.matches("P|p")) {
            System.out.println("Has elegido el peon.");
            peonnegro();
        } else if (pieza.matches("C|c")) {
            System.out.println("Has elegido el caballo.");
        } else if (pieza.matches("A|a")) {
            System.out.println("Has elegido el Alfil.");
        } else if (pieza.matches("T|t")) {
            System.out.println("Has elegido la torre.");
            torre();
        } else if (pieza.matches("D|d")) {
            System.out.println("Has elegido la dama.");
        } else if (pieza.matches("R|r")) {
            System.out.println("Has elegido el rey.");
        } else {
            System.out.println("No has puesto una pieza valida.");
        }
    }
    public static String peonnegro() {
        char inicial = 'P';
        do {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la fila:");
        fila = sc.nextInt();
        System.out.println("Dime la columna: ");
        columna = sc.nextInt();
        planilla = inicial + tablero[fila][columna];
        if (fila <= 1 || fila >= 8 || columna < 1 || columna > 8) {
            System.out.println("Error has puesto una fila, columna incorrecta o has puesto el peon en la primero  o ultima fila.");
        } else if (fila > 1 && fila < 6) {
            System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
            System.out.print("El peon negro puede moverse a: ");
            System.out.print(tablero[fila - 1][columna] + " ");
            System.out.print(tablero[fila - 2][columna] + " ");
            System.out.print('\n');
            System.out.println("La planilla actual es: " + planilla);
        } else {
            System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
            System.out.print("El peon negro puede moverse a: ");
            System.out.print(tablero[fila - 1][columna] + " ");
            System.out.print('\n');
            System.out.println("La planilla actual es: " + planilla);
        }
            System.out.print("¿Quieres volver a mover el peon? si/no: ");
            respuesta = sc.next();
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            ajedrez1.main(null);
        }
        return "";
    }
    public static void torre() {
        char inicial = 'T';
        do {
            Scanner sc = new Scanner(System.in);
            Scanner ajedrez = new Scanner(System.in);
            System.out.println("Dime la fila:");
            fila = ajedrez.nextInt();
            System.out.println("Dime la columna: ");
            columna = ajedrez.nextInt();
            planilla = inicial + tablero[fila][columna];
            if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                System.out.println("No puedes poner un 0, la fila o la columna debe de ser de 1-8");
            } else {
                System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                System.out.print("La torre puede moverse a: ");
                for (int i = fila + 1; i < tablero.length; i++) {
                    System.out.print(tablero[i][columna] + " ");
                }
                for (int j = columna + 1; j < tablero.length; j++) {
                    System.out.print(tablero[fila][j] + " ");
                }
                for (int i = fila - 1; i >= 1; i--) {
                    System.out.print(tablero[i][columna] + " ");
                }
                for (int j = columna - 1; j >= 1; j--) {
                    System.out.print(tablero[fila][j] + " ");
                }
                System.out.print('\n');
                System.out.println("Tu planilla actual es: " + planilla);
            }
            System.out.print("¿Quieres volver a mover la torre? si/no: ");
            respuesta = sc.next();
        }while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            ajedrez1.main(null);
        }
    }
    public static void main (String[]args){
        int eleccion = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("------Bienvenido al programa de Ajedrez------");
                System.out.println("----------Por Favor elige una opción---------");
                System.out.println("0. Para salir del Programa.");
                System.out.println("1. Para elegir las piezas blancas.");
                System.out.println("2. Para elegir las piezas negras.");
                eleccion = sc.nextInt();
                switch (eleccion) {

                    case 0:
                        System.out.println("Adios, vuelve cuando quieras.");
                        break;

                    case 1:
                        tableroblancas();
                        eleccionpiezasblancas();
                        break;

                    case 2:
                        tableronegras();
                        eleccionpiezasnegras();
                        break;
                }
            } catch (Exception b) {
                System.out.println("Error has puesto un caracter o varios caracteres, vuelve a elegir una opcion.");
                System.out.println("Vuelve a intentarlo.");
                ajedrez1.main(null); //Llamamos a la funcion principal para poder preguntar de nuevo por las opciones.
            }
        } while (eleccion < 0 || eleccion > 2);
    }
}
