import java.util.concurrent.Semaphore;
import java.lang.*;

public class Filtro extends Thread {

    private char[] texto;
    private char[] Upper;
    private String text = "" ;

    private Semaphore Gerador ;
    private Semaphore Filtro ;
    private Semaphore FiltroExt;
    private Semaphore Analisador;

    public Filtro(char[] texto,char[] Upper, Semaphore Gerador,Semaphore Filtro,Semaphore FiltroExt,Semaphore Analisador){
        this.texto = texto;
        this.Upper = Upper;

        this.Gerador = Gerador;
        this.Filtro = Filtro;
        this.FiltroExt = FiltroExt;
        this.Analisador = Analisador;
    }

    public  void run() {
            try {
                while (true){
                    Filtro.acquire();
                    FiltroExt.acquire();
                    for (int i = 0; i < 10; i++) {
                        this.Upper[i] = Character.toUpperCase(this.texto[i]);
                    }
                    Gerador.release();
                    Analisador.release();



                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




