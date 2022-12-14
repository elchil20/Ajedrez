import java.util.Scanner;
public class ajedrez {

    // ----------------- MAIN ------------------ //

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
                    {
                        tableroblancas();
                        eleccionpiezasblancas();
                    }
                    break;
                    case 2:
                    {
                        tableronegras();
                        eleccionpiezasnegras();
                    }
                    break;
                }
            } catch (Exception a) {
                System.out.println("Error has puesto un caracter o varios caracteres, vuelve a elegir una opcion.");
                System.out.println("Vuelve a intentarlo.");
                ajedrez.main(null); //Llamamos a la funcion principal para poder preguntar de nuevo por las opciones.
            }
        } while (eleccion < 0 || eleccion > 2);
    }

    // --------------------------------- //

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

    // --------- LLAMADA A MÉTODOS --------- //

    public static String letra;

    // --> MÉTODO DE SELECCIÓN/ASIGNACIÓN DE LETRA

    public static void letras() {
        switch (letra) {
            case "a":
                columna = 1;
                break;
            case "b":
                columna = 2;
                break;
            case "c":
                columna = 3;
                break;
            case "d":
                columna = 4;
                break;
            case "e":
                columna = 5;
                break;
            case "f":
                columna = 6;
                break;
            case "g":
                columna = 7;
                break;
            case "h":
                columna = 8;
                break;
        }
    }

    // ------------- VARIABLES PUBLIC/PRIVATE ------------ //

    public static String pieza;
    private static int fila;
    private static int columna;
    public static String respuesta;
    public static String planilla;

    // --------------------------------------------------- //

    // --> MÉTODO DE ASIGNACIÓN DE TABLERO - PARTE BLANCA

    public static void tableroblancas() {
        System.out.println("Este es tu tablero de ajedrez para las piezas blancas.");
        for (int i = tablero.length - 1; i >= 1; i--) {
            System.out.println(" ");
            for (int j = 1; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
        }
        System.out.println('\n');
    }

    // --> MÉTODO DE ELECCIÓN DE PIEZAS - BLANCAS

    public static void eleccionpiezasblancas() {
        System.out.println("Elige que pieza quieres usar: P=Peon, C=Caballo, A=Alfil, T=Torre, D=Dama, R=Rey ");
        Scanner piezas = new Scanner(System.in);
        pieza = piezas.nextLine();
        if (pieza.matches("[Pp]")) {
            System.out.println("Has elegido el Peon.");
            peonblanco();
        } else if (pieza.matches("[Cc]")) {
            System.out.println("Has elegido el Caballo.");
        } else if (pieza.matches("[Aa]")) {
            System.out.println("Has elegido el Alfil.");
            alfil();
        } else if (pieza.matches("[Tt]")) {
            System.out.println("Has elegido la Torre.");
            torre();
        } else if (pieza.matches("[Dd]")) {
            System.out.println("Has elegido la Dama.");
            dama();
        } else if (pieza.matches("[Rr]")) {
            System.out.println("Has elegido el Rey.");
            rey();
        } else {
            System.out.println("No has puesto una pieza valida.");
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE PEÓN - BLANCO

    public static void peonblanco() {
        char inicial = 'P';
        do {
            Scanner peon = new Scanner(System.in);
            try {
                System.out.println("Ahora dime su posicion inicial.");
                System.out.println("Dime una letra: ");
                letra = peon.nextLine();
                System.out.println("Dime un numero: ");
                fila = peon.nextInt();
                letras();
                planilla = inicial + tablero[fila][columna];
                if (fila <= 1 || fila >= 8) {
                    System.out.println("Error el peon no puede estar en esa posicion.");
                } else {
                    if (columna < 1 || columna > 8) {
                        System.out.println("Error el peon no puede estar en esa posicion.");
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
            } catch (Exception b) {
                System.out.println("Error el peon no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover el peon? si/no: ");
            respuesta = peon.next();
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            ajedrez.main(null);
        }
    }

    // --> MÉTODO DE SELECCIÓN/ASGINACIÓN DE TABLERO - PARTE NEGRA

    public static void tableronegras() {
        System.out.println("Este es tu tablero de ajedrez para las piezas negras.");
        for (int i = 1; i < tablero.length; i++) {
            System.out.println(" ");
            for (int j = tablero.length - 1; j >= 1; j--) {
                System.out.print(tablero[i][j] + " ");
            }
        }
        System.out.println('\n');
    }

    // --> MÉTODO DE ELECCIÓN DE PIEZAS - NEGRAS

    public static void eleccionpiezasnegras() {
        System.out.println("Elige que pieza quieres usar: P=Peon, C=Caballo, A=Alfil, T=Torre, D=Dama, R=Rey ");
        Scanner piezas = new Scanner(System.in);
        pieza = piezas.nextLine();
        if (pieza.matches("[Pp]")) {
            System.out.println("Has elegido el Peon.");
            peonnegro();
        } else if (pieza.matches("[Cc]")) {
            System.out.println("Has elegido el Caballo.");
        } else if (pieza.matches("[Aa]")) {
            System.out.println("Has elegido el Alfil.");
            alfil();
        } else if (pieza.matches("[Tt]")) {
            System.out.println("Has elegido la Torre.");
            torre();
        } else if (pieza.matches("[Dd]")) {
            System.out.println("Has elegido la Dama.");
            dama();
        } else if (pieza.matches("[Rr]")) {
            System.out.println("Has elegido el Rey.");
            rey();
        } else {
            System.out.println("No has puesto una pieza valida.");
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE PEÓN - NEGRO

    public static void peonnegro() {
        char inicial = 'P';
        do {
            Scanner peon = new Scanner(System.in);
            try {
                System.out.println("Ahora dime su posicion inicial.");
                System.out.println("Dime una letra: ");
                letra = peon.nextLine();
                System.out.println("Dime un numero: ");
                fila = peon.nextInt();
                letras();
                planilla = inicial + tablero[fila][columna];
                if (fila <= 1 || fila >= 8 || columna < 1 || columna > 8) {
                    System.out.println("Error el peon no puede estar en esa posicion.");
                } else if (fila < 6) {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.print("El peon puede moverse a: ");
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
            } catch (Exception c) {
                System.out.println("Error el peon no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover el peon? si/no: ");
            respuesta = peon.next();
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE TORRE

    public static void torre() {
        char inicial = 'T';
        do {
            Scanner torre = new Scanner(System.in);
            try {
                System.out.println("Ahora dime su posicion inicial.");
                System.out.println("Dime una letra: ");
                letra = torre.nextLine();
                System.out.println("Dime un numero: ");
                fila = torre.nextInt();
                letras();
                planilla = inicial + tablero[fila][columna];
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                    System.out.println("Error el formato debe de ser de a-h y 1-8");
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
            } catch (Exception d) {
                System.out.println("Error la torre no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover la torre? si/no: ");
            respuesta = torre.next();
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE ALFIL

    public static void alfil() {
        char inicial = 'A';
        do {
            Scanner alfil = new Scanner(System.in);
            try {
                System.out.println("Ahora dime su posicion inicial.");
                System.out.println("Dime una letra: ");
                letra = alfil.nextLine();
                System.out.println("Dime un numero: ");
                fila = alfil.nextInt();
                letras();
                planilla = inicial + tablero[fila][columna];
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                    System.out.println("Error el formato debe de ser de a-h y 1-8");
                }
                else {
                    for (int i = fila + 1; i < tablero.length; i++) {
                        System.out.print(tablero[i][(columna + i) - fila] + " ");
                    }
                    for (int i = columna - 1; i >= 1; i--) {
                        System.out.print(tablero[(columna - i) + fila][(i)] + " ");
                    }
                    for (int i = fila - 1; i >= 1; i--) {
                        System.out.print(tablero[i][(columna - i) + fila] + " ");
                    }
                    for (int i = columna-1; i >= 1; i--) {
                        System.out.print(tablero[(fila + i) - columna][i] + " ");
                    }
                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception e) {
                System.out.println("Error el alfil no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover el alfil? si/no: ");
            respuesta = alfil.next();
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE CABALLO

    public static void caballo() {

    }

    // --> MÉTODO DE MOVIMIENTOS DE REY

    public static void rey() {
        char inicial = 'R';
        do {
            Scanner rey = new Scanner(System.in);
            try {
                System.out.println("Ahora dime su posicion inicial.");
                System.out.println("Dime una letra: ");
                letra = rey.nextLine();
                System.out.println("Dime un numero: ");
                fila = rey.nextInt();
                letras();
                planilla = inicial + tablero[fila][columna];
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                    System.out.println("Error el formato debe de ser de a-h y 1-8");
                } else {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.println("El rey puede puede moverse a: ");
                    for (int i = fila + 1; i < tablero.length; ) {
                        System.out.print(tablero[i][columna] + " ");
                        break;
                    }
                    for (int j = columna + 1; j < tablero.length; ) {
                        System.out.print(tablero[fila][j] + " ");
                        break;
                    }
                    for (int i = fila - 1; i >= 1; ) {
                        System.out.print(tablero[i][columna] + " ");
                        break;
                    }
                    for (int j = columna - 1; j >= 1; ) {
                        System.out.print(tablero[fila][j] + " ");
                        break;
                    }
                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception g) {
                System.out.println("Error el rey no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover el rey? si/no: ");
            respuesta = rey.next();
        }
        while (respuesta.matches("si")) ;
        if (respuesta.matches("no")) {
            ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE DAMA

    public static void dama() {
        char inicial = 'D';
        do {
            Scanner dama = new Scanner(System.in);
            try {
                System.out.println("Ahora dime su posicion inicial.");
                System.out.println("Dime una letra: ");
                letra = dama.nextLine();
                System.out.println("Dime un numero: ");
                fila = dama.nextInt();
                letras();
                planilla = inicial + tablero[fila][columna];
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                    System.out.println("Error el formato debe de ser de a-h y 1-8");
                } else {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.println("La dama puede puede moverse a: ");
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
                    for (int i = fila + 1; i < tablero.length; i++) {
                        System.out.print(tablero[i][(columna + i) - fila] + " ");
                    }
                    for (int i = columna - 1; i >= 1; i--) {
                        System.out.print(tablero[(columna - i) + fila][(i)] + " ");
                    }
                    for (int i = fila - 1; i >= 1; i--) {
                        System.out.print(tablero[i][(columna - i) + fila] + " ");
                    }
                    for (int i = fila - 1; i >= 1; i--) {
                        System.out.print(tablero[i][(columna + i) - fila] + " ");
                    }
                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception h) {
                System.out.println("Error la dama no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover la dama? si/no: ");
            respuesta = dama.next();
        }
        while (respuesta.matches("si")) ;
        if (respuesta.matches("no")) {
            ajedrez.main(null);
        }
    }

}