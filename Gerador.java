import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Gerador extends Thread {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXWYZabcdefghijklmnopqrstuvxwyz";
    private char[] alphabet2;
    private Random r = new Random();
    private char[] texto ;
    private Semaphore Gerador;
    private Semaphore Filtro ;

    public Gerador(char[] texto,Semaphore Gerador,Semaphore Filtro){
        this.texto = texto;
        this.Gerador= Gerador;
        this.Filtro = Filtro;
    }

    public void run(){
        try{
            while(true){
                Gerador.acquire();
                alphabet2 = alphabet.toCharArray();
                for (int i = 0; i < 10; i++) {
                    texto[i] =  alphabet2[r.nextInt(51)];
                }
                System.out.println("texto gerado: " +Arrays.toString(texto));
                Filtro.release();
            }


        }catch (Exception e ){
            e.printStackTrace();
        }


    }


}
