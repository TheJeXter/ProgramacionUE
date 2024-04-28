import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {

        int opcion = 0;

        do {

            System.out.println("\nMenú:");
            System.out.println("1. Crear biblioteca");
            System.out.println("2. Crear catálogo");
            System.out.println("3. Crear libro");
            System.out.println("4. Agregar libros");
            System.out.println("5. Eliminar libros");
            System.out.println("6. Buscar un libro");
            System.out.println("7. Mostrar información de todos los libros de un catálogo");
            System.out.println("8. Mostrar información de todos los libros que existen");
            System.out.println("9. Exportar todos los libros del catálogo a un fichero");
            System.out.println("10. Salir");
            System.out.print("Selecciona una opción: ");

            Scanner sc = new Scanner(System.in);

            int opcionElegida = sc.nextInt();
            int opcionGenero = 0;
            int bibliotecasCreadas = 1;
            int librosCreados = 1;
            ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
            ArrayList<Libro> libros = new ArrayList<>();
            ArrayList<Libro> librosinventario = null;
            Biblioteca biblioteca;
            String nombreBiblioteca;
            String nombreDirector;
            String nombreCatalogo;
            int capacidadCatalogo;
            int opcionBibliotecaElegida;
            String nombreLibro;
            String nombreAutor;
            int nPaginasLibro;
            String isbnLibro;
            int calificacionTerror;
            String tipoHumorComedia;
            int opcionGeneroLibro = 0;
            String epocaLibro;
            int personajesLibro;
            String tramaLibro = null;
            int opcionTrama;
            int opcionCatalogoElegido;
            Biblioteca.Catalogo catalogoElegido;
            int libroElegido = 0;
            int opcionMeterCatalogo;
            int opcionLibroElegido;
            String isbnLibroElegido;
            ArrayList<Libro> librosTotalesEnBiblioteca;

            switch (opcionElegida) {

                case 1:
                    sc.nextLine();
                    System.out.println("Ingrese el nombre de la biblioteca");
                    nombreBiblioteca = sc.nextLine();
                    System.out.println("Ingrese el nombre del director");
                    nombreDirector = sc.nextLine();
                    System.out.println("De que genero es la biblioteca?");
                    System.out.println("1.Terror");
                    System.out.println("2.Comedia");
                    System.out.println("3.Ensayo");
                    System.out.println("4.Policiaca");
                    System.out.println("5.General");
                    opcionGenero = sc.nextInt();

                    switch (opcionGenero) {

                        case 1:
                            biblioteca = new Biblioteca(nombreBiblioteca, nombreDirector, "Terror");
                            bibliotecas.add(bibliotecasCreadas, biblioteca);

                            bibliotecasCreadas++;
                            break;

                        case 2:
                            biblioteca = new Biblioteca(nombreBiblioteca, nombreDirector, "Comedia");
                            bibliotecas.add(bibliotecasCreadas, biblioteca);
                            bibliotecasCreadas++;
                            break;

                        case 3:
                            biblioteca = new Biblioteca(nombreBiblioteca, nombreDirector, "Ensayo");
                            bibliotecas.add(bibliotecasCreadas, biblioteca);
                            bibliotecasCreadas++;
                            break;

                        case 4:
                            biblioteca = new Biblioteca(nombreBiblioteca, nombreDirector, "Policiaca");
                            bibliotecas.add(bibliotecasCreadas, biblioteca);
                            bibliotecasCreadas++;
                            break;

                        case 5:
                            biblioteca = new Biblioteca(nombreBiblioteca, nombreDirector, "General");
                            bibliotecas.add(bibliotecasCreadas, biblioteca);
                            bibliotecasCreadas++;
                            break;

                    }break;

                case 2:
                    if (bibliotecasCreadas > 1) {

                        System.out.println("En que biblioteca deseas crear el catalogo?");
                        int cont = 1;
                        for (Biblioteca bibliotecaActual : bibliotecas) {
                            System.out.println(cont + "." + bibliotecaActual.getNombre());
                            cont++;
                        }
                        opcionBibliotecaElegida = sc.nextInt();
                        System.out.println("Ingresa el nombre del catalogo");
                        nombreCatalogo = sc.nextLine();
                        System.out.println("Ingresa la capacidad del catalogo");
                        capacidadCatalogo = sc.nextInt();
                        Biblioteca.Catalogo catalogo = new Biblioteca.Catalogo(capacidadCatalogo, nombreCatalogo);
                        bibliotecas.get(opcionBibliotecaElegida).meterCatalogo(catalogo);
                    } else {
                        System.out.println("No existe ninguna biblioteca todavia en la que crear un catalogo");
                    }break;
                case 3:
                    System.out.println("Ingresa el nombre del Libro");
                    nombreLibro = sc.nextLine();
                    System.out.println("Ingresa el nombre del autor");
                    nombreAutor = sc.nextLine();
                    System.out.println("Ingresa el número de páginas del libro");
                    nPaginasLibro = sc.nextInt();
                    System.out.println("Ingresa el ISBN del libro");
                    isbnLibro = sc.nextLine();
                    System.out.println("De que género es el libro?");
                    System.out.println("1.Terror");
                    System.out.println("2.Comedia");
                    System.out.println("3.Ensayo");
                    System.out.println("4.Policiaca");
                    opcionGeneroLibro = sc.nextInt();

                    switch (opcionGeneroLibro) {
                        case 1:
                            System.out.println("¿Qué calificación tiene el libro? (0-10)");
                            calificacionTerror = sc.nextInt();
                            LibroTerror terror = new LibroTerror(nombreLibro, nombreAutor, nPaginasLibro, isbnLibro, calificacionTerror);
                            libros.add(librosCreados, terror);
                            librosinventario.add(librosCreados, terror);
                            librosCreados++;
                            break;
                        case 2:
                            System.out.println("¿Qué tipo de humor tiene el libro?");
                            tipoHumorComedia = sc.nextLine();
                            LibroComedia comedia = new LibroComedia(nombreLibro, nombreAutor, nPaginasLibro, isbnLibro, tipoHumorComedia);
                            libros.add(librosCreados, comedia);
                            librosinventario.add(librosCreados, comedia);
                            librosCreados++;
                            break;
                        case 3:
                            System.out.println("¿De que epoca es el libro?");
                            epocaLibro = sc.nextLine();
                            LibroEnsayo ensayo = new LibroEnsayo(nombreLibro, nombreAutor, nPaginasLibro, isbnLibro, epocaLibro);
                            libros.add(librosCreados, ensayo);
                            librosinventario.add(librosCreados, ensayo);
                            librosCreados++;
                            break;
                        case 4:
                            System.out.println("¿Cuantos personajes aparecen en el libro?");
                            personajesLibro = sc.nextInt();
                            System.out.println("Indica la trama del libro: 1.Misterio | 2.Intriga");
                            opcionTrama = sc.nextInt();
                            if (opcionTrama == 1) {
                                tramaLibro = "Misterio";
                            } else if (opcionTrama == 2) {
                                tramaLibro = "Intriga";
                            }
                            LibroPoliciaca policiaca = new LibroPoliciaca(nombreLibro, nombreAutor, nPaginasLibro, isbnLibro, tramaLibro, personajesLibro);
                            libros.add(librosCreados, policiaca);
                            librosinventario.add(librosCreados, policiaca);
                                    librosCreados++;
                            break;
                    }break;
                case 4:
                    if (bibliotecasCreadas > 1) {
                        System.out.println("En que biblioteca deseas agregar el libro?");
                        int cont = 1;
                        for (Biblioteca bibliotecaActual : bibliotecas) {
                            System.out.println(cont + "." + bibliotecaActual.getNombre());
                            cont++;
                        }
                        opcionBibliotecaElegida = sc.nextInt();
                        System.out.println("¿Deseas meter el libro en un catalogo? 1.Si | 2.No");
                        opcionMeterCatalogo = sc.nextInt();
                        if (opcionMeterCatalogo == 1) {
                            bibliotecas.get(opcionBibliotecaElegida).mostrarCatalogos();
                            opcionCatalogoElegido = sc.nextInt();
                            catalogoElegido = (Biblioteca.Catalogo) bibliotecas.get(opcionBibliotecaElegida).getCatalogo().get(opcionCatalogoElegido);
                            System.out.println("Elija el libro que desea meter en el catalogo");
                            int count = 1;
                            for (Libro libroActual : libros) {
                                System.out.println(count + "." + libroActual.getNombre());
                            }
                            libroElegido = sc.nextInt();
                            catalogoElegido.meterLibro(libros.get(libroElegido - 1));
                            bibliotecas.get(opcionBibliotecaElegida).meterLibrosTotales(libros.get(libroElegido - 1));
                            libros.remove(libroElegido - 1);
                        } else if (opcionMeterCatalogo == 2) {
                            bibliotecas.get(opcionBibliotecaElegida).meterLibro(libros.get(libroElegido - 1));
                            bibliotecas.get(opcionBibliotecaElegida).meterLibrosTotales(libros.get(libroElegido - 1));
                            libros.remove(libroElegido - 1);
                        }
                    } else {
                        System.out.println("No existe ninguna biblioteca todavia en la que crear un catalogo");
                    }
                    break;
                case 5:
                    if (bibliotecasCreadas > 1) {
                        System.out.println("De que biblioteca deseas eliminar el libro?");
                        int cont = 1;
                        for (Biblioteca bibliotecaActual : bibliotecas) {
                            System.out.println(cont + "." + bibliotecaActual.getNombre());
                            cont++;
                        }
                        opcionBibliotecaElegida = sc.nextInt();
                        System.out.println("Elige el libro a eliminar en la biblioteca");
                        int count = 1;
                        bibliotecas.get(opcionBibliotecaElegida).mostrarLibrosTotales();
                        opcionLibroElegido = sc.nextInt();
                        librosTotalesEnBiblioteca = bibliotecas.get(opcionBibliotecaElegida - 1).getLibrosTotales();
                        isbnLibroElegido = librosTotalesEnBiblioteca.get(opcionLibroElegido - 1).getIsbn();
                        bibliotecas.get(opcionBibliotecaElegida).eliminarLibro(isbnLibroElegido);
                        librosinventario.remove(opcionLibroElegido - 1);
                    }break;
                case 6:
                    if (librosinventario != null) {
                        System.out.println("Inserte el ISBN del libro");
                        isbnLibroElegido = sc.nextLine();
                        boolean encontrado = false;
                        for (Libro libroActual : librosinventario) {
                            if (libroActual.getIsbn().equals(isbnLibroElegido)) {
                                libroActual.mostrarDatos();
                                encontrado = true;
                            }
                        }
                        if(encontrado == false){
                            System.out.println("No se encontro el libro");
                        }
                    }else {
                        System.out.println("No existen libros creados");
                    }break;
                case 7:
                    if (bibliotecasCreadas > 1) {
                        System.out.println("De que biblioteca deseas mostrar los libros de un catalogo?");
                        int cont = 1;
                        for (Biblioteca bibliotecaActual : bibliotecas) {
                            System.out.println(cont + "." + bibliotecaActual.getNombre());
                            cont++;
                        }
                        opcionBibliotecaElegida = sc.nextInt();
                        System.out.println("De que catalogo deseas mostrar sus libros?");
                        bibliotecas.get(opcionBibliotecaElegida).mostrarCatalogos();
                        opcionCatalogoElegido = sc.nextInt();
                        catalogoElegido = (Biblioteca.Catalogo) bibliotecas.get(opcionBibliotecaElegida).getCatalogo().get(opcionCatalogoElegido);
                        catalogoElegido.mostrarLibros();
                    } else {
                        System.out.println("No existe ninguna biblioteca todavia en la que crear un catalogo");
                    }
                    break;
                case 8:
                    for (Libro libroActual:librosinventario ){
                        libroActual.mostrarDatos();
                    }break;
                case 9:
                    FicherosLibros ficherosLibros = new FicherosLibros();
                    ficherosLibros.EscribirObjetoLibros();
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
                    break;

            }
        } while (opcion != 0);
    }
}
