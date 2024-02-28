import java.util.Objects;
import java.util.Scanner;
import java.util.regex.*;
public class Entrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String marca;
        String modelo;
        int cv;
        int cc;
        String matricula;

        System.out.println("¿Qué marca es tu coche 1?");
        marca = scanner.nextLine();


        System.out.println("¿Qué modelo es tu coche 1?");
        modelo = scanner.nextLine();

        do {
            System.out.println("¿Cuántos CV tiene tu coche 1?");
            cv = scanner.nextInt();
            if (cv > 75 && cv <=1000) {
                break;
            }else {
                System.out.println("Los CV de tu coche deben ser un número entero comprendido entre 75 y 1000");
                System.out.println("Vuelve a introducir los CV de tu coche 1");
            }
        } while (true);


        do {
            System.out.println("¿Cuántos cc tiene tu coche 1?");
            cc = scanner.nextInt();
            scanner.nextLine();
            if (cc >= 80 && cc <= 200) {
                break;
            }else {
                System.out.println("Los cc de tu coche deben ser un número entero comprendido entre 80 y 200");
                System.out.println("Vuelve a introducir los cc de tu coche 1");
            }
        } while (true);


        Pattern patronMatricula = Pattern.compile("\\b\\d{4}[A-Z]{3}\\b");

        do {
            System.out.println("¿Qué matrícula tiene tu coche 1?");
            matricula = scanner.nextLine();

            // Crear un objeto Matcher para la matrícula
            Matcher matcher = patronMatricula.matcher(matricula);

            // Verificar si la matrícula coincide con el patrón
            if (matcher.find()) {
                break;
            } else {
                System.out.println("La matrícula de tu coche 1 debe contener 4 números y 3 letras mayúsculas");
                System.out.println("Vuelve a introducir la matrícula de tu coche 1");
            }
        } while (true);


        //Creo mi primer coche
        Coche coche1 = new Coche(marca, modelo, cv, cc, matricula);


        System.out.println("¿Qué marca es tu coche 2?");
        marca = scanner.nextLine();


        System.out.println("¿Qué modelo es tu coche 2?");
        modelo = scanner.nextLine();

        do {
            System.out.println("¿Cuántos CV tiene tu coche 2?");
            cv = scanner.nextInt();
            scanner.nextLine();
            if (cv >= 75 && cv <=1000) {
                break;
            }else {
                System.out.println("Los CV de tu coche deben ser un número entero comprendido entre 75 y 1000");
                System.out.println("Vuelve a introducir los CV de tu coche 2");
            }
        } while (true);


        do {
            System.out.println("¿Cuántos cc tiene tu coche 2?");
            cc = scanner.nextInt();
            scanner.nextLine();
            if (cc >= 80 && cc <= 200) {
                break;
            }else {
                System.out.println("Los cc de tu coche deben ser un número entero comprendido entre 80 y 200");
                System.out.println("Vuelve a introducir los cc de tu coche 2");
            }
        } while (true);


        //Pattern patronMatricula = Pattern.compile("\\b\\d{4}[A-Z]{3}\\b");

        do {
            System.out.println("¿Qué matrícula tiene tu coche 2?");
            matricula = scanner.nextLine();

            // Crear un objeto Matcher para la matrícula
            Matcher matcher = patronMatricula.matcher(matricula);

            // Verificar si la matrícula coincide con el patrón
            if (matcher.find()) {
                break;
            } else {
                System.out.println("La matrícula de tu coche 1 debe contener 4 números y 3 letras mayúsculas");
                System.out.println("Vuelve a introducir la matrícula de tu coche 2");
            }
        } while (true);

        //Creo mi segundo coche
        Coche coche2 = new Coche(marca, modelo, cv, cc, matricula);


        //Pregunto al usuario cuántas vueltas quiere dar y cuántos kilómetros totales tendrán que recorrer los coches
        System.out.println("¿Cuántas vueltas quieres que den los participantes?");
        int nVueltas = scanner.nextInt();
        scanner.nextLine();

        //Creo una carrera
        Carrera nuevaCarrera = new Carrera(coche1, coche2);
        nuevaCarrera.iniciarCarrera();

    }



}
