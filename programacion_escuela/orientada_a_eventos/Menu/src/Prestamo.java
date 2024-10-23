public class Prestamo {
    private float fechaPrestamo,fechaEntrega;
    private Alumnos alumno;
    private Libro libro;

    public Prestamo(float fechaPrestamo, float fechaEntrega, Alumnos alumno, Libro libro) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.alumno = alumno;
        this.libro = libro;
    }

    public float getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(float fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public float getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(float fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
