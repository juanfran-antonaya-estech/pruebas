package buscaminas;
// Buscaminas.java
// Buscaminas.java
public class Buscaminas {
    public static void main(String[] args) {
        InterfazUsuario interfaz = new InterfazUsuario();
        int tamano = 5; // Puedes ajustar el tamaño según sea necesario
        Juego juego = new Juego(tamano);

        int filaInicial = interfaz.obtenerEntrada("Ingresa fila (0-" + (tamano - 1) + "): ");
        int columnaInicial = interfaz.obtenerEntrada("Ingresa columna (0-" + (tamano - 1) + "): ");
        int numeroMinas = 5; // Puedes ajustar el número de minas según sea necesario

        if (filaInicial < 0 || filaInicial >= tamano || columnaInicial < 0 || columnaInicial >= tamano) {
            System.out.println("¡Coordenadas fuera de rango! Juego terminado.");
            interfaz.cerrarScanner();
            return;
        }

        juego.iniciarJuego(filaInicial, columnaInicial, numeroMinas);

        while (true) {
            // Imprimir tablero visible
            char[][] tableroVisible = juego.getTableroVisible().getTableroVisible();
            for (int i = 0; i < tableroVisible.length; i++) {
                for (int j = 0; j < tableroVisible[0].length; j++) {
                    System.out.print(tableroVisible[i][j] + " ");
                }
                System.out.println();
            }

            // Obtener jugada del usuario
            int filaJugada = interfaz.obtenerEntrada("Ingresa fila para tu jugada (0-" + (tamano - 1) + "): ");
            int columnaJugada = interfaz.obtenerEntrada("Ingresa columna para tu jugada (0-" + (tamano - 1) + "): ");

            // Realizar jugada
            juego.realizarJugada(filaJugada, columnaJugada);

            // Verificar victoria
            if (juego.verificarVictoria()) {
                interfaz.cerrarScanner();
                break;
            }
        }
    }
}