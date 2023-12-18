package buscaminas;

// Tablero.java
public class Tablero {
    private char[][] tablero;
    private char[][] tableroVisible;

    // Constructor para inicializar el tablero y el tablero visible
    public Tablero(int tamano) {
        tablero = new char[tamano][tamano];
        tableroVisible = new char[tamano][tamano];
        inicializarTablero();
    }

    // Inicializa el tablero y el tablero visible con espacios y almohadillas respectivamente
    private void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = ' ';
                tableroVisible[i][j] = '#';
            }
        }
    }

    // Obtiene el tablero actual
    public char[][] getTablero() {
        return tablero;
    }

    // Obtiene el tablero visible actual
    public char[][] getTableroVisible() {
        return tableroVisible;
    }

    // Coloca las minas en el tablero, evitando la ubicación inicial
    public void colocarMinas(int filaInicial, int columnaInicial, int numeroMinas) {
        // Lógica para colocar minas
        int minasColocadas = 0;
        while (minasColocadas < numeroMinas) {
            int fila = (int) (Math.random() * tablero.length);
            int columna = (int) (Math.random() * tablero[0].length);

            if (fila != filaInicial || columna != columnaInicial) {
                if (tablero[fila][columna] != 'X') {
                    tablero[fila][columna] = 'X';
                    minasColocadas++;
                }
            }
        }
    }

    // Cuenta el número de minas circundantes y actualiza el tablero con esos números
    public void contarMinasCircundantes() {
        // Lógica para contar minas circundantes
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != 'X') {
                    int minasCircundantes = contarMinasAlrededor(i, j);
                    tablero[i][j] = Character.forDigit(minasCircundantes, 10);
                }
            }
        }
    }

    // Cuenta el número de minas alrededor de una celda específica
    private int contarMinasAlrededor(int fila, int columna) {
        int minasCircundantes = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaVecina = fila + i;
                int columnaVecina = columna + j;

                if (filaVecina >= 0 && filaVecina < tablero.length && columnaVecina >= 0 && columnaVecina < tablero[0].length) {
                    if (tablero[filaVecina][columnaVecina] == 'X') {
                        minasCircundantes++;
                    }
                }
            }
        }
        return minasCircundantes;
    }

    // Revela celdas recursivamente, si la celda tiene 0 minas circundantes
    public void revelarCeldas(int fila, int columna) {
        if (tableroVisible[fila][columna] != '#') {
            return;
        }

        tableroVisible[fila][columna] = tablero[fila][columna];

        if (tablero[fila][columna] == '0') {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int filaVecina = fila + i;
                    int columnaVecina = columna + j;

                    if (filaVecina >= 0 && filaVecina < tablero.length && columnaVecina >= 0 && columnaVecina < tablero[0].length) {
                        revelarCeldas(filaVecina, columnaVecina);
                    }
                }
            }
        }
    }
}
