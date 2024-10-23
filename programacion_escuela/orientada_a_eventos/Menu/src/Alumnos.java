public class Alumnos  {
    private String nombre;
    private int matricula,dias;
    private boolean entregado;

    public Alumnos(String nombre, int matricula, int dias, boolean entregado) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.dias = dias;
        this.entregado = entregado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}
