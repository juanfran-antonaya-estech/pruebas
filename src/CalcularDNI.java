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

        System.out.println("Quieres intentar sacar x cifras de un DNI? 1 si, 2 no");
        boolean decision = t.nextInt() == 1;

        if (decision) {
            System.out.println("Escribe la cantidad de cifras que quieres encontrar:");
            x = t.nextInt();
            x = (int) Math.pow(10, x);
            int i = 0;
            while(true){
                DNI random = new DNI(DNI.generarnumero());
                if (random.numero < x) {
                    System.out.println("Intentos: " + i);
                    System.out.println("DNI: " + random.complete);
                    break;
                }
                i++;
            }

        }

        t.close();
    }
}
