import java.util.Scanner;

public class Bingo {

    //Atributos
    private int[] bolas;
    private int bolasSacadas;

    //Constructor
    public Bingo () {
        this.bolas =new int[99];
        this.bolasSacadas = 0;

    }

    //Getter
    public int getBolasSacadas () {
        return bolasSacadas;
    }

    //Metodos

    //Genera un array de 10 numeros aleatorios que no se repiten del 1-99
    public int[] pedirCarton() {
        int[] carton = new int[10];
        int lleno = 0;
        boolean repetido;
        while(lleno != 10) {
            repetido = false;
            do {
                int numeroAleatorio = (int) (Math.random() * 99 + 1);
                for (int i = 0; i < carton.length; i++) {
                    if (numeroAleatorio == carton[i]) {
                        repetido = true;
                        break;
                    }
                }
                if (!repetido) {
                    carton[lleno] = numeroAleatorio;
                    lleno++;
                }
            } while (repetido);
        }
        return carton;
    }

    //Pide una apuesta al usuario la cual se ingresa por el teclado
    public double pedirApuesta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su apuesta: ");
        return scanner.nextDouble();
    }

    //Pide el numero que el jugador cree que necesitara para acertar el bingo
    public int pedirTotalNumeros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese en cuantos números prevé que acertará el bingo: ");
        return scanner.nextInt();
    }

    //Saca una nueva bola no repetida del 1-99
    public int nuevaBola () {
        boolean repetido;
        int numeroAleatorio;
        do {
            repetido = false;
            numeroAleatorio = (int)(Math.random()*99+1);
            for(int i = -1; i < this.bolasSacadas; i++){
                if(numeroAleatorio == this.bolas[i+1]){
                    repetido = true;
                    break;
                }
            }
            if(!repetido){
                this.bolas[this.bolasSacadas] = numeroAleatorio;
                this.bolasSacadas++;
            }
        }while(repetido);
        return numeroAleatorio;
    }

    public boolean comprobarApuesta(double apuesta){
        if(apuesta == this.bolasSacadas) {
            return true;
        }else{
            return false;
        }
    }

    public boolean comprobarLinea (boolean[] aciertos, int[] carton) {

        boolean ganaLinea = false;

        if(aciertos[0]&&aciertos[1]&&aciertos[2]&&aciertos[3]&&aciertos[4]){
            ganaLinea = true;
            System.out.println("¡Has cantado linea! Se canto en: " + this.getBolasSacadas());
            System.out.println(carton[0]+"|"+carton[1]+"|"+carton[2]+"|"+carton[3]+"|"+carton[4]);
        }
        if(aciertos[5]&&aciertos[6]&&aciertos[7]&&aciertos[8]&&aciertos[9]){
            ganaLinea = true;
            System.out.println("¡Has cantado linea! Se canto en: " + this.getBolasSacadas());
            System.out.println(carton[5]+"|"+carton[6]+"|"+carton[7]+"|"+carton[8]+"|"+carton[9]);
        }

        return ganaLinea;
    }


    public boolean comprobarBingo (boolean[] aciertos) {

        boolean ganaBingo = true;

        for (int i = 0; i < 10; i++){
            if (!aciertos[i]) {
                ganaBingo = false;
                break;
            }
        }

        return ganaBingo;

    }

    public boolean[] comprobarCarton (int[] carton,boolean[] aciertos, int bolaActual) {

        for(int i = 0; i < carton.length; i++){
            if(bolaActual == carton[i]) {
                aciertos[i] = true;
                break;
            }
        }

        return aciertos;

    }


    //Se ejecuta el bingo con todos sus metodos
    public static void main (String[]args){

        Bingo bingo = new Bingo();
        int[] carton = bingo.pedirCarton();
        System.out.println("Este es tu carton:");
        System.out.println(carton[0] + "|" + carton[1] + "|" + carton[2] + "|" + carton[3] + "|" + carton[4]);
        System.out.println(carton[5] + "|" + carton[6] + "|" + carton[7] + "|" + carton[8] + "|" + carton[9]);
        double apuesta = bingo.pedirApuesta();
        int totalNumeros = bingo.pedirTotalNumeros();
        boolean finBingo = false;
        boolean cantaLinea = false;
        boolean[] aciertos = new boolean[10];
        int bolaActual;

        while(!finBingo) {
            bolaActual = bingo.nuevaBola();
            try {
                Thread.sleep(1*1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Bola numero: " + bolaActual);
            aciertos = bingo.comprobarCarton(carton, aciertos, bolaActual);

            if(!cantaLinea){
                cantaLinea = bingo.comprobarLinea(aciertos,carton);
            }

            finBingo = bingo.comprobarBingo(aciertos);
        }

        System.out.println("¡Has cantado Bingo!");

        if (bingo.comprobarApuesta(totalNumeros)) {
            System.out.println("¡Has ganado la apuesta! Tu recompensa es de: " + (apuesta*10) + " puntos.");
        }else{
            System.out.println("Has perdido la apuesta, el bingo se cantó en " + bingo.getBolasSacadas()+ ", y tú apostaste que saldría en " + totalNumeros + ".");
        }

    }
}