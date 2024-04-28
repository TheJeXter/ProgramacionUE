import java.util.ArrayList;
import java.util.List;

public class LibroPoliciaca extends Libro {

    private String trama;
    private int personajes;

    public LibroPoliciaca() {

    }

    public LibroPoliciaca(String nombre, String autor, int nPaginas, String isbn, String trama, int personajes) {
        super(nombre, autor, nPaginas, isbn);
        this.trama = trama;
        this.personajes = personajes;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("trama = " + trama);
        System.out.println("personajes = " + personajes);
    }

    @Override
    public String toString() {
        return "LibroPoliciaca{" +
                "trama='" + trama + '\'' +
                ", personajes=" + personajes +
                '}';
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public int getPersonajes() {
        return personajes;
    }

    public void setPersonajes(int personajes) {
        this.personajes = personajes;
    }
}
