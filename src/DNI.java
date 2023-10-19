
public class DNI {

    public String complete;
    public int numero;
    public char letra;
    private char caracteres[] = {
            'T',
            'R',
            'W',
            'A',
            'G',
            'M',
            'Y',
            'F',
            'P',
            'D',
            'X',
            'B',
            'N',
            'J',
            'Z',
            'S',
            'Q',
            'V',
            'H',
            'L',
            'C',
            'K',
            'E',
    };
    public DNI(int n) {
        this.numero = n;
        this.letra = caracteres[n % 23];
        this.complete = numero + "" + letra;
    }
    public static int generarnumero() {
        int n = 0;
        for (int i = 0; i < 8; i++) {
            double rnd = Math.random() * 10;
            int rn = (int) rnd;
            n += rn * Math.pow(10, i);
        }
        return n;
    }
}
