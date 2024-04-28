public class LibroComedia extends Libro {

    private String tipoHumor;

    public LibroComedia() {

    }

    public LibroComedia(String nombre, String autor, int nPaginas, String ISBN, String tipoHumor) {
        super(nombre,autor, nPaginas, ISBN);
        this.tipoHumor = tipoHumor;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("tipoHumor = " + tipoHumor);
    }

    @Override
    public String toString() {
        return "LibroComedia{" +
                "tipoHumor='" + tipoHumor + '\'' +
                '}';
    }

    public String getTipoHumor() {
        return tipoHumor;
    }

    public void setTipoHumor(String tipoHumor) {
        this.tipoHumor = tipoHumor;
    }
}
