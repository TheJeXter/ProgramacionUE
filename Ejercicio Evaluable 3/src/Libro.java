public abstract class Libro {

    private String nombre;
    private String autor;
    private int nPaginas;
    private String isbn;

    public Libro() {

    }

    public Libro(String nombre, String autor, int nPaginas, String isbn) {
        this.nombre = nombre;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.isbn = isbn;

    }

    public void mostrarDatos() {
        System.out.println("autor = " + autor);
        System.out.println("nPaginas = " + nPaginas);
        System.out.println("isbn = " + isbn);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", nPaginas=" + nPaginas +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getNombre(){
        return this.nombre;
    }
}
