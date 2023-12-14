package bruteforcer;

import java.io.IOException;
import java.util.Random;

public class BruteForcer {

    public void adivinar(String secret) {
        String text = "";
        for (int i = 0; i < secret.length(); i++) {
            for (int j = 0; j < getCharint((char)176); j++) {
                char aux = getCharindexed((char)32, j);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                limpial();
                System.out.println(text + aux);
                if (secret.charAt(i) == aux) {
                    text += "" + aux;
                    break;
                }
            }
        }
    }

    public void adivinarTodos(String secret) {
        char[] chars = new char[secret.length()];
        char[] pull = new char[secret.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)32;
        }
        for (int i = 32; i < getCharint((char)176); i++) {
            for (int j = 0; j < chars.length; j++) {
                chars[j] = (char)i;
                if (chars[j] == secret.charAt(j)) {
                    pull[j] = chars[j];
                }
            }
            String text = "";
            for (int j = 0; j < chars.length; j++) {
                if (pull[j] != (char)0) {
                    text += "" + pull[j];
                } else {
                    text += chars[j];
                }
            }
            if (text.equals(secret)) {
                System.out.println(secret);
                break;
            } else {
                System.out.println(text);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            limpial();
        }
    }

    private void limpial() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private char getCharindexed(char c, int x) {
        return (char) ((int) c + x);
    }

    private int getCharint(char c) {
        return c;
    }

    public void adivinarTodosMatrix(String secret) {
        char[] chars = new char[secret.length()];
        char[] pull = new char[secret.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)32;
        }
        while (true) {
            for (int j = 0; j < chars.length; j++) {
                chars[j] = (char)((Math.random() * (176 - 32)) + 32);
                if (chars[j] == secret.charAt(j)) {
                    pull[j] = chars[j];
                }
            }
            String text = "";
            for (int j = 0; j < chars.length; j++) {
                if (pull[j] != (char)0) {
                    text += "" + pull[j];
                } else {
                    text += chars[j];
                }
            }
            if (text.equals(secret)) {
                System.out.println(secret);
                break;
            } else {
                System.out.println(text);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            limpial();
            
        }

    }
    public static void imprimirEfectoMatrix(String mensaje, int delay) {
        // Imprimir caracteres aleatorios y transición al mensaje original
        for (int i = 0; i < mensaje.length(); i++) {
            StringBuilder linea = new StringBuilder();
            for (int j = 0; j < mensaje.length(); j++) {
                if (j < i) {
                    linea.append(mensaje.charAt(j));
                } else {
                    linea.append(obtenerCaracterAleatorio());
                }
            }
            System.out.print(linea);
            pausa(delay);
            borrarCaracteres(linea.length());
        }

        // Imprimir el mensaje original completo
        pausa(500); // Pausa antes de imprimir el mensaje original
        System.out.print(mensaje);
    }

    public static void pausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void borrarCaracteres(int cantidad) {
        // Retroceder la cantidad de caracteres especificada
        for (int i = 0; i < cantidad; i++) {
            System.out.print("\b");
        }
    }

    public static char obtenerCaracterAleatorio() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-=_+[]{}|;':,.<>?/";
        return caracteres.charAt((int) (Math.random() * caracteres.length()));
    }
}
