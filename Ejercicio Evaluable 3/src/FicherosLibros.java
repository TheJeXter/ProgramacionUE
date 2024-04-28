import java.io.*;

public class FicherosLibros {

    public void EscribirObjetoLibros() {

        ObjectOutputStream objectOutputStream = null;
        File file = new File("src/Resources/libros.obj");

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(new Biblioteca.Catalogo());
        } catch (IOException e) {
            System.out.println("Fallo en la escritura del objeto");
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el flujo");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }

        }

    }
}
