import java.util.Scanner;
public class Ajedrez {

    // ------------- VARIABLES PUBLIC ------------ //

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
    public static String letra;
    public static String pieza;
    public static String respuesta;
    public static String planilla;
    public static int fila;
    public static int columna;
    public static int fila_copy;

    // --------- MÉTODOS --------- //

    // --> MÉTODO DE SELECCIÓN/ASIGNACIÓN DE LETRA

    public static void letras() {
        columna=0; //Inicializamos la variable columna para reiniciar la letra y que no coja la letra anterior en caso de hacer el programa bien.//
        //Asignamos con un switch case las letras y los valores de la columna//
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

    // --> MÉTODO DE ELEGIR LA POSICION EN EL TABLERO

    public static void posicion() {
        //Preguntamos por la letra y el numero y llamamos a la funcion de las letras para asignar el valor a la columna.//
        Scanner sc = new Scanner(System.in);
        System.out.println("Ahora dime su posicion inicial.");
        System.out.println("Dime una letra valida en minuscula: ");
        letra = sc.nextLine();
        System.out.println("Dime un numero valido: ");
        fila = sc.nextInt();
        letras();
    }

    // --> MÉTODO DE ASIGNACIÓN DE TABLERO - PARTE BLANCA

    public static void tableroblancas() {
        //Imprimimos el tablero desde el punto de vista del jugador de las piezas blancas.//
        //Hacemos que el tablero empiece en el indice 1 para que las operaciones con las piezas sean mas intuitivas.//
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
        //Asignamos con expresiones regulares las iniciales de las piezas blancas y llamamos a la funcion de cada pieza, si la pieza elegida no es valida se sale del programa.//
        System.out.println("Elige que pieza quieres usar: P=Peon, C=Caballo, A=Alfil, T=Torre, D=Dama, R=Rey ");
        Scanner piezas = new Scanner(System.in);
        pieza = piezas.nextLine();
        if (pieza.matches("[Pp]")) {
            System.out.println("Has elegido el Peon.");
            peonblanco();
        }
        else if (pieza.matches("[Cc]")) {
            System.out.println("Has elegido el Caballo.");
            caballo();
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
        //Algoritmo del peon: si esta en la fila 1, 8 o pone menos que 1 y mas que 8, dará mensaje de error ya que el peon no puede estar en esas posiciones//
        //Si el peon esta en la septima fila solo se movera una posicion hacia adelante (tablerotablero[fila + 1][columna])//
        //Si el peon esta en la fila 2-6 tendrá 2 movimientos (tablerotablero[fila + 1][columna]),(tablerotablero[fila + 2][columna])//

        char inicial = 'P'; //Inicial que tendrá el peon para la planilla.//
        Scanner peon = new Scanner(System.in);
        do {
            try {
                posicion();//Llamamos a la funcion posicion para preguntar en que posicion esta el peon.//
                planilla = inicial + tablero[fila][columna]; //Variable para la planilla: La inicial + la posicion dada por el usuario.//
                if (fila <= 1 || fila >= 8) { //Comprobamos la posicion del peon y si está mal damos mensaje de error//.
                    System.out.println("Error el peon no puede estar en esa posicion.");
                }
                else {
                    if (columna < 1 || columna > 8) {
                        System.out.println("Error el peon no puede estar en esa posicion.");
                    }
                    else if (fila < 7) {
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
            }
            catch (Exception b) {
                System.out.println("Error el peon no puede estar en esa posicion.");
            }
            //Preguntamos de nuevo al usuario si quiere volver a mover el peon, y seguira preguntando hasta que ponga exactamente "si" o "no".//
            System.out.print("¿Quieres volver a mover el peon? si/no: ");
            respuesta = peon.next();
            while (!respuesta.matches("si|no")) {
                System.out.print("No has puesto si o no");
                System.out.print('\n');
                System.out.print("¿Quieres volver a mover el peon? si/no: ");
                respuesta = peon.next();
            }
        }
        while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            Ajedrez.main(null); //Llamamos a la funcion main para preguntar de nuevo por el tablero que quiera.
        }
    }

    // --> MÉTODO DE SELECCIÓN/ASGINACIÓN DE TABLERO - PARTE NEGRA

    public static void tableronegras() {
        //Imprimimos el tablero desde el punto de vista del jugador de las piezas negras.//
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
        //Asignamos con expresiones regulares las iniciales de las piezas negras y llamamos a la funcion de cada pieza, si la pieza elegida no es valida se sale del programa.//
        System.out.println("Elige que pieza quieres usar: P=Peon, C=Caballo, A=Alfil, T=Torre, D=Dama, R=Rey ");
        Scanner piezas = new Scanner(System.in);
        pieza = piezas.nextLine();
        if (pieza.matches("[Pp]")) {
            System.out.println("Has elegido el Peon.");
            peonnegro();
        } else if (pieza.matches("[Cc]")) {
            System.out.println("Has elegido el Caballo.");
            caballo();
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
            Ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE PEÓN - NEGRO

    public static void peonnegro() {
        //Algoritmo del peon: si esta en la fila 1, 8 o pone menos que 1 y mas que 8, dará mensaje de error ya que el peon no puede estar en esas posiciones//
        //Si el peon esta en la segunda fila solo se movera una posicion hacia adelante (tablerotablero[fila - 1][columna])//
        //Si el peon esta en la fila 7-3 tendrá 2 movimientos (tablerotablero[fila - 1][columna]),(tablerotablero[fila - 2][columna])//

        char inicial = 'P'; //Inicial que tendrá el peon para la planilla.//
        do {
            Scanner peon = new Scanner(System.in);
            try {
                posicion(); //Llamamos a la funcion posicion para preguntar en que posicion esta el peon.//
                planilla = inicial + tablero[fila][columna]; //Variable para la planilla: La inicial + la posicion dada por el usuario.//
                if (fila <= 1 || fila >= 8 || columna < 1 || columna > 8) { //Comprobamos la posicion del peon y si está mal damos mensaje de error//.
                    System.out.println("Error el peon no puede estar en esa posicion.");
                } else if (fila == 2) {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.print("El peon puede moverse a: ");
                    System.out.print(tablero[fila - 1][columna] + " ");
                    System.out.print('\n');
                    System.out.println("La planilla actual es: " + planilla);
                } else {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.print("El peon negro puede moverse a: ");
                    System.out.print(tablero[fila - 1][columna] + " ");
                    System.out.print(tablero[fila - 2][columna] + " ");
                    System.out.print('\n');
                    System.out.println("La planilla actual es: " + planilla);
                }
            } catch (Exception c) {
                System.out.println("Error el peon no puede estar en esa posicion.");
            }
            //Preguntamos de nuevo al usuario si quiere volver a mover el peon, y seguira preguntando hasta que ponga exactamente "si" o "no".//
            System.out.print("¿Quieres volver a mover el peon? si/no: ");
            respuesta = peon.next();
            while (!respuesta.matches("si|no")) {
                System.out.print("No has puesto si o no");
                System.out.print('\n');
                System.out.print("¿Quieres volver a mover el peon? si/no: ");
                respuesta = peon.next();
            }
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            Ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE TORRE

    public static void torre() {
        //Algoritmo de la torre.//
        char inicial = 'T'; //Inicial que tendrá la torre para la planilla.//
        Scanner torre = new Scanner(System.in);
        do {
            try {
                posicion(); //Llamamos a la funcion posicion para preguntar en que posicion esta la torre.//
                planilla = inicial + tablero[fila][columna]; //Variable para la planilla: La inicial + la posicion dada por el usuario.//
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) { //Comprobamos la posicion de la torre y si está mal damos mensaje de error//.
                    System.out.println("Error la torre no puede estar en esa posicion.");
                } else {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.print("La torre puede moverse a: ");
                    for (int i = fila + 1; i < tablero.length; i++) { //Recorremos el tablero y le hacemos fila + 1 para que empiece por la siguiente posicion, y saque todas las posiciones hacia la derecha.//
                        System.out.print(tablero[i][columna] + " ");
                    }
                    for (int j = columna + 1; j < tablero.length; j++) { //Recorremos el tablero y le hacemos columna + 1 para que empiece por la siguiente posicion, y saque todas las posiciones hacia arriba.//
                        System.out.print(tablero[fila][j] + " ");
                    }
                    for (int i = fila - 1; i >= 1; i--) { //Recorremos el tablero y le hacemos fila - 1 para que empiece por la siguiente posicion, y saque todas las posiciones hacia abajo.//
                        System.out.print(tablero[i][columna] + " ");
                    }
                    for (int j = columna - 1; j >= 1; j--) { //Recorremos el tablero y le hacemos columna - 1 para que empiece por la siguiente posicion, y saque todas las posiciones hacia la izquierda.//
                        System.out.print(tablero[fila][j] + " ");
                    }
                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception d) {
                System.out.println("Error la torre no puede estar en esa posicion.");
            }
            //Preguntamos de nuevo al usuario si quiere volver a mover la torre, y seguira preguntando hasta que ponga exactamente "si" o "no".//
            System.out.print("¿Quieres volver a mover la torre? si/no: ");
            respuesta = torre.next();
            while (!respuesta.matches("si|no")) {
                System.out.print("No has puesto si o no");
                System.out.print('\n');
                System.out.print("¿Quieres volver a mover la torre? si/no: ");
                respuesta = torre.next();
            }
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            Ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE ALFIL

    public static void alfil() {
        //Algoritmo del Alfil.//

        char inicial = 'A'; //Inicial que tendrá el Alfil para la planilla.//
        Scanner alfil = new Scanner(System.in);
        do {
            try {
                posicion(); //Llamamos a la funcion posicion para preguntar en que posicion esta el Alfil.//
                planilla = inicial + tablero[fila][columna]; //Variable para la planilla: La inicial + la posicion dada por el usuario.//
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) { //Comprobamos la posicion del Alfil y si está mal damos mensaje de error//.
                    System.out.println("Error el alfil no puede estar en esa posicion.");
                }
                else {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.print("El alfil puede moverse a: ");
                    try {
                        for (int i = fila + 1; i < tablero.length; i++) { //Recorremos el tablero y le hacemos fila + 1//
                            System.out.print(tablero[i][(columna + i) - fila] + " "); //Con este algoritmo la fila y la columna siempre van a ser +1 cada una.//
                        }
                    } catch (Exception error2) {
                        System.out.print("");
                    }
                    try {
                        for (int i = columna - 1; i >= 1; i--) { //Hacemos columna - 1 hasta que la columna sea 1//
                            System.out.print(tablero[(columna - i) + fila][(i)] + " "); //Con este algoritmo la fila y la columna siempre van a ser -1 cada una.//
                        }
                    } catch (Exception error2) {
                        System.out.print("");
                    }
                    try {
                        for (int i = fila - 1; i >= 1; i--) { //Hacemos fila - 1 hasta que la fila sea 1//
                            System.out.print(tablero[i][(columna - i) + fila] + " "); //Con este algoritmo hacemos columna + 1 y fila - 1.//
                        }
                    } catch (Exception error2) {
                        System.out.print("");
                    }
                    try {
                        for (int i = columna - 1; i >= 1; i--) { //Hacemos columna - 1 hasta que la fila sea 1//
                            System.out.print(tablero[(fila + i) - columna][i] + " "); //Con este algoritmo hacemos fila - 1 y columna - 1.//
                        }
                    } catch (Exception error2) {
                        System.out.print("");
                    }
                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception error2) {
                System.out.println("Error el alfil no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover el alfil? si/no: ");
            respuesta = alfil.next();
            while (!respuesta.matches("si|no")) {
                System.out.print("No has puesto si o no");
                System.out.print('\n');
                System.out.print("¿Quieres volver a mover el alfil? si/no: ");
                respuesta = alfil.next();
            }
        } while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            Ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE CABALLO

    public static void caballo() {
        char inicial = 'C';
        do {
            Scanner caballo = new Scanner(System.in);
            try {
                System.out.println("Ahora dime su posicion inicial.");
                System.out.println("Dime una letra: ");
                letra = caballo.nextLine();
                System.out.println("Dime un numero: ");
                fila = caballo.nextInt();
                fila_copy = fila;
                letras();
                planilla = inicial + tablero[fila][columna];

                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                    System.out.println("Error el caballo no puede estar en esa posicion.");
                } else {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.println("El caballo puede puede moverse a: ");

                    // ----- MOVIMIENTO 1 ---- // (x=x+1; y=y+2)
                    try {
                        fila += 2;
                        columna += 1;
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    // ----- MOVIMIENTO 2 ---- // (x=x+2; y=y+1)
                    try {
                        fila = fila_copy;
                        fila += 1;
                        columna += 1; // Las columnas con cada movimiento tendrán un desfase de -1 on respecto a su anterior valor del try catch
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    // ----- MOVIMIENTO 3 ---- // (x=x+2; y=y-1)
                    try {
                        fila = fila_copy;
                        fila -= 1;
                        //columna += 0; // Las columnas con cada movimiento tendrán un desfase de -1 on respecto a su anterior valor del try catch
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    // ----- MOVIMIENTO 4 ---- // (x=x+1; y=y-2)
                    try {
                        fila = fila_copy;
                        fila -= 2;
                        columna += -1; // Las columnas con cada movimiento tendrán un desfase de -1 on respecto a su anterior valor del try catch
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    // ----- MOVIMIENTO 5 ---- // (x=x-1; y=y-2)
                    try {
                        fila = fila_copy;
                        fila -= 2;
                        columna += -2; // Las columnas con cada movimiento tendrán un desfase de -1 on respecto a su anterior valor del try catch
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    // ----- MOVIMIENTO 6 ---- // (x=x-2; y=y-1)
                    try {
                        fila = fila_copy;
                        fila -= 1;
                        columna += -1; // Las columnas con cada movimiento tendrán un desfase de +1 con respecto a su anterior valor del try catch
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    // ----- MOVIMIENTO 7 ---- // (x=x-2; y=y+1)
                    try {
                        fila = fila_copy;
                        fila += 1;
                        //columna += 0; // Las columnas con cada movimiento tendrán un desfase de +1 on respecto a su anterior valor del try catch
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    // ----- MOVIMIENTO 8 ---- // (x=x-1; y=y+2)
                    try {
                        fila = fila_copy;
                        fila += 2;
                        columna += 1; // Las columnas con cada movimiento tendrán un desfase de +1 on respecto a su anterior valor del try catch
                        System.out.print(tablero[fila][columna] + " ");
                    } catch (Exception error) {
                        System.out.print("");
                    }

                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception g) {
                System.out.println("Error el caballo no puede estar en esa posicion.");
            }
            System.out.print('\n');
            System.out.print("¿Quieres volver a mover el caballo? si/no: ");
            respuesta = caballo.next();
            while (!respuesta.matches("si|no")) {
                System.out.print("No has puesto si o no");
                System.out.print('\n');
                System.out.print("¿Quieres volver a mover el caballo? si/no: ");
                respuesta = caballo.next();
            }
        }
        while (respuesta.matches("si")) ;
        if (respuesta.matches("no")) {
            Ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DEL REY

    public static void rey() {
        char inicial = 'R';
        Scanner rey = new Scanner(System.in);
        do {
            try {
                posicion();
                planilla = inicial + tablero[fila][columna];
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                    System.out.println("Error el rey no puede estar en esa posicion.");
                } else {
                    System.out.println("Tu posicion actual es: " + tablero[fila][columna]);
                    System.out.println("El rey puede puede moverse a: ");
                    System.out.print(tablero[fila+1][columna] + " ");
                    System.out.print(tablero[fila-1][columna] + " ");
                    System.out.print(tablero[fila][columna+1] + " ");
                    System.out.print(tablero[fila][columna-1] + " ");
                    System.out.print(tablero[fila+1][columna+1] + " ");
                    System.out.print(tablero[fila-1][columna-1] + " ");
                    System.out.print(tablero[fila+1][columna-1] + " ");
                    System.out.print(tablero[fila-1][columna+1] + " ");

                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception g) {
                System.out.println("Error el rey no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover el rey? si/no: ");
            respuesta = rey.next();
            while (!respuesta.matches("si|no")) {
                System.out.print("No has puesto si o no");
                System.out.print('\n');
                System.out.print("¿Quieres volver a mover el rey? si/no: ");
                respuesta = rey.next();
            }
        }
        while (respuesta.matches("si"));
        if (respuesta.matches("no")) {
            Ajedrez.main(null);
        }
    }

    // --> MÉTODO DE MOVIMIENTOS DE DAMA

    public static void dama() {
        //Algoritmo de la dama, es la combinacion de la torre y el Alfil.//
        char inicial = 'D';
        Scanner dama = new Scanner(System.in);
        do {
            try {
                posicion();
                planilla = inicial + tablero[fila][columna];
                if (fila == 0 || columna == 0 || fila > 8 || columna > 8) {
                    System.out.println("Error la dama no puede estar en esa posicion.");
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
                    try {
                        for (int i = fila + 1; i < tablero.length; i++) {
                            System.out.print(tablero[i][(columna + i) - fila] + " ");
                        }
                    } catch (Exception error3) {
                        System.out.print("");
                    }
                    try {
                        for (int i = columna - 1; i >= 1; i--) {
                            System.out.print(tablero[(columna - i) + fila][(i)] + " ");
                        }
                    } catch (Exception error3) {
                        System.out.print("");
                    }
                    try {
                        for (int i = fila - 1; i >= 1; i--) {
                            System.out.print(tablero[i][(columna - i) + fila] + " ");
                        }
                    } catch (Exception error3) {
                        System.out.print("");
                    }
                    try {
                        for (int i = columna - 1; i >= 1; i--) {
                            System.out.print(tablero[(fila + i) - columna][i] + " ");
                        }
                    } catch (Exception error3) {
                        System.out.print("");
                    }
                    System.out.print('\n');
                    System.out.println("Tu planilla actual es: " + planilla);
                }
            } catch (Exception h) {
                System.out.println("Error la dama no puede estar en esa posicion.");
            }
            System.out.print("¿Quieres volver a mover la dama? si/no: ");
            respuesta = dama.next();
            while (!respuesta.matches("si|no")) {
                System.out.print("No has puesto si o no");
                System.out.print('\n');
                System.out.print("¿Quieres volver a mover la dama? si/no: ");
                respuesta = dama.next();
            }
        }
        while (respuesta.matches("si")) ;
        if (respuesta.matches("no")) {
            Ajedrez.main(null);
        }
    }

    // ----------------- MAIN ------------------ //

    public static void main (String[]args){
        //Con la variable eleccion le pedimos al usuario que elija una opción del menu y con el try catch volvemos a pedirle la eleccion hasta que este bien.//
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
                        tableroblancas(); //Llamamos a la funcion para imprimir el tablero de blancas//
                        eleccionpiezasblancas(); //Llamamos a la funcion eleccion de piezas para elegir la pieza que queramos//
                    }
                    break;
                    case 2:
                    {
                        tableronegras(); //Llamamos a la funcion para imprimir el tablero de blancas//
                        eleccionpiezasnegras(); //Llamamos a la funcion eleccion de piezas para elegir la pieza que queramos//
                    }
                    break;
                }
            } catch (Exception a) {
                System.out.println("Error has puesto un caracter o varios caracteres, vuelve a elegir una opcion.");
                System.out.println("Vuelve a intentarlo.");
                Ajedrez.main(null); //Llamamos a la funcion principal para poder preguntar de nuevo por las opciones en caso de ser un caracter.//
            }
        } while (eleccion < 0 || eleccion > 2); //Repetimos el menu mientras que la eleccion sea menor que 0 y mayor a 2.//
    }
}
