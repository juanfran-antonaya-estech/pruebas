package textoarcoiris;

public class TextoArcoiris {
    public static void main(String[] args) {
        String texto = "MAQUINOTEEEEEEEE";

        // Imprimir el texto con una animación de colores y serpenteo
        animarColoresYSerpenteo(texto);
    }

    public static void animarColoresYSerpenteo(String texto) {
        // Dividir el texto en caracteres
        char[] caracteres = texto.toCharArray();

        // Colores ANSI para cada letra
        String[] colores = {"\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m"};

        // Variables para controlar la dirección del movimiento y el contador
        boolean haciaAbajo = true;
        int contador = 0;

        // Bucle que se repite hasta que se cancele la ejecución
        boolean ejecucion = true;
        while (ejecucion) {
            // Imprimir el texto con el color actual y el efecto de serpenteo
            for (int i = 0; i < caracteres.length; i++) {
                for (int j = 0; j < caracteres.length; j++) {
                    String color = colores[(i + j) % colores.length];
                    System.out.print(color + caracteres[j] + "\u001B[0m");
                }

                // Pausa para crear el efecto de serpenteo
                pausar(10); // Ajusta la duración de la pausa según tus preferencias
                // Retroceder para sobrescribir el texto
                for (int k = 0; k < caracteres.length; k++) {
                    System.out.print("\b \b");
                }
            }

            System.out.println(); // Línea nueva para avanzar a la siguiente línea

            // Incrementar el contador y cambiar la dirección del movimiento cada 5 iteraciones
            contador++;
            if (contador >= 5) {
                haciaAbajo = !haciaAbajo;
                contador = 0;
            }

            // Ajustar el orden de las letras para invertir la dirección
            if (haciaAbajo) {
                char ultimaLetra = caracteres[caracteres.length - 1];
                for (int l = caracteres.length - 1; l > 0; l--) {
                    caracteres[l] = caracteres[l - 1];
                }
                caracteres[0] = ultimaLetra;
            } else {
                char primeraLetra = caracteres[0];
                for (int l = 0; l < caracteres.length - 1; l++) {
                    caracteres[l] = caracteres[l + 1];
                }
                caracteres[caracteres.length - 1] = primeraLetra;
            }
        }
    }

    // Método para pausar la ejecución durante un cierto tiempo en milisegundos
    public static void pausar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            // Manejar cualquier excepción que pueda ocurrir al interrumpir la pausa
        }
    }
}
