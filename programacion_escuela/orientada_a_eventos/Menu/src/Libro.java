public class Libro {
    private String nombre;
    private int Publicacion;
    private boolean disponible;
    private String genero;

    public Libro(String genero, String nombre, int Publicacion, boolean disponible) {
        this.genero = genero;
        this.nombre = nombre;
        this.Publicacion = Publicacion;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoPublicacion() {
        return Publicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.Publicacion = Publicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
