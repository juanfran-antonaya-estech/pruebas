import java.util.Scanner;

public class CalcularDNI {
    public static void main(String[] args) throws Exception {

        int huevo = 26583122;
        DNI me = new DNI(huevo);
        System.out.println(me.complete);

        System.out.println("Introduce cuantos DNIs aleatorios quieres generar");
        Scanner t = new Scanner(System.in);
        int x = t.nextInt();

        for (int i = 0; i < x; i++) {
            DNI dni = new DNI(DNI.generarnumero());
            System.out.println(dni.complete);
        }

    }
}
