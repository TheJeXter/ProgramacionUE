import java.util.Scanner;
public class Carrera {

    //Genero los atributos de la carrera mencionados en el enunciado
    private int kmTotales;
    private int nVueltas;
    private Coche coche1;
    private Coche coche2;


    public Carrera (Coche coche1, Coche coche2) {
        this.coche1 = coche1;
        this.coche2 = coche2;

    }

    //Creo el método iniciarCarrera
    public void iniciarCarrera () {

        //LLamo al método mostrarDatos para que muestre los datos de los coches al inicio de la carrera
        System.out.println("Coche 1");
        this.coche1.mostrarDatos();

        System.out.println("Coche 2");
        this.coche2.mostrarDatos();

        //Pregunto al usuario cuántos kilómetros recorrerá el usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos kilómetros quieres que recorran los coches?");
        kmTotales = scanner.nextInt();


        //Cada participante realizará tantas aceleraciones como vueltas indique el circuito
        for (int vuelta =1; vuelta <= nVueltas; vuelta++){
            this.coche1.acelerar();
            this.coche2.acelerar();
        }

        //Si han terminado las vueltas y algún coche ha alcanzado como mínimo el total de km la carrera terminará
        if (coche1.getKmRecorridos()< kmTotales || coche2.getKmRecorridos()< kmTotales) {
        //no llega a los km totales
            boolean terminarCarrera = false;
            do {
                //dar una vuelta
                System.out.println("Coche 1:");
                this.coche1.acelerar();
                System.out.println("Coche 2:");
                this.coche2.acelerar();
                this.nVueltas = this.nVueltas + 1;
                System.out.println("Vuelta "+ (this.nVueltas + 1));
                if (coche1.getKmRecorridos() >= kmTotales || coche2.getKmRecorridos() >= kmTotales) {
                    terminarCarrera = true;
                }
            }while(!terminarCarrera);
        }
        //Elijo a un ganador
        if (coche1.getKmRecorridos() >= kmTotales && coche2.getKmRecorridos() >= kmTotales ) {

            System.out.println("Ha habido un empate entre ambos coches");
        } else if (coche1.getKmRecorridos() >= kmTotales) {

            System.out.println("El ganador ha sido el coche con matrícula " + coche1.getMatricula());
        }else {
            System.out.println("El ganador ha sido el coche con matrícula " + coche2.getMatricula());
        }
    }
}

