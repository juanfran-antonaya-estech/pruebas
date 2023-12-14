package bruteforcer;

public class EfectoMatrix {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-=_+[]{}|;':,.<>?/";
    private static final int DELAY = 50;
    private static final int TRANSITION_DELAY = 500;

    public static void imprimirEfectoMatrix(String mensaje) {
        imprimirTransicion(mensaje);
        imprimirMensajeConEfecto(mensaje);
    }

    private static void imprimirTransicion(String mensaje) {
        for (int i = 0; i < mensaje.length(); i++) {
            String transicion = generarTransicion(mensaje, i);
            System.out.printf("%s", transicion);
            pausa(DELAY);
            borrarCaracteres(transicion.length());
        }
        pausa(TRANSITION_DELAY);
    }

    private static String generarTransicion(String mensaje, int indice) {
        StringBuilder transicion = new StringBuilder();
        for (int i = 0; i < mensaje.length(); i++) {
            transicion.append((i < indice) ? mensaje.charAt(i) : obtenerCaracterAleatorio());
        }
        return transicion.toString();
    }

    private static void imprimirMensajeConEfecto(String mensaje) {
        String[] palabras = mensaje.split("\\s+");
        for (String palabra : palabras) {
            System.out.println(palabra);
            pausa(DELAY * palabra.length());
            limpiarPantalla();
        }
    }

    private static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void borrarCaracteres(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print("\b");
        }
    }

    private static char obtenerCaracterAleatorio() {
        return CARACTERES.charAt((int) (Math.random() * CARACTERES.length()));
    }

    private static void limpiarPantalla() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}