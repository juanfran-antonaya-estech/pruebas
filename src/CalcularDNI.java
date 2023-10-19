public class CalcularDNI {
    public static void main(String[] args) throws Exception {

        int huevo = 26583122;
        char caracteres[] = {
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

        System.out.println(huevo + "" + caracteres[huevo % 23]);

    }
}
