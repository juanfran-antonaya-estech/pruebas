package clasesAbstractas;

public abstract class Persona {

    protected String nombre, apellidos;

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public void imprimir() {
        System.out.println(nombre +" "+ apellidos);
    }

    public abstract void calcularSalario(double pluses);
    
}
