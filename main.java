import java.util.concurrent.Semaphore;

public class main {


    public static void main(String[] args) {
        char[] texto = new char[10];
        char[] Upper = new char[10];

        Semaphore Gerador = new Semaphore(1);
        Semaphore Filtro = new Semaphore(0);
        Semaphore FiltroExt = new Semaphore(1);
        Semaphore Analisador =new Semaphore(0);

        Gerador gerador  = new Gerador(texto,Gerador,Filtro);
        Filtro filtro = new Filtro(texto,Upper,Gerador,Filtro,FiltroExt,Analisador);
        Analisador analisador = new Analisador(Upper,FiltroExt,Analisador);

        try{
            gerador.start();
            filtro.start();
            analisador.start();

        }catch (Exception e ){
            e.printStackTrace();
        }

    }
}
