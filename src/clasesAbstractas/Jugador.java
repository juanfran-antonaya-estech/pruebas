package clasesAbstractas;

public class Jugador extends Persona {

    public Jugador(String nombre, String apellidos) {
        super(nombre, apellidos);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void calcularSalario(double pluses) {
        double salario = 3000 + pluses;
    }
    
}
