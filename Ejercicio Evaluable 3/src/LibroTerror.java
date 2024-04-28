public class LibroTerror extends Libro {

    private int calificacion;

    public LibroTerror() {

    }

    public LibroTerror(String nombre, String autor, int nPaginas, String ISBN, int calificacion) {
        super(nombre,autor, nPaginas, ISBN);
        this.calificacion = calificacion;
    }
    @Override
    public void mostrarDatos() {
       super.mostrarDatos();
        System.out.println("calificacion = " + calificacion);
    }

    @Override
    public String toString() {
        return "LibroTerror{" +
                "calificacion=" + calificacion +
                '}';
    }


    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
