/*import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Entrada {

    public static void main(String[] args) {

        ArrayList <Libro> libros;
        libros = new ArrayList<>();

        LibroTerror terror1 = new LibroTerror("Paco Sanchez",230, "9783161484100", 7);
        libros.add(terror1);
        LibroTerror terror2 = new LibroTerror("Lara Gomez",227, "6883146484129", 8);
        libros.add(terror2);
        LibroTerror terror3 = new LibroTerror("Luis Cañada",255, "7983769434112", 6);
        libros.add(terror3);
        LibroTerror terror4 = new LibroTerror("Sofía Cano",293, "5733158416147", 9);
        libros.add(terror4);
        LibroTerror terror5 = new LibroTerror("Ludovico Ferrari",268, "8699463585889", 7);
        libros.add(terror5);

        LibroComedia comedia1 = new LibroComedia("Arturo Luengo",210, "9677861484466", "Sarcasmo");
        libros.add(comedia1);
        LibroComedia comedia2 = new LibroComedia("Sara Cuenca",187, "7853678283491", "Inteligente");
        libros.add(comedia2);
        LibroComedia comedia3 = new LibroComedia("Lina Johnson",193, "4867261282168", "Sátira");
        libros.add(comedia3);
        LibroComedia comedia4 = new LibroComedia("Domingo Gutierrez",178, "7957265437189", "Oscuro");
        libros.add(comedia4);
        LibroComedia comedia5 = new LibroComedia("Juan Jose Carrasco",195, "8662831454961", "Clasico");
        libros.add(comedia5);

        LibroEnsayo ensayo1 = new LibroEnsayo("Denzel Espinosa",223, "8817365771476", "Renacentista");
        libros.add(ensayo1);
        LibroEnsayo ensayo2 = new LibroEnsayo("Norman Lee",279, "5836115491429", "Barroca");
        libros.add(ensayo2);
        LibroEnsayo ensayo3 = new LibroEnsayo("Laura Phoenix",305, "6718365452468", "Moderna");
        libros.add(ensayo3);
        LibroEnsayo ensayo4 = new LibroEnsayo("Rodrigo Smith",314, "5677679722544", "Imperialista");
        libros.add(ensayo4);
        LibroEnsayo ensayo5 = new LibroEnsayo("Eusebio Gonzalez",297, "8732365569451", "Vanguardista");
        libros.add(ensayo5);

        LibroPoliciaca policiaca1 = new LibroPoliciaca("Jordan Greenway",234, "8817365771476", "Misterio", Collections.singletonList("Lois, Peter, Arthur"));
        libros.add(policiaca1);
        LibroPoliciaca policiaca2 = new LibroPoliciaca("Mark Evans",271, "8677965711472", "Intriga", Collections.singletonList("Sarah, George, Stewart, Jessie"));
        libros.add(policiaca2);
        LibroPoliciaca policiaca3 = new LibroPoliciaca("Shawn Frost",210, "9427165766916", "Misterio", Collections.singletonList("Nilah, John, Samuel, Jackson"));
        libros.add(policiaca3);
        LibroPoliciaca policiaca4 = new LibroPoliciaca("Jude Sharp",214, "5627359841411", "Misterio", Collections.singletonList("Jane, Ben, Guillermo"));
        libros.add(policiaca4);
        LibroPoliciaca policiaca5 = new LibroPoliciaca("Axel Blaze",198, "4215363111762", "Intriga", Collections.singletonList("Morgan, Sam, Nathan, Parker, Lloyd"));
        libros.add(policiaca5);



        Biblioteca biblioteca = null;
        Biblioteca bibliotecaTerror = null;
        Biblioteca bibliotecaComedia = null;
        Biblioteca bibliotecaEnsayo = null;
        Biblioteca bibliotecaPoliciaca = null;

        Biblioteca.Catalogo catalogo = null;
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Crear biblioteca");
            System.out.println("2. Crear catálogo");
            System.out.println("3. Agregar libros al catálogo");
            System.out.println("4. Eliminar libros al catálogo");
            System.out.println("5. Buscar un libro");
            System.out.println("6. Mostrar información de todos los libros del catálogo");
            System.out.println("7. Mostrar información de todos los libros que existen");
            System.out.println("8. Exportar todos los libros del catálogo a un fichero");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:

                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Introduce el nombre de la biblioteca: ");
                    String nombreBiblioteca = scanner.nextLine();
                    System.out.print("Introduce el nombre del director: ");
                    String directorBiblioteca = scanner.nextLine();

                    System.out.println("1. Crear una biblioteca especializada    2. Crear una biblioteca general");
                    if (scanner.nextInt() == 1) {
                        System.out.println("1. Terror   2. Comedia   3. Ensayo   4. Policiaca");
                        if (scanner.nextInt() == 1) {
                            bibliotecaTerror = new Biblioteca(nombreBiblioteca, directorBiblioteca);
                            System.out.println("Biblioteca especializada en terror creada correctamente.");
                        } else if (scanner.nextInt() == 2) {
                            bibliotecaComedia = new Biblioteca(nombreBiblioteca, directorBiblioteca);
                            System.out.println("Biblioteca especializada en comedia creada correctamente.");
                        } else if (scanner.nextInt() == 3) {
                            bibliotecaEnsayo = new Biblioteca(nombreBiblioteca, directorBiblioteca);
                            System.out.println("Biblioteca especializada en ensayos creada correctamente.");
                        } else if (scanner.nextInt() == 4) {
                            bibliotecaPoliciaca = new Biblioteca(nombreBiblioteca, directorBiblioteca);
                            System.out.println("Biblioteca especializada en policiaca creada correctamente.");
                        } else
                            throw new NoSuchElementException("Introduce una opción válida.");

                    } else if (scanner.nextInt() == 2) {
                        scanner.nextLine();
                        biblioteca = new Biblioteca(nombreBiblioteca, directorBiblioteca);
                        System.out.println("Biblioteca general creada correctamente.");
                    } else {
                        throw new NoSuchElementException("Introduce una opción válida");
                    }


                    break;

                case 2:
                    if (biblioteca != null) {
                        scanner.nextLine();
                        System.out.println("¿Cuál es el nombre de tu catálogo?");
                        String nombre = scanner.nextLine();
                        System.out.println("¿Cuál quieres que sea la capacidad de tu catálogo?");
                        int capacidad = scanner.nextInt();
                        catalogo = new Biblioteca.Catalogo(capacidad, nombre);

                        scanner.nextLine();
                        System.out.println("¿Cuántos libros quieres añadir al catálogo?");
                        int librosAMeter = scanner.nextInt();
                        scanner.nextLine();
                        if (capacidad <= librosAMeter) {
                            System.out.println("No se pueden meter más libros que la capacidad máxima del catálogo");
                        } else {
                            boolean encontrado = false;
                            for (int i = 0; i < librosAMeter; i++) {
                                System.out.println("Introduce el ISBN del libro que quieres añadir al catálogo");
                                String isbn = scanner.nextLine();
                                for (Libro librosBiblioteca : libros) {
                                    if (librosBiblioteca.getIsbn().equals(isbn)) {
                                        catalogo.meterLibro(librosBiblioteca);
                                        System.out.println("Libro añadido correctamente.");
                                        encontrado = true;
                                    }
                                }
                                if(!encontrado){
                                    System.out.println("Libro no encontrado: "+ isbn);
                                }
                            }

                        }
                        System.out.println("Catálogo creado correctamente.");
                    } else {
                        System.out.println("Primero debes crear una Biblioteca");
                    }


                    break;

                case 3:

                    scanner.nextLine();
                    String continuar = "";

                    do {
                        if (catalogo != null) {
                            scanner.nextLine(); // Limpiar buffer
                            System.out.println("¿Cuál es el ISBN del libro que quieres introducir?");
                            String isbn = scanner.nextLine();
                            for (Libro librosBiblioteca : libros)
                                if (librosBiblioteca.getIsbn().equals(scanner.nextLine())) {
                                    catalogo.meterLibro(librosBiblioteca);
                                }
                            System.out.println("Libro añadido correctamente.");
                            System.out.println("¿Quieres seguir añadiendo libros? (y/n)");
                            continuar = scanner.nextLine();

                        } else
                            throw new NoSuchElementException("Primero debes crear un catálogo.");

                    } while (continuar.equals("y"));

                    break;

                case 4:

                    scanner.nextLine();
                    if (catalogo != null) {
                        scanner.nextLine(); // Limpiar buffer
                        System.out.println("¿Cuál es el ISBN del libro que quieres sacar?");
                        String isbn = scanner.nextLine();
                        for (Libro librosBiblioteca : libros)
                            if (librosBiblioteca.getIsbn().equals(scanner.nextLine())) {
                                catalogo.quitarLibro(librosBiblioteca);
                            }
                        System.out.println("Libro eliminado correctamente");

                    } else
                        throw new NoSuchElementException("Primero debes crear un catálogo.");
                    break;

                case 5:

                    scanner.nextLine();
                    System.out.println("¿Cuál es el ISBN del libro que quieres buscar?");
                    String isbn = scanner.nextLine();
                    for (Libro librosBiblioteca : libros)
                        if (librosBiblioteca.getIsbn().equals(scanner.nextLine())) {
                            librosBiblioteca.mostrarDatos();
                        }
                    break;

                case 6:

                    if (catalogo != null) {
                        catalogo.mostrarCatalogo();
                    } else
                        System.out.println("No existe un catálogo todavía");

                    break;

                case 7:

                    System.out.println("---LIBROS DISPONIBLES---");
                    System.out.println("");
                    System.out.println("Libros de Terror: ");
                    System.out.println("");
                    System.out.println("Libro 1");
                    terror1.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 2");
                    terror2.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 3");
                    terror3.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 4");
                    terror4.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 5");
                    terror5.mostrarDatos();
                    System.out.println("");

                    System.out.println("Libros de Comedia: ");
                    System.out.println("");
                    System.out.println("Libro 1");
                    comedia1.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 2");
                    comedia2.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 3");
                    comedia3.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 4");
                    comedia4.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 5");
                    comedia5.mostrarDatos();
                    System.out.println("");

                    System.out.println("Libros de Ensayo: ");
                    System.out.println("");
                    System.out.println("Libro 1");
                    ensayo1.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 2");
                    ensayo2.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 3");
                    ensayo3.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 4");
                    ensayo4.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 5");
                    ensayo5.mostrarDatos();
                    System.out.println("");

                    System.out.println("Libros Policiacos");
                    System.out.println("");
                    System.out.println("Libro 1");
                    policiaca1.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 2");
                    policiaca2.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 3");
                    policiaca3.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 4");
                    policiaca4.mostrarDatos();
                    System.out.println("");
                    System.out.println("Libro 5");
                    policiaca5.mostrarDatos();
                    System.out.println("");

                    break;

                case 8:

                    FicherosLibros ficherosLibros = new FicherosLibros();
                    ficherosLibros.EscribirObjetoLibros();
                    break;

                case 0:

                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

} */