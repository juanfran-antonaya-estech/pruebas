package buscaminas;

// InterfazUsuario.java
import java.util.Scanner;

public class InterfazUsuario {
    private Scanner scanner;

    public InterfazUsuario() {
        scanner = new Scanner(System.in);
    }

    // Método para obtener una entrada de tipo entero del usuario
    public int obtenerEntrada(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("¡Error! Ingresa un número entero válido.");
            System.out.print(mensaje);
            scanner.next(); // Limpiar el buffer del escáner
        }
        return scanner.nextInt();
    }

    // Método para obtener una entrada de tipo cadena del usuario
    public String obtenerEntradaCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    // Método para cerrar el escáner cuando no se necesite más
    public void cerrarScanner() {
        scanner.close();
    }
}