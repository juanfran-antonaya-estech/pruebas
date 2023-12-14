package bruteforcer;

public class Main {
    public static void main(String[] args) {
        String texto = "Infinito Gold demandó a Costa Rica por un monto que inicialmente se fijó en 94 millones de dólares pero que fue elevado finalmente hasta los 400 millones, sobre la base del Acuerdo entre el Gobierno de la República de Costa Rica y el Gobierno de Canadá para la Promoción y Protección Recíproca de Inversiones, suscrito el 18 de marzo de 1998 y que entró en vigor el 29 de septiembre de 1999; y del Convenio sobre Arreglo de Diferencias Relativas a Inversiones entre Estados y Nacionales de Otros Estados, el cual entró en vigor el 14 de octubre de 1966.";
        String[] contrasenias = {"Hola Mundo.","Te saludo","Desde la nave espacial"};

        BruteForcer bf = new BruteForcer();
        EfectoMatrix.imprimirEfectoMatrix(texto);
    }
}
