public class LibroEnsayo extends Libro {

    private String epoca;

    public LibroEnsayo() {

    }

    public LibroEnsayo(String nombre, String autor, int nPaginas, String isbn, String epoca) {
        super(nombre,autor, nPaginas, isbn);
        this.epoca = epoca;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("epoca = " + epoca);
    }

    @Override
    public String toString() {
        return "LibroEnsayo{" +
                "epoca='" + epoca + '\'' +
                '}';
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

}
