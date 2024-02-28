import java.util.Scanner;

public class Coche {
    //Creo los atributos que tiene el coche
    private String marca;
    private String modelo;
    private int cv;
    private int cc;
    private String matricula;
    private int velocidad;
    private double kmRecorridos;

    //Creo un constructor para la clase coche

    public Coche(String marca, String modelo, int cv, int cc, String matricula) {

        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.cc = cc;
        this.matricula = matricula;
        velocidad = 0;
        kmRecorridos = 0;



    }


    public void mostrarDatos () {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("CV: " + cv);
        System.out.println("cc: " + cc);
        System.out.println("Matrícula: " + matricula);
    }



    //Creo un método para que el coche acelere
    public void acelerar () {

        //Creo un objeto de la clase scanner
        Scanner scanner = new Scanner(System.in);

        //Pregunto al usuario cúanto quiere acelerar
        System.out.println("¿Cuántos kilómetros quieres acelerar?");
        int pisarAcelerador = scanner.nextInt();

        //Un coche deberá acelerar como mínimo 10km/h
        if (pisarAcelerador < 10) {
            System.out.println("Debes acelerar como mínimo 10 Km/h");

            //Si el coche tiene menos de 100 CV, acelerará una velocidad aleatoria entre 0 y la velocidad indicada
        } else if (cv < 100) {
                this.velocidad += (int)Math.floor(Math.random() * pisarAcelerador);

                //Si el coche tiene más de 100 cv, acelerará una velocidad aleatoria entre 10 y la velocidad indicada
            } else {
                this.velocidad += (int)Math.floor((Math.random() * pisarAcelerador) + 10);
            }
        //los km del coche se incrementarán en el 50% de la velocidad a la que va el coche
        this.kmRecorridos = kmRecorridos + (this.velocidad * 0.5);





    }

    //Creo mis métodos get para poder acceder a mis variables

    public double getKmRecorridos() {
        return this.kmRecorridos;
    }
    public String getMatricula() {
        return this.matricula;
    }

    public int getCc() {
        return this.cc;
    }

    public int getVelocidad() {
        return this.velocidad;
    }
}
