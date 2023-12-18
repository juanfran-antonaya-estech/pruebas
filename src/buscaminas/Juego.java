package buscaminas;

// Juego.java
// Juego.java
public class Juego {
    private Tablero tablero;

    // Constructor de la clase Juego
    public Juego(int tamano) {
        tablero = new Tablero(tamano);
    }

    // Inicia el juego colocando minas, contando las minas circundantes y revelando celdas.
    public void iniciarJuego(int filaInicial, int columnaInicial, int numeroMinas) {
        tablero.colocarMinas(filaInicial, columnaInicial, numeroMinas);
        tablero.contarMinasCircundantes();
        tablero.revelarCeldas(filaInicial, columnaInicial);
    }

    // Realiza una jugada en la posición especificada por el jugador.
    public void realizarJugada(int fila, int columna) {
        char[][] tableroVisible = tablero.getTableroVisible();
        char contenidoCasilla = tablero.getTablero()[fila][columna];

        // Verificar si la casilla ya ha sido revelada
        if (tableroVisible[fila][columna] != '#') {
            System.out.println("Esta casilla ya ha sido revelada. Elige otra.");
            return;
        }

        // Verificar si la casilla contiene una mina
        if (contenidoCasilla == 'X') {
            System.out.println("¡Has encontrado una mina! Juego terminado.");
            System.exit(0); // Termina el programa ya que el juego ha terminado
        } else {
            // Mostrar contenido de la casilla
            tableroVisible[fila][columna] = contenidoCasilla;

            // Verificar si la casilla revelada es un cero, revelar casillas adyacentes si es el caso
            if (contenidoCasilla == '0') {
                tablero.revelarCeldas(fila, columna);
            }
        }
    }

    // Verifica si el jugador ha ganado el juego.
    public boolean verificarVictoria() {
        char[][] tableroVisible = tablero.getTableroVisible();
        for (int i = 0; i < tableroVisible.length; i++) {
            for (int j = 0; j < tableroVisible[0].length; j++) {
                if (tableroVisible[i][j] == '#') {
                    return false; // Todavía hay casillas sin descubrir
                }
            }
        }
        System.out.println("¡Felicidades! Has descubierto todas las casillas seguras. Ganaste.");
        System.exit(0); // Termina el programa ya que el juego ha terminado
        return true; // Este punto nunca se alcanzará, pero se coloca para que el compilador no se queje
    }

    // Devuelve el tablero visible actual.
    public Tablero getTableroVisible() {
        return tablero;
    }
}
