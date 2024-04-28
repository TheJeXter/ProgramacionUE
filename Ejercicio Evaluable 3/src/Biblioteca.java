import java.io.Serializable;
import java.util.*;

public class Biblioteca {

    private String nombre;
    private String director;

    ArrayList <Catalogo> catalogos;

    ArrayList <Libro> libros;

    private ArrayList <Libro> librosTotales;

    private String genero;
    Scanner scanner;

    public Biblioteca(){

    }

    public Biblioteca(String nombre, String director, String genero) {
        this.nombre = nombre;
        this.director = director;
        this.catalogos = null;
        this.genero = genero;
        this.libros = null;
        this.librosTotales = null;
    }

    public void meterCatalogo(Catalogo catalogo){
        this.catalogos.add(catalogo);
    }

    public void meterLibro(Libro libro){
        this.libros.add(libro);
    }

    public void meterLibrosTotales(Libro libro){
        this.librosTotales.add(libro);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList getCatalogo(){return this.catalogos;}

    public ArrayList getLibrosTotales(){return this.librosTotales;}

    public void mostrarCatalogos(){
        int count = 1;
        for (Catalogo catalocoActual:this.catalogos) {
            System.out.println(count+"."+catalocoActual.getNombre());
            count++;
        }
    }

    public void mostrarLibrosTotales(){
        int count = 1;
        for (Libro libroActual:this.librosTotales) {
            System.out.println(count+"."+libroActual.getNombre());
            count++;
        }
    }
    public void eliminarLibro(String isbn){
        for(Libro libroActual:this.libros) {
            if(libroActual.getIsbn().equals(isbn)){
                libros.remove(libroActual);
            }
        }
        for(Catalogo catalogoActual:this.catalogos) {
            catalogoActual.eliminarLibroCatalogo(isbn);
        }
    }
    public static class Catalogo implements Serializable {

        private static final long serialVersionUID = 6529685098267757690L;

        private ArrayList <Libro> libros;

        private int capacidad;

        private String nombre;

        public Catalogo() {
        }

        public Catalogo(int capacidad, String nombre) {
            this.libros = new ArrayList<>();
            this.capacidad = capacidad;
            this.nombre = nombre;
        }
        public void meterLibro(Libro libro) {
            if (libros.size() >= capacidad) {
                throw new ArrayStoreException("No hay espacio para añadir otro libro");
            }
            libros.add(libro);
        }

        public void eliminarLibroCatalogo(String isbn){
            for(Libro libroActual:libros) {
                if(libroActual.getIsbn().equals(isbn)){
                    libros.remove(libroActual);
                }
            }
        }

        public void mostrarLibros(){
            for (Libro libroActual:this.libros) {
                libroActual.mostrarDatos();
            }
        }

        public void mostrarCatalogo () {
            System.out.println("Nombre: " + nombre);
            System.out.println("Capacidad: " + capacidad);
            for (Libro libro: libros) {
                System.out.println("Libros: " + libro);

            }

        }

        @Override
        public String toString() {
            return "Catalogo{" +
                    "libros=" + libros +
                    ", capacidad=" + capacidad +
                    ", nombre='" + nombre + '\'' +
                    '}';
        }

        public Libro buscarIsbn (String isbn) {
            for (Libro libro : libros) {
                if (libro.getIsbn().equals(isbn)) {
                    return libro;
                }
            }
            throw new NoSuchElementException("No se ha encontrado ningun libro con ese ISBN");
        }


        public List<Libro> getLibros() {
            return libros;
        }

        public void setLibros(List<Libro> libros) {
            this.libros = new ArrayList<>();
        }

        public int getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }

        public String getNombre(){return this.nombre;}
    }

}
